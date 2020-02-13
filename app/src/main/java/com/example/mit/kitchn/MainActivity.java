package com.example.mit.kitchn;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.media.Image;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView ten = findViewById(R.id.tenMinuteTextView);
        TextView twenty = findViewById(R.id.twentyMinuteTextView);
        TextView thirty = findViewById(R.id.thirtyMinuteTextView);


        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tenIntent = new Intent(MainActivity.this, TenMinActivity.class);
                startActivity(tenIntent);
            }
        });

        twenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent twentyIntent = new Intent(MainActivity.this, TwentyMinActivity.class);
                startActivity(twentyIntent);
            }
        });

        thirty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thirtyIntent = new Intent(MainActivity.this, ThirtyMinActivity.class);
                startActivity(thirtyIntent);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.i(TAG, "onNavigationItemSelected: I'm being pressed");
        switch (item.getItemId()) {
            case R.id.menu_inventory:
                startActivity(new Intent(this, InventoryActivity.class));
                return true;
            case R.id.menu_recipes:
                Intent recipesIntent = new Intent(this, TenMinActivity.class);
                this.startActivity(recipesIntent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

}
