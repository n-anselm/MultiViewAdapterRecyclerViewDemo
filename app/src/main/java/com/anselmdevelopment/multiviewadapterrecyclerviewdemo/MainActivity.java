package com.anselmdevelopment.multiviewadapterrecyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvMainActivity);

        // Create a new ArrayList
        ArrayList<RecycleItem> arrayList = new ArrayList<>();

        // Add all the items to the arraylist
        arrayList.add(new RecycleItem("1", "Main Heading"));
        arrayList.add(new RecycleItem("2", "Subheading"));
        arrayList.add(new RecycleItem("3", "Item"));
        arrayList.add(new RecycleItem("3", "Item"));
        arrayList.add(new RecycleItem("2", "Subheading"));
        arrayList.add(new RecycleItem("3", "Item"));
        arrayList.add(new RecycleItem("3", "Item"));
        arrayList.add(new RecycleItem("3", "Item"));
        arrayList.add(new RecycleItem("1", "Main Heading"));
        arrayList.add(new RecycleItem("2", "Subheading"));
        arrayList.add(new RecycleItem("3", "Item"));
        arrayList.add(new RecycleItem("3", "Item"));
        arrayList.add(new RecycleItem("3", "Item"));
        arrayList.add(new RecycleItem("3", "Item"));
        arrayList.add(new RecycleItem("3", "Item"));
        arrayList.add(new RecycleItem("3", "Item"));
        arrayList.add(new RecycleItem("2", "Subheading"));
        arrayList.add(new RecycleItem("3", "Item"));
        arrayList.add(new RecycleItem("3", "Item"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new RecycleDataAdapter(this, arrayList));
    }
}