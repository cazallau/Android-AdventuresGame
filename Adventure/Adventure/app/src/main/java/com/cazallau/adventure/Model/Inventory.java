package com.cazallau.adventure.Model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inventory implements Serializable{
    private LinkedList<Item> inventory = new LinkedList<>();

    public Inventory(){

    }
    public List getItemsNames() {
        List<String> names = new ArrayList<>();
        if (inventory != null) {

            for (Item i : inventory) {

                names.add(i.getName());
            }
        }
        return names;
    }

    public String print(){

        if (inventory.size() == 0 ){
            return "No hay nada en el inventario";
        }
        String inventario = new String();

        for (Item item: inventory) {
            inventario = inventario + item.getName() + "\n";
        }
        return inventario;
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
