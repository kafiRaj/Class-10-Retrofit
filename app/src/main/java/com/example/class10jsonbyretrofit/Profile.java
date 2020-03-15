package com.example.class10jsonbyretrofit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Profile {



    @SerializedName("Actors")
    public ArrayList<ProfileList> Profile = null;


    public static class ProfileList {

        private String name;
        private String age;

        @SerializedName("Born At")
        private String address;

        @SerializedName("Birthdate")
        private String birth_date;

        private String photo;



        public ProfileList(String name, String age,String birth_date,
                           String address, String photo) {

            this.name = name;
            this.age = age;
            this.birth_date = birth_date;
            this.address = address;
            this.photo = photo;
        }


        public String getName() {
            return name;
        }

        public String getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        public String getBirth_date() {
            return birth_date;
        }

        public String getPhoto() {
            return photo;
        }
    }

}
