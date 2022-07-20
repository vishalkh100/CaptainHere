package com.example.captainhere.Functions;

import com.example.captainhere.Models.Product;
import com.example.captainhere.Models.Table;

import java.util.ArrayList;

public class DataGetSet {

    // variables

    private static ArrayList<Table> arrayOfTables = new ArrayList<Table>();
    private static ArrayList<Product> arrayOfProducts = new ArrayList<Product>();


    // methods

    public ArrayList<Table> getArrayOfUsers() {
        return arrayOfTables;
    }
    public void setArrayOfUsers(ArrayList<Table> arrayOfTables) {
        this.arrayOfTables = arrayOfTables;
    }
    
    public static void addTable(Table table) {
        arrayOfTables.add(table);
    }
    public static void removeTable(Table table) {
        arrayOfTables.remove(table);
    }

    public ArrayList<Product> getArrayOfProducts() {
        return arrayOfProducts;
    }
    public static void addProduct(Product product) {
        arrayOfProducts.add(product);
    }
    public static void removeProduct(Product product) {
        arrayOfProducts.remove(product);
    }

}
