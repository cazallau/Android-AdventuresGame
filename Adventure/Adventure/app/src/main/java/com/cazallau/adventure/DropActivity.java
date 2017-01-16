package com.cazallau.adventure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cazallau.adventure.Model.Inventory;
import com.cazallau.adventure.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DropActivity extends AppCompatActivity {

        @BindView(R.id.activity_drop_list) ListView list;


        Inventory inventory;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_drop);
            ButterKnife.bind(this);

            ArrayAdapter<String> adapter;

            Intent i = getIntent();
            inventory= (Inventory) i.getSerializableExtra(Constants.KEY_INTENT_INVETORY);


            adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, inventory.getItemsNames());
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View row, int position, long id) {
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra(Constants.KEY_INTENT_DROP_ITEM_POSITION,position);

                    setResult(Activity.RESULT_OK,returnIntent);
                    finish();
                }
            });

        }
}
