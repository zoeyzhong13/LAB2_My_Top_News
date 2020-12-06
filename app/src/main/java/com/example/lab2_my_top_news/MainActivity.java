package com.example.lab2_my_top_news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Navigate> navigateList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavigates();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        NavigateAdapter adapter=new NavigateAdapter(navigateList);
        recyclerView.setAdapter(adapter);
    }

    private void initNavigates(){
        Navigate business = new Navigate("Business",R.drawable.business);
        navigateList.add(business);
        Navigate entertainment = new Navigate("Entertainment",R.drawable.entertainment);
        navigateList.add(entertainment);
        Navigate health = new Navigate("Health",R.drawable.health);
        navigateList.add(health);
        Navigate science = new Navigate("Science",R.drawable.science);
        navigateList.add(science);
        Navigate sports= new Navigate("Sports",R.drawable.sports);
        navigateList.add(sports);

    }

}