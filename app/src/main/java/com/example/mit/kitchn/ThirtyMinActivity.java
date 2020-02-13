package com.example.mit.kitchn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.mit.kitchn.Adapters.ThirtyMinuteAdapter;
import com.example.mit.kitchn.Model.ThirtyMinute;

import java.util.ArrayList;

public class ThirtyMinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        final ArrayList<ThirtyMinute> thirtyMinutes = new ArrayList<>();
        thirtyMinutes.add(new ThirtyMinute("Meal ffffffff"));

        ThirtyMinuteAdapter adapter = new ThirtyMinuteAdapter(this, thirtyMinutes);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
