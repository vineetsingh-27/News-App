package com.example.recyclerview;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<News> newsList = new ArrayList<>();
    NewsRecyclerView newsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        newsRecyclerView = new NewsRecyclerView(newsList, this);
        recyclerView.setAdapter(newsRecyclerView);

        fetchNews();
    }

    public void fetchNews(){
        ApiInterface apiInterface = RetrofitApiCall.getClient().create(ApiInterface.class);
        Call<NewsResponse> call = apiInterface.getNews("us","88c4bb651ba340d6a3de4e30e691fe8e");
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    newsList.clear();
                    newsList.addAll(response.body().getArticles());
                    newsRecyclerView.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to fetch news", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to load News", Toast.LENGTH_SHORT).show();
            }
        });
    }
}