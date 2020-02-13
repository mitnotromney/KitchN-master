package com.example.mit.kitchn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.mit.kitchn.Adapters.TwentyMinuteAdapter;
import com.example.mit.kitchn.Model.TwentyMinute;

import java.util.ArrayList;

public class TwentyMinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        final ArrayList<TwentyMinute> twentyMinutes = new ArrayList<>();
        twentyMinutes.add(new TwentyMinute("Meal 20 minutess"));

        TwentyMinuteAdapter adapter = new TwentyMinuteAdapter(this, twentyMinutes);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);
    }
}
