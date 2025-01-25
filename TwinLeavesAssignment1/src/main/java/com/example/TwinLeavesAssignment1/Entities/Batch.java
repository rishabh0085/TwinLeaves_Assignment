package com.example.TwinLeavesAssignment1.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

// Batch Entity
@Entity
@Table(name = "batch")
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long batchId;
    private Integer mrp;
    private Integer sp;
    private Integer purchasePrice;
    private Integer availableQuantity;
    private LocalDate inwardedOn;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "gid")
    private Gtin gtin;

    // No-args constructor
    public Batch() {
    }

    // All-args constructor
    public Batch(Long batchId, Integer mrp, Integer sp, Integer purchasePrice, Integer availableQuantity, LocalDate inwardedOn, Gtin gtin) {
        this.batchId = batchId;
        this.mrp = mrp;
        this.sp = sp;
        this.purchasePrice = purchasePrice;
        this.availableQuantity = availableQuantity;
        this.inwardedOn = inwardedOn;
        this.gtin = gtin;
    }

    // Getters and setters
    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Integer getMrp() {
        return mrp;
    }

    public void setMrp(Integer mrp) {
        this.mrp = mrp;
    }

    public Integer getSp() {
        return sp;
    }

    public void setSp(Integer sp) {
        this.sp = sp;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public LocalDate getInwardedOn() {
        return inwardedOn;
    }

    public void setInwardedOn(LocalDate inwardedOn) {
        this.inwardedOn = inwardedOn;
    }

    public Gtin getGtin() {
        return gtin;
    }

    public void setGtin(Gtin gtin) {
        this.gtin = gtin;
    }
}
