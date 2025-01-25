package com.example.TwinLeavesAssignment1.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    private String productName;
    private LocalDate createdOn;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Gtin> gtins;

    // No-args constructor
    public Product() {
    }

    // All-args constructor
    public Product(Long pid, String productName, LocalDate createdOn, List<Gtin> gtins) {
        this.pid = pid;
        this.productName = productName;
        this.createdOn = createdOn;
        this.gtins = gtins;
    }

    // Getters and setters
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public List<Gtin> getGtins() {
        return gtins;
    }

    public void setGtins(List<Gtin> gtins) {
        this.gtins = gtins;
    }
}
