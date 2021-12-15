package com.example.check;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("users")
    Call<List<NumbersView>> getHeroes();

    @GET("photos")
    Call<List<ImageViewResponce>> getimages();

}
