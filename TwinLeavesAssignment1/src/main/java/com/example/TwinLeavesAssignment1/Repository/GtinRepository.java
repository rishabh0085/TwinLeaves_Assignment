package com.example.TwinLeavesAssignment1.Repository;

import com.example.TwinLeavesAssignment1.Entities.Gtin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GtinRepository extends JpaRepository<Gtin, Long> {

    @Query("SELECT gtin FROM Gtin gtin JOIN gtin.batches batch WHERE batch.availableQuantity > 0")
    List<Gtin> findGtinsWithPositiveBatchQuantity();

}