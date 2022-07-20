package com.example.captainhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.captainhere.Functions.DataGetSet;
import com.example.captainhere.Functions.TinyDB;
import com.example.captainhere.Models.Table;
import com.example.captainhere.Models.TableListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataGetSet dataGetSet = new DataGetSet();
    TextView titleHeading;
    ImageView addButton;
    ImageView backImg;
    ListView tableListView;

    LinearLayout listViewLayout;
    LinearLayout noEntryLayout;

    ArrayList<Table> arrayOfUsers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        initializeViews();
        onClickListeners();

        TinyDB tinydb = new TinyDB(this);
        ArrayList<Object> playerObjects = tinydb.getListObject("tableList", Table.class);
        ArrayList<Table> tableList = new ArrayList<>();

        for(Object objs : playerObjects){
            tableList.add((Table) objs);
        }
        arrayOfUsers = tableList;
        dataGetSet.setArrayOfUsers(arrayOfUsers);

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
                v -> openAddTableActivity()
        );

        backImg.setOnClickListener(
                v -> openViewProductActivity()
        );

        tableListView.setOnItemClickListener((parent, view, position, id) -> {
            Table t = (Table) parent.getItemAtPosition(position);
            dataGetSet.setSelectedTable(t);
            Intent intent = new Intent(this, TableDetailsActivity.class);
            startActivity(intent);
        });
    }

    public void openAddTableActivity(){
        Intent intent = new Intent(this, AddTableActivity.class);
        startActivity(intent);
    }

    public void openViewProductActivity(){
        Intent intent = new Intent(this, ViewProductsActivity.class);
        startActivity(intent);
    }

}