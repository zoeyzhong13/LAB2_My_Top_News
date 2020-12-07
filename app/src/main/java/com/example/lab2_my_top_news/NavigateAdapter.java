package com.example.lab2_my_top_news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

public class NavigateAdapter extends RecyclerView.Adapter<NavigateAdapter.ViewHolder> {

    private List<Navigate> mNavigateList;

    OnItemClickListener listener;

    public interface OnItemClickListener{
        public void OnItemClick(View v,int position,String id);
    }
    public void setOnItemClick(OnItemClickListener listener){
        this.listener=listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView NavigateImage;
        TextView NavigateName;

        public ViewHolder(View view){
            super(view);
            NavigateImage=(ImageView)view.findViewById(R.id.navigate_image);
            NavigateName=(TextView) view.findViewById(R.id.navigate_name);
        }
    }

    public NavigateAdapter(List<Navigate> navigateList){
        mNavigateList=navigateList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.navigate_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position){
        final  Navigate navigate=mNavigateList.get(position);
        holder.NavigateImage.setImageResource(navigate.getImageId());
        holder.NavigateName.setText(navigate.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.OnItemClick(v,position,mNavigateList.get(position).getName());
                }
            }
        });
    }

    @Override
    public int getItemCount(){
        return mNavigateList.size();
    }
}
