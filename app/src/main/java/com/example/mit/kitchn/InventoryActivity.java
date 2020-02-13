package com.example.mit.kitchn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class InventoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_view);

        ImageView inventoryAdd = findViewById(R.id.fab);

        inventoryAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inventoryAdd = new Intent(InventoryActivity.this, EditorActivity.class);
                startActivity(inventoryAdd);
            }
        });
    }
}
