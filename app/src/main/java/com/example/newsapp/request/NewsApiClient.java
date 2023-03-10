package com.example.newsapp.request;

import com.example.newsapp.model.NewsModel;

import java.util.ArrayList;

public class NewsApiClient {

        private String status;
        private String totalResults;
        private ArrayList<NewsModel> articles;

    public NewsApiClient(String status, String totalResults, ArrayList<NewsModel> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<NewsModel> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<NewsModel> articles) {
        this.articles = articles;
    }
}
