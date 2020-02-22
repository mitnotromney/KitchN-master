package com.example.mit.kitchn;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.media.Image;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.design.shape.InterpolateOnScrollPositionChangeHelper;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView ten = findViewById(R.id.tenMinuteTextView);
        TextView twenty = findViewById(R.id.twentyMinuteTextView);
        TextView thirty = findViewById(R.id.thirtyMinuteTextView);
        dl = (DrawerLayout)findViewById(R.id.drawer_layout);
        t= new ActionBarDrawerToggle(this, dl, R.string.common_open_on_phone, R.string.app_name);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_inventory:
                        Log.i("I'm being pressed", menuItem.toString());
                        Intent inventoryIntent = new Intent(MainActivity.this, InventoryActivity.class);
                        startActivity(inventoryIntent);
                        return true;
                    case R.id.menu_recipes:
                        Intent recipesIntent = new Intent(MainActivity.this, InventoryActivity.class);
                        startActivity(recipesIntent);
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });


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
    public boolean onOptionsItemSelected(MenuItem item) {
        if (t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

}
