package com.example.mit.kitchn;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mit.kitchn.Data.InventoryContract;
import com.example.mit.kitchn.Data.InventoryDbHelper;

public class EditorActivity extends AppCompatActivity {

    private EditText mItemName;
    private EditText mPriceText;
    private Spinner mQuantitySpinner;

    private int mQuantity = InventoryContract.InventoryEntry.QUANTITY_ONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_editor);

        mItemName = (EditText) findViewById(R.id.edit_item_name);
        mPriceText = (EditText) findViewById(R.id.edit_item_price);
        mQuantitySpinner = (Spinner) findViewById(R.id.spinner_quantity);

        setupSpinner();
    }

    private void setupSpinner() {
        ArrayAdapter quantitySpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_quantity_options, android.R.layout.simple_spinner_item);

        quantitySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        mQuantitySpinner.setAdapter(quantitySpinnerAdapter);

        mQuantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.quantity_one))) {
                        mQuantity = InventoryContract.InventoryEntry.QUANTITY_ONE;
                    } else if (selection.equals("2")) {
                        mQuantity = InventoryContract.InventoryEntry.QUANTITY_TWO;
                    } else {
                        mQuantity = InventoryContract.InventoryEntry.QUANTITY_THREE;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mQuantity = InventoryContract.InventoryEntry.QUANTITY_ONE;
            }
        });
    }

    private void insertItem() {
        String nameString = mItemName.getText().toString().trim();
        String priceString = mPriceText.getText().toString().trim();

        InventoryDbHelper mDbHelper = new InventoryDbHelper(this);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(InventoryContract.InventoryEntry.COLUMN_ITEM_NAME, nameString);
        values.put(InventoryContract.InventoryEntry.COLUMN_PRICE, priceString);
        values.put(InventoryContract.InventoryEntry.COLUMN_QUANTITY, mQuantity);

        long newRowId = db.insert(InventoryContract.InventoryEntry.TABLE_NAME, null, values);

        if (newRowId == -1) {
            Toast.makeText(this,"Error with saving item", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Item saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_delete_database_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                insertItem();
                finish();
                return true;
            case R.id.action_delete:
                return true;
            case R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
