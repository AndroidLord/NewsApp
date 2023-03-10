package com.example.newsapp.utils;

import com.example.newsapp.model.NewsModel;
import com.example.newsapp.request.NewsApiClient;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsAPI {


    @GET("top-headlines")
    Call<NewsApiClient> getHeadlineNews(
            @Query("country") String country,
            @Query("pageSize") String pageSize,
            @Query("apiKey") String apiKey
            );

    @GET("top-headlines")
    Call<NewsApiClient> getCategoryNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") String pageSize,
            @Query("apiKey") String apiKey
    );


}
