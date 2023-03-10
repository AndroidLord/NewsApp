package com.example.newsapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.adaptors.NewsRecyclerAdaptor;
import com.example.newsapp.model.NewsModel;
import com.example.newsapp.request.NewsApiClient;
import com.example.newsapp.request.Service;
import com.example.newsapp.utils.Credentials;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScienceFragment extends Fragment {

    private List<NewsModel> newsModelList;
    private NewsRecyclerAdaptor newsRecyclerAdaptor;
    private RecyclerView scienceRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sciencefragment,null);


        scienceRecyclerView = view.findViewById(R.id.scienceRecyclerView);
        newsModelList = new ArrayList<>();
        newsRecyclerAdaptor = new NewsRecyclerAdaptor(newsModelList, getContext());
        scienceRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        scienceRecyclerView.setAdapter(newsRecyclerAdaptor);


        findNews();



        return view;
    }

    private void findNews() {

        Call<NewsApiClient> newsModelCall = Service.getNewsAPI().getCategoryNews(
                Credentials.COUNTRY_CODE,
                "science",
                "100",
                Credentials.API_KEY);

        newsModelCall.enqueue(new Callback<NewsApiClient>() {
            @Override
            public void onResponse(Call<NewsApiClient> call, Response<NewsApiClient> response) {
                if(response.isSuccessful()){
                    newsModelList.addAll(Objects.requireNonNull(response.body()).getArticles());
                    newsRecyclerAdaptor.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<NewsApiClient> call, Throwable t) {

            }
        });

    }
}
