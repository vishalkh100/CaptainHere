package com.example.captainhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.captainhere.Functions.DataGetSet;
import com.example.captainhere.Models.Product;

import java.util.ArrayList;

public class TableDetails extends AppCompatActivity {

    DataGetSet dataGetSet = new DataGetSet();
    TextView titleHeading;
    ImageView addButton;
    ImageView backButton;
    ListView productListView;

    LinearLayout listViewLayout;
    LinearLayout noEntryLayout;

    ArrayList<Product> arrayOfItems = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_details);

        setViews();
        onClickListeners();

    }

    private void setViews() {
        titleHeading = findViewById(R.id.titleTableDetails);
        addButton = findViewById(R.id.addButtonTableDetails);
        backButton = findViewById(R.id.backImgTableDetails);
        productListView = findViewById(R.id.itemsListView);
        listViewLayout = findViewById(R.id.itemsListLayout);
        noEntryLayout = findViewById(R.id.noEntryLayoutTableDetails);
    }

    private void onClickListeners() {
        addButton.setOnClickListener(
                v -> openAddItemActivity()
        );

        backButton.setOnClickListener(
                v -> openViewTablesActivity()
        );
    }

    public void openAddItemActivity(){
        Intent intent = new Intent(this, AddProductActivity.class);
        startActivity(intent);
    }

    public void openViewTablesActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}