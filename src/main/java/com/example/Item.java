package com.example;

public class Item {
    private int ID;
    private String name;
    private double price;

    public Item(int ID, String name, double price){
        this.ID = ID;
        this.name = name;
        this.price = price;
    }

    public int get_id(){
        return ID;
    }
    
    public String get_name(){
        return name;
    }

    public double get_price(){
        return price;
    }
}
