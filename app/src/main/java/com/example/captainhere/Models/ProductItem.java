package com.example.captainhere.Models;

public class ProductItem {
    public String name;
    public Product product;

    public ProductItem(String name, Product product) {
        this.name = name;
        this.product = product;
    }

    public String toString() {
        String toString = "";
        toString = "Name: " + name + " Product: " + product;
        return toString;
    }
}
