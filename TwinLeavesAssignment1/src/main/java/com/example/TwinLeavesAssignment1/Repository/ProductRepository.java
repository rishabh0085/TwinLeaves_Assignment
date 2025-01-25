package com.example.TwinLeavesAssignment1.Repository;

import com.example.TwinLeavesAssignment1.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
