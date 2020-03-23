package com.example.alzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/*******
 Created on: 21/01/2020

 By: Rishab Kulkarni & Shaik Idrisulla


 ********/

public class QuickPlayMenu extends AppCompatActivity {

    private Button jumble;
    private Button tilematch;
    private Button game3;
    private Button game4;
    private long jumble_elapsed_millis = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_play_menu);


        jumble = (Button) findViewById(R.id.jumble);
        tilematch = (Button) findViewById(R.id.tilematch);

        jumble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuickPlayMenu.this, JumbleActivity.class);
                intent.putExtra("jumble_elapsed_millis", jumble_elapsed_millis);
                startActivityForResult(intent, 1);

            }
        });

        tilematch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuickPlayMenu.this,TileMatchingActivity.class);
                startActivity(intent);

            }
        });

        Button back = (Button) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });




    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
               jumble_elapsed_millis = data.getLongExtra("jumble_elapsed_millis", 0);



            }
            if (resultCode == RESULT_CANCELED) {


            }
        }
    }

}
