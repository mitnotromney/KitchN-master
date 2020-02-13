package com.example.mit.kitchn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.mit.kitchn.Adapters.TenMinuteAdapter;
import com.example.mit.kitchn.Model.Minute;

import java.util.ArrayList;

public class TenMinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        final ArrayList<Minute> minute = new ArrayList<>();
        minute.add(new Minute("Meal"));

        TenMinuteAdapter adapter = new TenMinuteAdapter(this, minute);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
