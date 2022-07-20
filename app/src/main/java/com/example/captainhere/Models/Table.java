package com.example.captainhere.Models;

public class Table {

    public String name;
    public String total;

    public Table(String name, String total) {
        this.name = name;
        this.total = total;
    }

    public String toString() {
        String toString = "";
        toString = "Name: " + name + " Total:" + total;
        return toString;
    }

}