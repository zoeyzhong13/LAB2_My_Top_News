package com.example.lab2_my_top_news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {
    private int resourseId;
    public NewsAdapter(Context context, int textViewResourseId, List<News> objects){
        super(context,textViewResourseId,objects);
        resourseId=textViewResourseId;
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent){
        News news=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourseId,parent,false);
        ImageView newsImage=view.findViewById(R.id.newsImage);
        TextView newsText=view.findViewById(R.id.newsText);
        newsImage.setImageResource(news.getImageId());
        newsText.setText(news.getName());
        return view;
    }
}