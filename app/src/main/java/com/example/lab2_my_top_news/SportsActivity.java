package com.example.lab2_my_top_news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SportsActivity extends AppCompatActivity {

    private List<Navigate> navigateList=new ArrayList<>();
    private List<News> newsList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavigates();
        initNews();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        NavigateAdapter adapter=new NavigateAdapter(navigateList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClick(new NavigateAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View v, int position, String id) {
                Intent intent=null;
                switch (position){
                    case 0:
                        intent = new Intent(SportsActivity.this, MainActivity.class);
                        break;
                    case 1:
                        intent=new Intent(SportsActivity.this,EntertainmentActivity.class);
                        break;
                    case 2:
                        intent=new Intent(SportsActivity.this,HealthActivity.class);
                        break;
                    case 3:
                        intent=new Intent(SportsActivity.this,ScienceActivity.class);
                        break;
                    case 4:
                        intent=new Intent(SportsActivity.this,SportsActivity.class);
                }

                startActivity(intent);
            }
        });

        NewsAdapter adapter2=new NewsAdapter(SportsActivity.this, R.layout.news_item,newsList);
        final ListView listView=(ListView)findViewById(R.id.list_view1);
        listView.setAdapter(adapter2);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News news =newsList.get(position);
                Intent intent=null;
                switch (position){
                    case 0:
                        intent=new Intent(SportsActivity.this,Sportsweb1Activity.class);
                        break;
                    case 1:
                        intent=new Intent(SportsActivity.this,Sportsweb2Activity.class);
                        break;
                    case 2:
                        intent=new Intent(SportsActivity.this,Sportsweb3Activity.class);
                }
                startActivity(intent);
            }


        });

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

    private void initNews(){
        News new1 = new News("猛龙全民皆兵击败黄蜂 三球首秀0分10篮板4助攻",R.drawable.sports_1);
        newsList.add(new1);
        News new2 =new News("西甲-卡塞米罗破门奥布拉克乌龙 皇马2-0送马竞首败",R.drawable.sports_2);
        newsList.add(new2);
        News new3=new News("单场3红牌!苏宁大将锁喉被罚下 泰达助教被逐出场",R.drawable.sports_3);
        newsList.add(new3);
    }

}