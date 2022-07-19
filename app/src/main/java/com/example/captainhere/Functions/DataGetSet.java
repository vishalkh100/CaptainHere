package com.example.captainhere.Functions;

import com.example.captainhere.Models.Table;

import java.util.ArrayList;

public class DataGetSet {

    // variables

    private static ArrayList<Table> arrayOfTables = new ArrayList<Table>();


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

}
