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
import com.example.captainhere.Models.Product;
import com.example.captainhere.Models.ProductListAdapter;
import com.example.captainhere.Models.TableListAdapter;

import java.util.ArrayList;

public class ViewProductsActivity extends AppCompatActivity {

    DataGetSet dataGetSet = new DataGetSet();
    TextView titleHeading;
    ImageView addButton;
    ImageView backButton;
    ListView productListView;

    LinearLayout listViewLayout;
    LinearLayout noEntryLayout;

    ArrayList<Product> arrayOfProducts = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_products);

        setViews();
        onClickListeners();

        arrayOfProducts = dataGetSet.getArrayOfProducts();

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