package com.example.TwinLeavesAssignment1.Controller;

import com.example.TwinLeavesAssignment1.Entities.Batch;
import com.example.TwinLeavesAssignment1.Entities.Gtin;
import com.example.TwinLeavesAssignment1.Entities.Product;
import com.example.TwinLeavesAssignment1.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/AddProduct")
    public ResponseEntity addProduct(@RequestBody Product product) {
        try {
            String result = inventoryService.createProduct(product);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error while adding product: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/AddGtin")
    public ResponseEntity addGtin(@RequestBody Gtin gtin) {
        try {
            String result = inventoryService.createGtin(gtin);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/AddBatch")
    public ResponseEntity addBatch(@RequestBody Batch batch) {
        try {
            String result = inventoryService.createBatch(batch);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error while adding batch: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/gtins-positive-quantity")
    public ResponseEntity getGtinsWithPositiveQuantity() {
        try {
            List<Gtin> gtins = inventoryService.getGtinsWithPositiveQuantity();
            return new ResponseEntity (gtins, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity ("Error while fetching GTINs: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/batches-latest-negative-zero")
    public ResponseEntity getLatestNegativeOrZeroQuantityBatches() {
        try {
            List<Batch> batches = inventoryService.getLatestNegativeOrZeroQuantityBatches();
            return new ResponseEntity (batches, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity ("Error while fetching batches: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


