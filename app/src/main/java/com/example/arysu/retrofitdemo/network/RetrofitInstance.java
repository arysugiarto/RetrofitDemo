package com.example.arysu.retrofitdemo.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static Retrofit retrofit;
    public static final String BASE_URL= "http://navjacinth9.000webhostapp.com/json/";

    public static Retrofit getRetrofitInstance(){
        if (retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
