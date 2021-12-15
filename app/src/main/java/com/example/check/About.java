package com.example.check;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class About extends AppCompatActivity {
    List<ImageViewResponce> arrayList = new ArrayList<ImageViewResponce>();
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView aboutListView = findViewById(R.id.listView);



        Call<List<ImageViewResponce>> call = RetrofitClient.getInstance().getMyApi().getimages();
        call.enqueue(new Callback<List<ImageViewResponce>>() {
            @Override
            public void onResponse(Call<List<ImageViewResponce>> call, Response<List<ImageViewResponce>> response) {
                List<ImageViewResponce> heroList = response.body();

                Log.d("list size: ", String.valueOf(heroList.size()));
                ImageViewAdapter ImageViewAdapter = new ImageViewAdapter(heroList,About.this);
                aboutListView.setAdapter(ImageViewAdapter);

            }

            @Override
            public void onFailure(Call<List<ImageViewResponce>> call, Throwable t) {
                Log.d("error: ",t.getMessage());
                t.printStackTrace();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}