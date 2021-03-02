package dev.moutamid.buildersapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    private ArrayList<String> currentRequestsArrayList = new ArrayList<>();
    private RecyclerView conversationRecyclerView;
    private RecyclerViewAdapterMessages adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");
        currentRequestsArrayList.add("");

        initRecyclerView();

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: ");

        conversationRecyclerView = findViewById(R.id.recyclerviewHome);
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
            if (holder.getAdapterPosition() == currentRequestsArrayList.size()-1){
                addLayout();
            }
        }

        @Override
        public int getItemCount() {
            if (currentRequestsArrayList == null)
                return 0;
            return currentRequestsArrayList.size();
        }

        public class ViewHolderRightMessage extends RecyclerView.ViewHolder {

            public ViewHolderRightMessage(@NonNull View v) {
                super(v);
            }
        }

        public void addLayout() {

            currentRequestsArrayList.add("");
            notifyItemInserted(currentRequestsArrayList.size() - 1);

        }

    }

}