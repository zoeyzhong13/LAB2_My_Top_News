package com.example.lab2_my_top_news;

import android.widget.ArrayAdapter;

public class NewsAdapter extends ArrayAdapter<news> {
    private int resourseId;
    public NewsAdapter(Context context, int textViewResourseId, List<news> objects){
        super(context,textViewResourseId,objects);
        resourseId=textViewResourseId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        News news=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourseId,parent,false);
        ImageView newsImage=view.findViewById(R.id.newsImage);
        TextView newsText=view.findViewById(R.id.newsText);
        newsImage.setImageResource(news.getIamgeId());
        newsText.setText(news.getNews());
        return view;
    }
}