package com.cazallau.adventure;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DropActivity extends AppCompatActivity {

        ListView list;
        ArrayList object;
        ArrayAdapter<ArrayList> adapter;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_drop);

            object =  getIntent().getExtras().getStringArrayList("room");

            list = (ListView) findViewById(R.id.activity_drop_list);
            adapter =  new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    object);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("result",position);

                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
                }
            });

        }
}
