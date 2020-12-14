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

public class HealthActivity extends AppCompatActivity {

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
                        intent = new Intent(HealthActivity.this, MainActivity.class);
                        break;
                    case 1:
                        intent=new Intent(HealthActivity.this,EntertainmentActivity.class);
                        break;
                    case 2:
                        intent=new Intent(HealthActivity.this,HealthActivity.class);
                        break;
                    case 3:
                        intent=new Intent(HealthActivity.this,ScienceActivity.class);
                        break;
                    case 4:
                        intent=new Intent(HealthActivity.this,SportsActivity.class);
                }

                startActivity(intent);
            }
        });

        NewsAdapter adapter2=new NewsAdapter(HealthActivity.this, R.layout.news_item,newsList);
        final ListView listView=(ListView)findViewById(R.id.list_view1);
        listView.setAdapter(adapter2);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News news =newsList.get(position);
                Intent intent=null;
                switch (position){
                    case 0:
                        intent=new Intent(HealthActivity.this,Healthweb1Activity.class);
                        break;
                    case 1:
                        intent=new Intent(HealthActivity.this,Healthweb2Activity.class);
                        break;
                    case 2:
                        intent=new Intent(HealthActivity.this,Healthweb3Activity.class);
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
        News new1 = new News("武汉新冠康复者：病毒并不可怕，可怕的是歧视、误解和谣言",R.drawable.health_1);
        newsList.add(new1);
        News new2 =new News("有一种「酷刑」，是听指甲刮黑板的声音",R.drawable.health_2);
        newsList.add(new2);
        News new3=new News("我们常吃的加工肉，为什么是一类致癌物？",R.drawable.health_3);
        newsList.add(new3);
    }

}