package com.example.captainhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.captainhere.Functions.DataGetSet;
import com.example.captainhere.Models.Product;

public class ProductDetailsActivity extends AppCompatActivity {

    DataGetSet dataGetSet;
    Button deleteProduct;
    Product selectedProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        selectedProduct = dataGetSet.getSelectedProduct();

        deleteProduct = findViewById(R.id.deleteProduct);

        deleteProduct.setOnClickListener(
                v -> deleteProduct()
        );
    }

    private void deleteProduct() {
        dataGetSet.removeProduct(selectedProduct);
        Intent intent = new Intent(this, ViewProductsActivity.class);
        startActivity(intent);
    }
}