package com.project.locker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Keep extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keep);

        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<SingleItem> itemList = new ArrayList<SingleItem>();

        itemList.add(new SingleItem("서울 2호선 강남역 1번 출구", "03"));
        itemList.add(new SingleItem("서울 2호선 강남역 2번 출구", "04"));
        itemList.add(new SingleItem("서울 2호선 역삼역 1번 출구", "01"));
        itemList.add(new SingleItem("서울 2호선 역삼역 2번 출구", "09"));
        itemList.add(new SingleItem("서울 2호선 역삼역 3번 출구", "05"));

        RecyclerView recyclerView = findViewById(R.id.recycler_View);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SingleItemAdapter adapter = new SingleItemAdapter(itemList);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}