package dev.moutamid.buildersapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    private ArrayList<String> currentRequestsArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initRecyclerView(R.id.recyclerviewHome1);
        initRecyclerView(R.id.recyclerviewHome2);
        initRecyclerView(R.id.recyclerviewHome3);
        initRecyclerView(R.id.recyclerviewHome4);
        initRecyclerView(R.id.recyclerviewHome5);

        ImageView middleImage, profileimage, homeimage, nightmodeimage;
        middleImage = findViewById(R.id.middlebtn);
        profileimage = findViewById(R.id.profileiconimage);
        homeimage = findViewById(R.id.homeiconimage);
        nightmodeimage = findViewById(R.id.nightmodeimage);

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {

            middleImage.setImageResource(R.drawable.ic_search_white);
            profileimage.setImageResource(R.drawable.ic_profile_white);
            homeimage.setImageResource(R.drawable.ic_home_white);
            middleImage.setImageResource(R.drawable.ic_search_white);
            nightmodeimage.setImageResource(R.drawable.ic_night_mode_white);
        } else {
            middleImage.setImageResource(R.drawable.ic_search_black);
            profileimage.setImageResource(R.drawable.ic_profile_black);
            homeimage.setImageResource(R.drawable.ic_home_black);
            middleImage.setImageResource(R.drawable.ic_search_black);
            nightmodeimage.setImageResource(R.drawable.ic_night_black);
        }

        nightmodeimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                recreate();

            }
        });
    }

    private void initRecyclerView(int Id) {
        Log.d(TAG, "initRecyclerView: ");

        RecyclerView conversationRecyclerView;
        RecyclerViewAdapterMessages adapter;
        conversationRecyclerView = findViewById(Id);
        adapter = new RecyclerViewAdapterMessages();

        LinearLayoutManager layoutManagerUserOwn = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
//        linearLayoutManager.setStackFromEnd(true);

        conversationRecyclerView.setLayoutManager(layoutManagerUserOwn);
//        conversationRecyclerView.setHasFixedSize(true);
//        conversationRecyclerView.setNestedScrollingEnabled(false);

        conversationRecyclerView.setAdapter(adapter);


    }

    private class RecyclerViewAdapterMessages extends RecyclerView.Adapter
            <RecyclerViewAdapterMessages.ViewHolderRightMessage> {

        @NonNull
        @Override
        public ViewHolderRightMessage onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_news, parent, false);
            return new ViewHolderRightMessage(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolderRightMessage holder, int position) {
//            if (holder.getAdapterPosition() == currentRequestsArrayList.size()-1){
//                addLayout();
//            }
        }

        @Override
        public int getItemCount() {
            if (currentRequestsArrayList == null)
                return 0;
            return 1000;
        }

        public class ViewHolderRightMessage extends RecyclerView.ViewHolder {

            public ViewHolderRightMessage(@NonNull View v) {
                super(v);
            }
        }

//        public void addLayout() {
//
//            currentRequestsArrayList.add("");
//            notifyItemInserted(currentRequestsArrayList.size() - 1);
//
//        }

    }

}