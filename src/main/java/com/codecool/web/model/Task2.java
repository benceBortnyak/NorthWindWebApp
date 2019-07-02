package com.codecool.web.model;

public class Task2 {
    private String product;
    private Integer products;

    public Task2(String product, Integer products) {
        this.product = product;
        this.products = products;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getProducts() {
        return products;
    }

    public void setProducts(Integer products) {
        this.products = products;
    }
}
