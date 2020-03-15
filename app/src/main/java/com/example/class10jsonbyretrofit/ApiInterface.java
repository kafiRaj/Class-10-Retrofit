package com.example.class10jsonbyretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("18biy2")

    Call<Profile> getProfile();

}
