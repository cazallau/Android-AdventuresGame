package com.cazallau.adventure.Model;

import java.util.LinkedList;

public class Inventory {
    private LinkedList<Item> inventory = new LinkedList<>();

    public Inventory(){

    }

    public void print(){
        for (Item item: inventory) {
            System.out.println(item.getName());
        }
    }

    public void add(Item item){
        inventory.add(item);
    }

    public LinkedList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(LinkedList<Item> inventory) {
        this.inventory = inventory;
    }
    public boolean isEmpty(){
        return inventory.size() == 0;
    }
}
