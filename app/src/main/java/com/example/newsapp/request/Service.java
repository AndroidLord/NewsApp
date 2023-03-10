package com.example.newsapp.request;

import com.example.newsapp.utils.Credentials;
import com.example.newsapp.utils.NewsAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {


    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Credentials.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final NewsAPI newsAPI = retrofit.create(NewsAPI.class);

    public static NewsAPI getNewsAPI(){
    return newsAPI;
    }


}
