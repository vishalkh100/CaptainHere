package com.example.captainhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.captainhere.Functions.DataGetSet;
import com.example.captainhere.Models.Product;
import com.example.captainhere.Models.Table;

public class AddProductActivity extends AppCompatActivity {

    DataGetSet dataGetSet;

    ImageView backImg;
    EditText editTextProdName;
    EditText editTextMrp;
    Button addProductButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        setViews();
        onClickListeners();
    }

    private void setViews() {
        backImg = findViewById(R.id.backImgAddProd);
        editTextProdName = findViewById(R.id.editTextProdName);
        editTextMrp = findViewById(R.id.editTextMrp);
        addProductButton = findViewById(R.id.addProductButton);
    }

    private void onClickListeners() {
        backImg.setOnClickListener(
                v -> openPreviousActivity()
        );
        addProductButton.setOnClickListener(
                v -> addTableToList()
        );
    }

    private void openPreviousActivity() {
        Intent intent = new Intent(this, ViewProductsActivity.class);
        startActivity(intent);
    }

    private void addTableToList() {
        String name = editTextProdName.getText().toString();
        String mrp = editTextMrp.getText().toString();
        Product product = new Product(name, mrp);
        dataGetSet.addProduct(product);

        Intent intent = new Intent(this, ViewProductsActivity.class);
        startActivity(intent);
    }
}