package com.example.mit.kitchn.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mit.kitchn.Model.Minute;
import com.example.mit.kitchn.Model.ThirtyMinute;
import com.example.mit.kitchn.R;
import com.example.mit.kitchn.TenMinActivity;

import java.util.ArrayList;


public class TenMinuteAdapter extends ArrayAdapter<Minute> {

    public TenMinuteAdapter(TenMinActivity context, ArrayList<Minute> minute) {
        super(context, 0, minute);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_listitem, parent, false);
        }

        Minute currentMinute = getItem(position);
        TextView minuteTextView = (TextView) listItemView.findViewById(R.id.mealNameTextView);
        minuteTextView.setText(currentMinute.getMinute());

        return listItemView;
    }
}
