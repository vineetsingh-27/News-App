package com.example.recyclerview;

import com.google.gson.annotations.SerializedName;

public class News {
    @SerializedName("title")
    private String title;
    @SerializedName("urlToImage")
    private String newsUrlImage;
    @SerializedName("description")
    private String newsDesc;

    public News(String title, String newsUrlImage, String newsDesc) {
        this.title = title;
        this.newsUrlImage = newsUrlImage;
        this.newsDesc = newsDesc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsUrlImage() {
        return newsUrlImage;
    }

    public void setNewsUrlImage(String newsUrlImage) {
        this.newsUrlImage = newsUrlImage;
    }

    public String getNewsDesc() {
        return newsDesc;
    }

    public void setNewsDesc(String newsDesc) {
        this.newsDesc = newsDesc;
    }
}
