package com.example.recyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

public class NewsRecyclerView extends RecyclerView.Adapter<NewsRecyclerView.NewsViewHolder> {

    List<News> newsList;
    Context context;

    public NewsRecyclerView(List<News> newsList, Context context) {
        this.newsList = newsList;
        this.context = context;
    }

    public void setNewsList(List<News> newsList){
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.tvNewsTitle.setText(newsList.get(position).getTitle());
        holder.tvNewsDesc.setText(newsList.get(position).getNewsDesc());
        Glide.with(context).load(newsList.get(position).getNewsUrlImage())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, @Nullable Object model, @NonNull Target<Drawable> target, boolean isFirstResource) {
                        Toast.makeText(context, "Failed to load image", Toast.LENGTH_SHORT).show();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(@NonNull Drawable resource, @NonNull Object model, Target<Drawable> target, @NonNull DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                }).into(holder.ivNewsImage);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder{
        ImageView ivNewsImage;
        TextView tvNewsTitle, tvNewsDesc;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            ivNewsImage = itemView.findViewById(R.id.iv_news_image);
            tvNewsTitle = itemView.findViewById(R.id.tv_news_title);
            tvNewsDesc = itemView.findViewById(R.id.tv_news_desc);
        }
    }
}
