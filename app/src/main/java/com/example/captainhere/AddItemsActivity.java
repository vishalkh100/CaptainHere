package com.example.captainhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.captainhere.Functions.DataGetSet;
import com.example.captainhere.Functions.TinyDB;
import com.example.captainhere.Models.ItemListAdapter;
import com.example.captainhere.Models.Product;
import com.example.captainhere.Models.ProductItem;
import com.example.captainhere.Models.ProductListAdapter;
import com.example.captainhere.Models.Table;

import java.util.ArrayList;

public class AddItemsActivity extends AppCompatActivity {

    DataGetSet dataGetSet = new DataGetSet();
    TextView titleHeading;
    ImageView backButton;
    ListView productListView;

    LinearLayout listViewLayout;
    LinearLayout noEntryLayout;

    ArrayList<Product> arrayOfProducts = new ArrayList<>();

    Table selectedTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        setViews();
        onClickListeners();

        selectedTable = dataGetSet.getSelectedTable();

        TinyDB tinydb = new TinyDB(this);
        ArrayList<Object> playerObjects = tinydb.getListObject("productList", Product.class);
        ArrayList<Product> productList = new ArrayList<>();

        for(Object objs : playerObjects){
            productList.add((Product) objs);
        }
        arrayOfProducts = productList;
        dataGetSet.setArrayOfProducts(arrayOfProducts);

        ItemListAdapter adapter = new ItemListAdapter(this, arrayOfProducts);
        if(!arrayOfProducts.isEmpty()) {
            listViewLayout.setVisibility(View.VISIBLE);
        } else {
            listViewLayout.setVisibility(View.GONE);
        }
        productListView.setAdapter(adapter);

    }

    private void setViews() {
        titleHeading = findViewById(R.id.titleProducts);
        backButton = findViewById(R.id.backImgAddItems);
        productListView = findViewById(R.id.itemListView);
        listViewLayout = findViewById(R.id.itemListLayout);
        noEntryLayout = findViewById(R.id.noEntryLayoutItems);
    }

    private void onClickListeners() {

        backButton.setOnClickListener(
                v -> openViewTablesActivity()
        );

        productListView.setOnItemClickListener((parent, view, position, id) -> {
            Product p = (Product) parent.getItemAtPosition(position);
            ProductItem productItem = new ProductItem(selectedTable.name, p);
            dataGetSet.addProductItem(productItem);
            Intent intent = new Intent(this, TableDetailsActivity.class);
            startActivity(intent);
        });

    }

    public void openViewTablesActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}