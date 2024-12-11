package com.example.recyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("v2/top-headlines")
    Call<NewsResponse> getNews(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );
}
