package com.example.class10jsonbyretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCall {

    public static String BASE_URL = "http://api.myjson.com/bins/";

    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit(){

        if (retrofit==null){

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();


        }


        return retrofit;
    }

}
