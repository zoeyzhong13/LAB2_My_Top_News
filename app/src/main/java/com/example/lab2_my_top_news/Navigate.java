package com.example.lab2_my_top_news;

public class Navigate {
    private String name;
    private int imageId;
    public Navigate(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }

    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
