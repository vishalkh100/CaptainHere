package com.example.captainhere.Functions;

import android.util.Log;

import com.example.captainhere.Models.Product;
import com.example.captainhere.Models.ProductItem;
import com.example.captainhere.Models.Table;

import java.util.ArrayList;
import java.util.Objects;

public class DataGetSet {

    // variables

    private static ArrayList<Table> arrayOfTables = new ArrayList<>();
    private static ArrayList<Product> arrayOfProducts = new ArrayList<>();
    private static ArrayList<ProductItem> arrayOfProductItems = new ArrayList<>();
    private static Table selectedTable;
    private static Product selectedProduct;
    static TinyDB tinyDB = new TinyDB(App.context);


    // methods

    public ArrayList<Table> getArrayOfUsers() {
        return arrayOfTables;
    }

    public void setArrayOfUsers(ArrayList<Table> arrayOfTables) {
        this.arrayOfTables = arrayOfTables;
    }

    public static ArrayList<ProductItem> getArrayOfProductItems() {
        return arrayOfProductItems;
    }

    public static void setArrayOfProductItems(ArrayList<ProductItem> arrayOfProductItems) {
        DataGetSet.arrayOfProductItems = arrayOfProductItems;
        ArrayList<Object> productItemObjects = new ArrayList<>();

        for(ProductItem p : arrayOfProductItems) {
            productItemObjects.add((Object)p);
        }
        tinyDB.putListObject("productItemList", productItemObjects);
    }

    public static void addProductItem(ProductItem productItem) {
        arrayOfProductItems.add(productItem);
        ArrayList<Object> productItemObjects = new ArrayList<>();

        for(ProductItem p : arrayOfProductItems) {
            productItemObjects.add((Object)p);
        }
        tinyDB.putListObject("productItemList", productItemObjects);
    }
    
    public static void addTable(Table table) {
        arrayOfTables.add(table);
        ArrayList<Object> tableObjects = new ArrayList<>();

        for(Table p : arrayOfTables){
            tableObjects.add((Object)p); // casting to raw objects
        }
        tinyDB.putListObject("tableList", tableObjects);
    }

    public static void removeTable(Table table) {
        Log.d("removeTable", "reached");
        arrayOfTables.remove(table);

        ArrayList<Object> tableObjects = new ArrayList<>();

        for(Table p : arrayOfTables){
            if(!p.equals(table)) {
                tableObjects.add((Object)p); // casting to raw objects
            }
        }
        tinyDB.putListObject("tableList", tableObjects);
    }

    public ArrayList<Product> getArrayOfProducts() {
        return arrayOfProducts;
    }

    public void setArrayOfProducts(ArrayList<Product> arrayOfProducts) {
        this.arrayOfProducts = arrayOfProducts;
    }

    public static void addProduct(Product product) {
        arrayOfProducts.add(product);
        ArrayList<Object> productObjects = new ArrayList<>();

        for(Product p : arrayOfProducts){
            productObjects.add((Object)p); // casting to raw objects
        }
        tinyDB.putListObject("productList", productObjects);
    }

    public static void removeProduct(Product product) {
        arrayOfProducts.remove(product);

        ArrayList<Object> productObjects = new ArrayList<>();

        for(Product p : arrayOfProducts){
            if(!p.equals(product)) {
                productObjects.add((Object) p); // casting to raw objects
            }
        }
        tinyDB.putListObject("productList", productObjects);
    }

    public Table getSelectedTable() {
        return selectedTable;
    }

    public void setSelectedTable(Table selectedTable) {
        this.selectedTable = selectedTable;
    }

    public static Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }



}
