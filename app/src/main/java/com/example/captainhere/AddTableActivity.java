package com.example.captainhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class AddTableActivity extends AppCompatActivity {

    ImageView backImg;
    EditText editTextTableName;
    EditText editTextBillAmount;
    Button addTableButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_table);
        setViews();
        onClickListeners();
    }

    private void setViews() {
        backImg = findViewById(R.id.backImg);
        editTextTableName = findViewById(R.id.editTextTableName);
        editTextBillAmount = findViewById(R.id.editTextBillAmount);
        addTableButton = findViewById(R.id.addTableButton);
    }

    private void onClickListeners() {
        backImg.setOnClickListener(
                v -> openPreviousActivity()
        );
    }

    private void openPreviousActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}