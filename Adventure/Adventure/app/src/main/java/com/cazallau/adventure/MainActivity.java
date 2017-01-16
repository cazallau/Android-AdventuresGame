package com.cazallau.adventure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.cazallau.adventure.Model.Inventory;
import com.cazallau.adventure.Model.Item;
import com.cazallau.adventure.Model.MapGenerator;
import com.cazallau.adventure.Model.Room;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_main_north_button) ImageButton northButton;

    @BindView(R.id.activity_main_west_button) ImageButton westButton;

    @BindView(R.id.activity_main_east_button) ImageButton eastButton;

    @BindView(R.id.activity_main_south_button) ImageButton southButton;

    @BindView(R.id.activity_main_help_button) ImageButton helpButton;

    @BindView(R.id.activity_main_look_button) ImageButton lookButton;

    @BindView(R.id.activity_main_inventory_button) ImageButton inventoryButton;

    @BindView(R.id.activity_main_scene_text) TextView mainText;

    @BindView(R.id.activity_main_scene_image) ImageView mainImage;

    @BindView(R.id.activity_main_take_button) ImageButton takeButton;

    @BindView(R.id.activity_main_drop_button) ImageButton dropButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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

                mainText.setText(currentRoom.getDescription() + "\n" + currentRoom.print());
            }
        });

        inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mainText.setText(inventory.print());

                
            }
        });

        takeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentRoom.getLook().size() != 0) {
                    Intent intent = new Intent(MainActivity.this, TakeActivity.class);
                    intent.putExtra("room", currentRoom.getLook());
                    startActivityForResult(intent, 1);
                } else {
                    mainText.setText("No hay nada en esta habitación");
                }
            }
        });

        dropButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inventory.getLook().size() != 0) {
                    Intent intent = new Intent(MainActivity.this, TakeActivity.class);
                    intent.putExtra("room", inventory.getLook());
                    startActivityForResult(intent, 2);
                } else {
                    mainText.setText("No hay nada en esta habitación");
                }
            }
        });

        initGame();


    }


    Inventory inventory = new Inventory();
    Room currentRoom;

    private void initGame() {

        Item sword = new Item("Sword", "A sharp blade");
        Item pieceOfPaper = new Item("Piece Of Paper", "A blank paper");
        Item rubberChicken = new Item("Pollo de goma", "Pollo de goma");

        inventory.add(sword);
        inventory.add(pieceOfPaper);
        inventory.add(rubberChicken);

        //creamos un mapa con todas las room
        MapGenerator.generate();

        currentRoom = MapGenerator.initialRoom;
        repaintScene();
    }

    private void repaintScene() {
        mainText.setText(currentRoom.getDescription());
        mainImage.setImageResource(currentRoom.getImage());

        if (currentRoom.getRoomNorth() != null) {
            northButton.setVisibility(View.VISIBLE);

        } else {

            northButton.setVisibility(View.INVISIBLE);
        }

        if (currentRoom.getRoomSouth() != null) {
            southButton.setVisibility(View.VISIBLE);

        } else {

            southButton.setVisibility(View.INVISIBLE);
        }

        if (currentRoom.getRoomWest() != null) {
            westButton.setVisibility(View.VISIBLE);

        } else {

            westButton.setVisibility(View.INVISIBLE);
        }

        if (currentRoom.getRoomEast() != null) {
            eastButton.setVisibility(View.VISIBLE);

        } else {

            eastButton.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                int result = data.getIntExtra("result", -1);

                System.out.println("position" + result);
                Item item = new Item();
                item = currentRoom.getItems().get(result);
                currentRoom.getItems().remove(result);
                inventory.add(item);

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
        if (requestCode == 2) {
            if(resultCode == Activity.RESULT_OK){
                int result = data.getIntExtra("result", -1);

                Item item = new Item();
                item = inventory.getInventory().get(result);
                inventory.getInventory().remove(result);
                currentRoom.add(item);


            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }



    }

}
