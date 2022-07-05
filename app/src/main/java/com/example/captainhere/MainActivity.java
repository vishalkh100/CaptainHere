package com.example.captainhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.captainhere.Functions.DataGetSet;

public class MainActivity extends AppCompatActivity {

    DataGetSet dataGetSet = new DataGetSet();
    TextView titleHeading;
    ImageView menuButton;
    ImageView addButton;
    ListView tableListView;

    LinearLayout listViewLayout;
    LinearLayout noEntryLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Test", dataGetSet.getTest1() );
        dataGetSet.setTest1("Success");
        setViews();
        initializeViews();
        onClickListeners();
    }

    private void setViews() {
        titleHeading = findViewById(R.id.titleHeading);
        menuButton = findViewById(R.id.backImg);
        addButton = findViewById(R.id.addButton);
        tableListView = findViewById(R.id.tableListView);
        listViewLayout = findViewById(R.id.listViewLayout);
        noEntryLayout = findViewById(R.id.noEntryLayout);
    }

    private void initializeViews() {
        String title = this.getString(R.string.table_screen_title);
        titleHeading.setText(title);
    }

    private void onClickListeners() {
        addButton.setOnClickListener(
                v -> openNewActivity()
        );
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, AddTableActivity.class);
        startActivity(intent);
    }

}