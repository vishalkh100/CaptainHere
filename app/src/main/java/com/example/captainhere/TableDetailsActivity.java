package com.example.captainhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.captainhere.Functions.DataGetSet;
import com.example.captainhere.Functions.TinyDB;
import com.example.captainhere.Models.Product;
import com.example.captainhere.Models.ProductItem;
import com.example.captainhere.Models.ProductListAdapter;
import com.example.captainhere.Models.Table;
import com.example.captainhere.Models.TableListAdapter;

import java.util.ArrayList;

public class TableDetailsActivity extends AppCompatActivity {

    DataGetSet dataGetSet = new DataGetSet();
    TextView titleHeading;
    TextView totalBill;
    ImageView addButton;
    ImageView backButton;
    ListView productListView;

    LinearLayout listViewLayout;
    LinearLayout noEntryLayout;

    Button deleteTable;
    Button checkOut;

    Table selectedTable;

    ArrayList<ProductItem> arrayOfItems = new ArrayList<>();

    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_details);

        selectedTable = dataGetSet.getSelectedTable();
        Log.d("selectedTableName", selectedTable.name);
        setViews();
        initializeViews();
        onClickListeners();

        TinyDB tinydb = new TinyDB(this);
        ArrayList<Object> playerObjects = tinydb.getListObject("productItemList", ProductItem.class);
        ArrayList<ProductItem> productItemList = new ArrayList<>();
        ArrayList<Product> productList = new ArrayList<>();

        for(Object objs : playerObjects){
            productItemList.add((ProductItem) objs);
        }
        arrayOfItems = productItemList;
        dataGetSet.setArrayOfProductItems(arrayOfItems);

        for(ProductItem productItem : productItemList) {
            if(productItem.name.equalsIgnoreCase(selectedTable.name)) {
                productList.add(productItem.product);
                total = total + Integer.valueOf(productItem.product.mrp);
            }
        }

        ProductListAdapter adapter = new ProductListAdapter(this, productList);
        if(!productList.isEmpty()) {
            listViewLayout.setVisibility(View.VISIBLE);
        } else {
            listViewLayout.setVisibility(View.GONE);
        }
        productListView.setAdapter(adapter);

        totalBill.setText("Total: "+total);

    }

    private void setViews() {
        titleHeading = findViewById(R.id.titleTableDetails);
        addButton = findViewById(R.id.addButtonTableDetails);
        backButton = findViewById(R.id.backImgTableDetails);
        deleteTable = findViewById(R.id.deleteTable);
        checkOut = findViewById(R.id.checkOut);
        productListView = findViewById(R.id.itemsListView);
        listViewLayout = findViewById(R.id.itemsListLayout);
        noEntryLayout = findViewById(R.id.noEntryLayoutTableDetails);
        totalBill = findViewById(R.id.totalBill);
    }

    private void initializeViews() {
        titleHeading.setText("Table Name: "+selectedTable.name);
    }

    private void onClickListeners() {
        addButton.setOnClickListener(
                v -> openAddItemActivity()
        );

        backButton.setOnClickListener(
                v -> openViewTablesActivity()
        );

        deleteTable.setOnClickListener(
                v -> deleteTable()
        );

        checkOut.setOnClickListener(
                v -> checkOut()
        );
    }

    public void openAddItemActivity(){
        Intent intent = new Intent(this, AddItemsActivity.class);
        startActivity(intent);
    }

    public void openViewTablesActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void deleteTable() {
        checkOut();
        Log.d("selectedTableName", selectedTable.name);
        dataGetSet.removeTable(selectedTable);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void checkOut(){
        ArrayList<ProductItem> productListNew = new ArrayList<>();

        for(ProductItem productItem : arrayOfItems) {
            if(!productItem.name.equalsIgnoreCase(selectedTable.name)) {
                productListNew.add(productItem);
            }
        }
        dataGetSet.setArrayOfProductItems(productListNew);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}