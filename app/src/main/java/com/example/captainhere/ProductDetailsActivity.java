package com.example.captainhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.captainhere.Functions.DataGetSet;
import com.example.captainhere.Models.Product;

public class ProductDetailsActivity extends AppCompatActivity {

    DataGetSet dataGetSet;
    Button deleteProduct;
    ImageView backImgProductDetails;
    Product selectedProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        selectedProduct = dataGetSet.getSelectedProduct();

        deleteProduct = findViewById(R.id.deleteProduct);
        backImgProductDetails = findViewById(R.id.backImgProductDetails);

        deleteProduct.setOnClickListener(
                v -> deleteProduct()
        );

        backImgProductDetails.setOnClickListener(
                v -> openProductList()
        );

    }

    private void deleteProduct() {
        dataGetSet.removeProduct(selectedProduct);
        Intent intent = new Intent(this, ViewProductsActivity.class);
        startActivity(intent);
    }

    private void openProductList() {
        Intent intent = new Intent(this, ViewProductsActivity.class);
        startActivity(intent);
    }

}