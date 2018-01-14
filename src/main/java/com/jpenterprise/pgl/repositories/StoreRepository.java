package com.jpenterprise.pgl.repositories;

import com.jpenterprise.pgl.models.Product;

public interface StoreRepository {

    Product getProductByName(String productName);
    Product[] listProductByCategory(String category);
    Product[] listAllProducts();
}
