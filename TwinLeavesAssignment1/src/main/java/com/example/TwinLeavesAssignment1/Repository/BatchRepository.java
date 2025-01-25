package com.example.TwinLeavesAssignment1.Repository;

import com.example.TwinLeavesAssignment1.Entities.Batch;
import com.example.TwinLeavesAssignment1.Entities.Gtin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
    @Query(value = "SELECT * FROM Batch batch WHERE batch.available_quantity <= 1 ORDER BY batch.inwarded_on DESC", nativeQuery = true)
    List<Batch> findLatestNegativeOrZeroQuantityBatch();

}