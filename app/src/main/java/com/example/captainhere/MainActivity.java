package com.example.captainhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.captainhere.Functions.DataGetSet;
import com.example.captainhere.Models.Table;
import com.example.captainhere.Models.TableListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataGetSet dataGetSet = new DataGetSet();
    TextView titleHeading;
    ImageView menuButton;
    ImageView addButton;
    ImageView backImg;
    ListView tableListView;

    LinearLayout listViewLayout;
    LinearLayout noEntryLayout;

    ArrayList<Table> arrayOfUsers = new ArrayList<Table>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        initializeViews();
        onClickListeners();

        makeAdapter();
        arrayOfUsers = dataGetSet.getArrayOfUsers();

        //arrayOfUsers.add(new Table("test", "test"));

        TableListAdapter adapter = new TableListAdapter(this, arrayOfUsers);
        if(!arrayOfUsers.isEmpty()) {
            listViewLayout.setVisibility(View.VISIBLE);
        } else {
            listViewLayout.setVisibility(View.GONE);
        }
        tableListView.setAdapter(adapter);
    }

    private void setViews() {
        titleHeading = findViewById(R.id.titleHeading);
        menuButton = findViewById(R.id.backImg);
        addButton = findViewById(R.id.addButton);
        tableListView = findViewById(R.id.tableListView);
        listViewLayout = findViewById(R.id.listViewLayout);
        noEntryLayout = findViewById(R.id.noEntryLayout);
        backImg = findViewById(R.id.backImg);
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

    private void makeAdapter() {
        // Create the adapter to convert the array to views

    }

}