package com.cazallau.adventure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.cazallau.adventure.Model.Inventory;
import com.cazallau.adventure.Model.Item;
import com.cazallau.adventure.Model.MaoGenerator;
import com.cazallau.adventure.Model.Room;

public class MainActivity extends AppCompatActivity {

    ImageButton northButton;
    ImageButton westButton;
    ImageButton eastButton;
    ImageButton southButton;
    ImageButton helpButton;
    ImageButton lookButton;
    ImageButton inventoryButton;
    TextView mainText;
    ImageView mainImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        northButton = (ImageButton) findViewById(R.id.activity_main_north_button);
        westButton = (ImageButton) findViewById(R.id.activity_main_west_button);
        eastButton = (ImageButton) findViewById(R.id.activity_main_east_button);
        southButton = (ImageButton) findViewById(R.id.activity_main_south_button);
        helpButton = (ImageButton) findViewById(R.id.activity_main_help_button);
        lookButton = (ImageButton) findViewById(R.id.activity_main_look_button);
        inventoryButton = (ImageButton) findViewById(R.id.activity_main_inventory_button);
        mainText = (TextView) findViewById(R.id.activity_main_scene_text);
        mainImage = (ImageView) findViewById(R.id.activity_main_scene_image);

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(i);

            }
        });

        northButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentRoom = currentRoom.getRoomNorth();
                repaintScene();
            }
        });

        westButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentRoom = currentRoom.getRoomWest();
                repaintScene();
            }
        });

        eastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentRoom = currentRoom.getRoomEast();
                repaintScene();
            }
        });

        southButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentRoom = currentRoom.getRoomSouth();
                repaintScene();
            }
        });

        lookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainText.setText(currentRoom.print());
            }
        });

        inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainText.setText(inventory.print());
            }
        });

        initGame();

    }

    Inventory inventory = new Inventory();
    Room currentRoom;

    private void initGame(){

        Item sword = new Item("Sword", "A sharp blade");
        Item pieceOfPaper = new Item("Piece Of Paper", "A blank paper");
        Item rubberChicken = new Item("Pollo de goma", "Pollo de goma");

        inventory.add(sword);
        inventory.add(pieceOfPaper);
        inventory.add(rubberChicken);

        //creamos un mapa con todas las room
        MaoGenerator.generate();

        currentRoom = MaoGenerator.initialRoom;
        repaintScene();
    }

    private void repaintScene(){
        mainText.setText(currentRoom.getDescription());
        mainImage.setImageResource(currentRoom.getImage());

        if (currentRoom.getRoomNorth()!= null){
            northButton.setVisibility(View.VISIBLE);

        }else{

            northButton.setVisibility(View.INVISIBLE);
        }

        if (currentRoom.getRoomSouth()!= null){
            southButton.setVisibility(View.VISIBLE);

        }else{

            southButton.setVisibility(View.INVISIBLE);
        }

        if (currentRoom.getRoomWest()!= null){
            westButton.setVisibility(View.VISIBLE);

        }else{

            westButton.setVisibility(View.INVISIBLE);
        }

        if (currentRoom.getRoomEast()!= null){
            eastButton.setVisibility(View.VISIBLE);

        }else{

            eastButton.setVisibility(View.INVISIBLE);
        }

    }
}
