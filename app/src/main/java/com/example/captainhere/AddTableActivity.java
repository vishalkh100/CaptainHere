package com.example.captainhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.captainhere.Functions.DataGetSet;
import com.example.captainhere.Models.Table;


public class AddTableActivity extends AppCompatActivity {

    DataGetSet dataGetSet;

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
        addTableButton.setOnClickListener(
                v -> addTableToList()
        );
    }

    private void openPreviousActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void addTableToList() {
        String name = editTextTableName.getText().toString();
        String amount = editTextBillAmount.getText().toString();
        Table table = new Table(name, amount);
        dataGetSet.addTable(table);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}