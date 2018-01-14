package com.jpenterprise.pgl.repositories;

import com.jpenterprise.pgl.models.Product;

public class StoreRepositoryImpl implements StoreRepository {
    @Override
    public Product getProductByName(String productName) {
        return null;
    }

    @Override
    public Product[] listProductByCategory(String category) {
        return new Product[0];
    }

    @Override
    public Product[] listAllProducts() {
        return new Product[0];
    }
}
