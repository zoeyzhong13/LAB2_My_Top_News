package com.example.lab2_my_top_news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Navigate> navigateList=new ArrayList<>();
    private List<News> newsList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavigates();
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
                        intent = new Intent(MainActivity.this, MainActivity.class);
                        break;
                    case 1:
                        intent=new Intent(MainActivity.this,EntertainmentActivity.class);
                        break;
                    case 2:
                        intent=new Intent(MainActivity.this,HealthActivity.class);
                        break;
                    case 3:
                        intent=new Intent(MainActivity.this,ScienceActivity.class);
                        break;
                    case 4:
                        intent=new Intent(MainActivity.this,SportsActivity.class);
                }

                startActivity(intent);
            }

        });

        iniNews();
        NewsAdapter adapter2=new NewsAdapter(MainActivity.this, R.layout.news_item,newsList);
        final ListView listView=(ListView)findViewById(R.id.list_view1);
        listView.setAdapter(adapter2);

    }

    private void initNews(){
        News new1 = new News("特朗普：我不想等到2024年，我想三周后就去白宫就职",R.drawable.business_1);
        newsList.add(new1);
        News new2 =new News("中国嫦娥“奔月”，崔娃“暴露”了",R.drawable.business_2);
        newsList.add(new2);
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