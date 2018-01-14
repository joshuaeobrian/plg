package com.jpenterprise.pgl.apiControllers;

import com.jpenterprise.pgl.models.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/store")
public class StoreRestController {
    @GetMapping("/products")
    public Product[] getListOfAllProducts(){
        //todo: We need to return all available products
        return null;
    }
    @PostMapping("/products/{productType}")
    public Product[] getListOfSpecificProductsByType(){
        //todo: We need to get the product type and return a list of those products
        return null;
    }
    @GetMapping("products/{productName}")
    public Product getSpecificProduct(){
        //todo: we need to return a product object with a specific name from the database
        return new Product();
    }
}
