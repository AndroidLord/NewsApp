package com.example.newsapp.adaptors;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.WebViewActivity;
import com.example.newsapp.model.NewsModel;

import java.util.List;

public class NewsRecyclerAdaptor extends RecyclerView.Adapter<NewsRecyclerAdaptor.ViewHolder> {

    private List<NewsModel> list;
    private Context context;

    public NewsRecyclerAdaptor(List<NewsModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsRecyclerAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRecyclerAdaptor.ViewHolder holder, int position) {

        NewsModel newsModel = list.get(position);

        holder.author.setText(newsModel.getAuthor());
        holder.content.setText(newsModel.getContent());
        holder.publishedAt.setText(newsModel.getPublishedAt());
        holder.author.setText(newsModel.getAuthor());
        holder.title.setText(newsModel.getTitle());

        Glide.with(context).load(newsModel.getUrlToImage()).into(holder.urlToImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, WebViewActivity.class);
                intent.putExtra("url",newsModel.getUrl());
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

         TextView author,
                        title,
                        publishedAt,
                        url,
                        content;

        public ImageView urlToImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            author = itemView.findViewById(R.id.author_item);
            title = itemView.findViewById(R.id.mainHeading_item);
            content = itemView.findViewById(R.id.content_item);
            publishedAt = itemView.findViewById(R.id.dateTime_item);
            urlToImage = itemView.findViewById(R.id.image_item);




        }


    }

}
