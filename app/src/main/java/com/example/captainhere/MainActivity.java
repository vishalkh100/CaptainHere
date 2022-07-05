package com.example.captainhere;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.captainhere.Functions.GlobalFunctions;

public class MainActivity extends AppCompatActivity {

    GlobalFunctions globalFunctions = new GlobalFunctions();
    TextView titleHeading;
    ImageView menuButton;
    ImageView addButton;
    ListView tableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Test", globalFunctions.getTest1() );
        globalFunctions.setTest1("Success");
        setViews();
        initializeViews();
    }

    private void setViews() {
        titleHeading = findViewById(R.id.titleHeading);
        menuButton = findViewById(R.id.menuButton);
        addButton = findViewById(R.id.addButton);
        tableListView = findViewById(R.id.tableListView);
    }

    private void initializeViews() {
        String title = this.getString(R.string.table_screen_title);
        titleHeading.setText(title);
    }

}