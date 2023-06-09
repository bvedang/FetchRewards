package com.example.fetchrewardexercise;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The main activity of the application.
 * Fetches the items, filters out items where "name" is blank or null,
 * sorts the items, and updates the RecyclerView with the sorted items.
 */

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private final List<Items> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED){
            fetchData();
        } else {
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    public void fetchData(){

        // Initialize Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Initialize ApiService
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Items>> call = apiService.getItems();
        // Fetch the data
        call.enqueue(new Callback<List<Items>>() {
            @Override
            public void onResponse(@NonNull Call<List<Items>> call, Response<List<Items>> response) {
                if (response.isSuccessful()) {
                    List<Items> items = response.body();

                    // Filter out any items where "name" is blank or null
                    for (Items item : items) {
                        if (item.getName() != null && !item.getName().isEmpty()) {
                            itemList.add(item);
                        }
                    }

                    // Sort the results first by "listId" then by "name"
                    Collections.sort(itemList);

                    // Set the adapter
                    recyclerView.setAdapter(new ItemAdapter(MainActivity.this, itemList));
                }
            }

            @Override
            public void onFailure(Call<List<Items>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
            }

        });
    }
}