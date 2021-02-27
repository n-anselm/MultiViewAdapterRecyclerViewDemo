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

        ArrayList<RecycleItem> arrayList = new ArrayList<>();

        for (int i = 0; i <= 25; i++) {
            RecycleItem recycleItem = new RecycleItem();

            if (i % 2 == 0) {
                recycleItem.setRow_type("1");
                recycleItem.setText("First element");
                recycleItem.setImage_url("http://www.androhub.com/wp-content/uploads/2015/09/staggeredrecyclerview_banner.jpg");
            } else if (i % 3 == 0) {
                recycleItem.setRow_type("2");
                recycleItem.setText("Second element");
                recycleItem.setImage_url("http://i.stack.imgur.com/snB84.png");
            } else {
                recycleItem.setRow_type("3");
                recycleItem.setText("Third element");
                recycleItem.setImage_url("http://inducesmile.com/wp-content/uploads/2015/05/gridbanner.jpg");
            }
            arrayList.add(recycleItem);
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new RecycleDataAdapter(this, arrayList));
    }
}