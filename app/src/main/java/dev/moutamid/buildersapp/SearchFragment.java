package dev.moutamid.buildersapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    private static final String TAG = "SearchFragment";
    private View view;

    private ArrayList<String> currentRequestsArrayList = new ArrayList<>();
    private Context context = getActivity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);

        initRecyclerView(R.id.recyclerviewHome1_search);

        return view;
    }

    private void initRecyclerView(int Id) {
        Log.d(TAG, "initRecyclerView: ");

        RecyclerView conversationRecyclerView;
        RecyclerViewAdapterMessages adapter;
        conversationRecyclerView = view.findViewById(Id);
        adapter = new RecyclerViewAdapterMessages();

        LinearLayoutManager layoutManagerUserOwn = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
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
        public RecyclerViewAdapterMessages.ViewHolderRightMessage onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_search_results, parent, false);
            return new RecyclerViewAdapterMessages.ViewHolderRightMessage(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final RecyclerViewAdapterMessages.ViewHolderRightMessage holder, int position) {
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