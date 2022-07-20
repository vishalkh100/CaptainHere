package com.example.captainhere.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.captainhere.R;

import java.util.ArrayList;

public class ItemListAdapter extends ArrayAdapter<Product> {

    public ItemListAdapter(Context context, ArrayList<Product> users) {
        super(context, 0, users);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        Product product = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_select_product, parent, false);
        }

        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tableNumber);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tableAmount);

        // Populate the data into the template view using the data object
        tvName.setText(product.name);
        tvHome.setText(product.mrp);

        // Return the completed view to render on screen
        return convertView;

    }

}