package com.example.mit.kitchn.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mit.kitchn.Model.TwentyMinute;
import com.example.mit.kitchn.R;
import com.example.mit.kitchn.TwentyMinActivity;

import java.util.ArrayList;

public class TwentyMinuteAdapter extends ArrayAdapter<TwentyMinute> {
    public TwentyMinuteAdapter(TwentyMinActivity context, ArrayList<TwentyMinute> minute) {
        super(context, 0, minute);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_listitem, parent, false);
        }

        TwentyMinute currentTwentyMinute = getItem(position);
        TextView minuteTextView = (TextView) listItemView.findViewById(R.id.mealNameTextView);
        minuteTextView.setText(currentTwentyMinute.getTwentyMinute());

        return listItemView;
    }
}
