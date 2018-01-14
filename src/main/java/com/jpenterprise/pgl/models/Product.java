package com.jpenterprise.pgl.models;

public class Product {
    private Integer id;
    private String productType;
    private String productName;
    private String category;
    private Double price;

    public Product() {
    }

    public Product(Integer id, String productType, String productName, String category, Double price) {
        this.id = id;
        this.productType = productType;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
