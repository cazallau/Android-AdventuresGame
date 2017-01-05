package com.cazallau.adventure.Model;

import java.util.LinkedList;

public class MaoGenerator {

    public static Room initialRoom;

    public static void generate(){
        Room room1 = new Room();
        room1.setDescription("Te encuentras en un aula con las contraventanas semicerradas. Olor ha cerebro frito impregna tus sentidos");

        Room room2 = new Room();
        room2.setDescription("Te deslumbra la luz del sol que se filtra por las ventanas del pasillo. Sientes un escalofrio al ver un grajo arrastrándose");

        Room room3 = new Room();
        room3.setDescription("Hay una barra de bar con tapiceria roja pasada de moda. Huele a tabaco");

        //poner a cada habitacion que tiene al lado
        room1.setRoomSouth(room2);
        room2.setRoomNorth(room1);
        room2.setRoomEast(room3);
        room3.setRoomWest(room2);

        //creamos la lista de items y se la pasamos a a room3
        LinkedList<Item> itemsRoom3 = new LinkedList<>();
        itemsRoom3.add(new Item("Botella","Botella de JB"));
        itemsRoom3.add(new Item("Cuchillo","Cuchillo Jamonero"));
        itemsRoom3.add(new Item("Billete de 500 Euros","Unicornio hecho de papel moneda"));
        room3.setItems(itemsRoom3);

        initialRoom = room1;
    }
}
