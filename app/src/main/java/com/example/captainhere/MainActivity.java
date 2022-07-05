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
    }

    private void setViews() {
        titleHeading = findViewById(R.id.titleHeading);
    }

}