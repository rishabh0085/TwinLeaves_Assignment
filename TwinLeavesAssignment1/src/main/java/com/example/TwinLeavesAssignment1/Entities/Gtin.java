package com.example.TwinLeavesAssignment1.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

// Gtin Entity
@Entity
@Table(name = "gtin")
public class Gtin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gid;
    private String gtin;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pid")
    private Product product;

    @JsonIgnore
    @OneToMany(mappedBy = "gtin", cascade = CascadeType.ALL)
    private List<Batch> batches;

    // No-args constructor
    public Gtin() {
    }

    // All-args constructor
    public Gtin(Long gid, String gtin, Product product, List<Batch> batches) {
        this.gid = gid;
        this.gtin = gtin;
        this.product = product;
        this.batches = batches;
    }

    // Getters and setters
    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Batch> getBatches() {
        return batches;
    }

    public void setBatches(List<Batch> batches) {
        this.batches = batches;
    }
}
