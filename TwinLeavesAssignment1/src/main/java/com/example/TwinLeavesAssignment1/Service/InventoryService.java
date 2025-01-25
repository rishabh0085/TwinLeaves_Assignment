package com.example.TwinLeavesAssignment1.Service;

import com.example.TwinLeavesAssignment1.Entities.Batch;
import com.example.TwinLeavesAssignment1.Entities.Gtin;
import com.example.TwinLeavesAssignment1.Entities.Product;
import com.example.TwinLeavesAssignment1.Repository.BatchRepository;
import com.example.TwinLeavesAssignment1.Repository.GtinRepository;
import com.example.TwinLeavesAssignment1.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private GtinRepository gtinRepository;

    @Autowired
    private BatchRepository batchRepository;

    public String createProduct(Product product) throws Exception {
        // Simulating a possible exception (e.g., database failure)
        productRepository.save(product);
        return "New product has been added successfully to the database!";
    }

    public String createGtin(Gtin gtin) throws Exception {

        Optional<Product> optionalProduct = productRepository.findById(gtin.getProduct().getPid());
        if (optionalProduct.isEmpty())
        {
            throw new Exception("Product not found!");
        }

        Product product = optionalProduct.get();

        gtin.setProduct(product);

        gtinRepository.save(gtin); // Now save the GTIN object

        return "New GTIN has been added successfully to the database!";
    }

    public String createBatch(Batch batch) throws Exception {

        batchRepository.save(batch);
        return "New batch has been added successfully to the database!";

    }

    public List<Gtin> getGtinsWithPositiveQuantity() throws Exception {
        // Simulating a possible exception
        return gtinRepository.findGtinsWithPositiveBatchQuantity();
    }

    public List<Batch> getLatestNegativeOrZeroQuantityBatches() throws Exception {
        // Simulating a possible exception
        return batchRepository.findLatestNegativeOrZeroQuantityBatch();
    }
}
