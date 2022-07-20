package com.example.captainhere.Models;

public class Product {

    public String name;
    public String mrp;

    public Product(String name, String mrp) {
        this.name = name;
        this.mrp = mrp;
    }

    public String toString() {
        String toString = "";
        toString = "Name: " + name + " MRP:" + mrp;
        return toString;
    }

}
