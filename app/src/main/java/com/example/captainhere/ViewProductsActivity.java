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
import com.example.captainhere.Models.Product;
import com.example.captainhere.Models.ProductListAdapter;

import java.util.ArrayList;

public class ViewProductsActivity extends AppCompatActivity {

    DataGetSet dataGetSet = new DataGetSet();
    TextView titleHeading;
    ImageView addButton;
    ImageView backButton;
    ListView productListView;

    LinearLayout listViewLayout;
    LinearLayout noEntryLayout;

    ArrayList<Product> arrayOfProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_products);

        setViews();
        onClickListeners();

        TinyDB tinydb = new TinyDB(this);
        ArrayList<Object> playerObjects = tinydb.getListObject("productList", Product.class);
        ArrayList<Product> productList = new ArrayList<>();

        for(Object objs : playerObjects){
            productList.add((Product) objs);
        }
        arrayOfProducts = productList;
        dataGetSet.setArrayOfProducts(arrayOfProducts);

        ProductListAdapter adapter = new ProductListAdapter(this, arrayOfProducts);
        if(!arrayOfProducts.isEmpty()) {
            listViewLayout.setVisibility(View.VISIBLE);
        } else {
            listViewLayout.setVisibility(View.GONE);
        }
        productListView.setAdapter(adapter);

    }

    private void setViews() {
        titleHeading = findViewById(R.id.titleProducts);
        addButton = findViewById(R.id.addButton);
        backButton = findViewById(R.id.backImgViewProd);
        productListView = findViewById(R.id.productListView);
        listViewLayout = findViewById(R.id.productListLayout);
        noEntryLayout = findViewById(R.id.noEntryLayoutProducts);
    }

    private void onClickListeners() {
        addButton.setOnClickListener(
                v -> openAddTableActivity()
        );

        backButton.setOnClickListener(
                v -> openViewTablesActivity()
        );

        productListView.setOnItemClickListener((parent, view, position, id) -> {
            Product p = (Product) parent.getItemAtPosition(position);
            dataGetSet.setSelectedProduct(p);
            Intent intent = new Intent(this, ProductDetailsActivity.class);
            startActivity(intent);
        });

    }

    public void openAddTableActivity(){
        Intent intent = new Intent(this, AddProductActivity.class);
        startActivity(intent);
    }

    public void openViewTablesActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}