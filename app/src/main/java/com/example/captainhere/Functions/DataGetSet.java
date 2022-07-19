package com.example.captainhere.Functions;

import com.example.captainhere.Models.Table;

import java.util.ArrayList;

public class DataGetSet {

    // variables
    private String test1 = "default";
    private static ArrayList<Table> arrayOfTables = new ArrayList<Table>();


    // methods
    public String getTest1() {
        return test1;
    }
    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public ArrayList<Table> getArrayOfUsers() {
        return arrayOfTables;
    }
    public void setArrayOfUsers(ArrayList<Table> arrayOfTables) {
        this.arrayOfTables = arrayOfTables;
    }
    public void addTable(Table table) {
        arrayOfTables.add(table);
    }
    public void removeTable(Table table) {
        arrayOfTables.remove(table);
    }

}
