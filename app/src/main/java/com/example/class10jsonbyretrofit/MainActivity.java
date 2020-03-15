package com.example.class10jsonbyretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private ApiInterface apiInterface;
    RecyclerView recyclerView;
    private ArrayList<Profile.ProfileList> profileLists;
    private ProfileAdapter profileadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        apiInterface = ApiCall.getRetrofit().create(ApiInterface.class);

        recyclerView = findViewById(R.id.recylerId);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        profileLists = new ArrayList<Profile.ProfileList>();




        final Call<Profile> profileCall = apiInterface.getProfile();




        profileCall.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {


            List<Profile.ProfileList> lists = response.body().Profile;

            for (Profile.ProfileList profileList: lists){

                String name  = profileList.getName();
                String  age = profileList.getAge();
                String address = profileList.getAddress();
                String birth_date = profileList.getBirth_date();
                String photo = profileList.getPhoto();

                profileLists.add(new Profile.ProfileList(name,age, birth_date,address,photo));

                }

            profileadapter = new ProfileAdapter(MainActivity.this, profileLists);
            recyclerView.setAdapter(profileadapter);

            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

            }
        });

    }
}
