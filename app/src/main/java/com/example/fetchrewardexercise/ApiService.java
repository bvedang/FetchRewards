package com.example.fetchrewardexercise;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("hiring.json")
    Call<List<Items>> getItems();
}
