package com.example.captainhere.Functions;

import com.example.captainhere.Models.Product;
import com.example.captainhere.Models.Table;

import java.util.ArrayList;

public class DataGetSet {

    // variables

    private static ArrayList<Table> arrayOfTables = new ArrayList<Table>();
    private static ArrayList<Product> arrayOfProducts = new ArrayList<Product>();

    static TinyDB tinyDB = new TinyDB(App.context);


    // methods

    public ArrayList<Table> getArrayOfUsers() {
        return arrayOfTables;
    }

    public void setArrayOfUsers(ArrayList<Table> arrayOfTables) {
        this.arrayOfTables = arrayOfTables;
    }
    
    public static void addTable(Table table) {
        arrayOfTables.add(table);
        ArrayList<Object> tableObjects = new ArrayList<Object>();

        for(Table p : arrayOfTables){
            tableObjects.add((Object)p); // casting to raw objects
        }
        tinyDB.putListObject("tableList", tableObjects);
    }

    public static void removeTable(Table table) {
        arrayOfTables.remove(table);
    }

    public ArrayList<Product> getArrayOfProducts() {
        return arrayOfProducts;
    }

    public void setArrayOfProducts(ArrayList<Product> arrayOfProducts) {
        this.arrayOfProducts = arrayOfProducts;
    }

    public static void addProduct(Product product) {
        arrayOfProducts.add(product);
        ArrayList<Object> productObjects = new ArrayList<Object>();

        for(Product p : arrayOfProducts){
            productObjects.add((Object)p); // casting to raw objects
        }
        tinyDB.putListObject("productList", productObjects);
    }

    public static void removeProduct(Product product) {
        arrayOfProducts.remove(product);
    }

}
