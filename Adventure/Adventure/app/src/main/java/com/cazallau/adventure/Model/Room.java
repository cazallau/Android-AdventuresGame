package com.cazallau.adventure.Model;


import java.util.LinkedList;

public class Room {
    private String description;

    private LinkedList<Item> items;

    private int image;

    private Room roomNorth;
    private Room roomEast;
    private Room roomWest;
    private Room roomSouth;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LinkedList<Item> getItems() {
        return items;
    }

    public void setItems(LinkedList<Item> items) {
        this.items = items;
    }

    public Room getRoomNorth() {
        return roomNorth;
    }

    public void setRoomNorth(Room roomNorth) {
        this.roomNorth = roomNorth;
    }

    public Room getRoomEast() {
        return roomEast;
    }

    public void setRoomEast(Room roomEast) {
        this.roomEast = roomEast;
    }

    public Room getRoomWest() {
        return roomWest;
    }

    public void setRoomWest(Room roomWest) {
        this.roomWest = roomWest;
    }

    public Room getRoomSouth() {
        return roomSouth;
    }

    public void setRoomSouth(Room roomSouth) {
        this.roomSouth = roomSouth;
    }

    public void add(Item item){
        if (items == null){
            items = new LinkedList<Item>();
        }
        items.add(item);
    }

    public String print(){
        String inventario = new String();
        for (Item item: items) {
            inventario = inventario + item.getName() + "\n";
        }
        return inventario;
    }

}
