package com.example.lab2_my_top_news;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

public class NavigateAdapter extends RecyclerView.Adapter<NavigateAdapter.ViewHolder> {

    private List<Navigate> mNavigateList;

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

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContex())
                .inflate(R.layout.navigate_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Navigate navigate=mNavigateList.get(position);
        holder.navigateImage.setImageResource(navigate.getImageId());
        holder.navigateName.setText(navigate.getName());
    }

    @Override
    public int getItemCount(){
        return mNavigateList.size();
    }
}
