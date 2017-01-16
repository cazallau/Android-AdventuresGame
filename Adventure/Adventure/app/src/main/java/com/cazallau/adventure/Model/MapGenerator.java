package com.cazallau.adventure.Model;

import com.cazallau.adventure.R;

import java.util.LinkedList;

public class MapGenerator {

    public static Room initialRoom;

    public static void generate(){
        Room room1 = new Room();
        room1.setDescription("Te encuentras en un aula con las contraventanas semicerradas. Olor ha cerebro frito impregna tus sentidos");
        room1.setImage(R.drawable.room1);

        Room room2 = new Room();
        room2.setDescription("Te deslumbra la luz del sol que se filtra por las ventanas del pasillo. Sientes un escalofrio al ver un grajo arrastrándose");
        room2.setImage(R.drawable.room2);

        Room room3 = new Room();
        room3.setDescription("Hay una barra de bar con tapiceria roja pasada de moda. Huele a tabaco");
        room3.setImage(R.drawable.room3);

        Room room4 = new Room();
        room4.setDescription("Un timon de barco se encuentra en medio de la habitacion rodeado por un charco de sangre");



        //poner a cada habitacion que tiene al lado
        room1.setRoomSouth(room2);
        room2.setRoomNorth(room1);
        room2.setRoomEast(room3);
        room3.setRoomWest(room2);
        room4.setRoomWest(room1);
        room1.setRoomEast(room4);

        //creamos la lista de items y se la pasamos a a room3
        LinkedList<Item> itemsRoom3 = new LinkedList<>();
        itemsRoom3.add(new Item("Botella","Botella de JB"));
        itemsRoom3.add(new Item("Cuchillo","Cuchillo Jamonero"));
        itemsRoom3.add(new Item("Billete de 500 Euros","Unicornio hecho de papel moneda"));
        room3.setItems(itemsRoom3);

        initialRoom = room1;
    }
}
