package com.example.class10jsonbyretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ExampleViewHolder> {

    private Context mContext;
    private List<Profile.ProfileList> profileArrayList;

    public ProfileAdapter(Context mContext, List<Profile.ProfileList> profileArrayList) {
        this.mContext = mContext;
        this.profileArrayList = profileArrayList;

    }

    @NonNull
    @Override
    public ProfileAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.profile, parent, false);

        return new ProfileAdapter.ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {

        Profile.ProfileList currentPosition = profileArrayList.get(position);

        String name = currentPosition.getName();
        String age = currentPosition.getAge();
        String address = currentPosition.getAddress();
        String birth_date = currentPosition.getBirth_date();
        String photo = currentPosition.getPhoto();

        holder.name.setText(name +" "+ age);
        holder.address.setText(address);
        holder.birthDate.setText(birth_date);


        Picasso.get().load(photo).into(holder.profileImage);



    }


    @Override
    public int getItemCount() {
        return profileArrayList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {

        CircleImageView profileImage;
        TextView name, birthDate, address;

        public ExampleViewHolder(@NonNull View view) {
            super(view);

        profileImage = view.findViewById(R.id.photoId);
        name = view.findViewById(R.id.nameId);
        address = view.findViewById(R.id.addresId);
        birthDate = view.findViewById(R.id.birthDateId);



        }
    }
}
