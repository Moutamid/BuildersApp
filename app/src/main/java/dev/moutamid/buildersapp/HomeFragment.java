package dev.moutamid.buildersapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";

    private ArrayList<String> currentRequestsArrayList = new ArrayList<>();
    private View view;
    private Context context = getActivity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);

        initRecyclerView(R.id.recyclerviewHome1);
//        initRecyclerView(R.id.recyclerviewHome2);
//        initRecyclerView(R.id.recyclerviewHome3);
//        initRecyclerView(R.id.recyclerviewHome4);
//        initRecyclerView(R.id.recyclerviewHome5);

//        PorterShapeImageView imageView1 = view.findViewById(R.id.porterImageview1);
//        PorterShapeImageView imageView2 = view.findViewById(R.id.porterImageview2);
//        PorterShapeImageView imageView3 = view.findViewById(R.id.porterImageview3);
//        PorterShapeImageView imageView4 = view.findViewById(R.id.porterImageview4);
//        PorterShapeImageView imageView5 = view.findViewById(R.id.porterImageview5);
//        new displayImageFromUrl(imageView1).execute();
//        new displayImageFromUrl(imageView2).execute();
//        new displayImageFromUrl(imageView3).execute();
//        new displayImageFromUrl(imageView4).execute();
//        new displayImageFromUrl(imageView5).execute();

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
        public ViewHolderRightMessage onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_news, parent, false);
            return new ViewHolderRightMessage(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolderRightMessage holder, int position) {

            new displayImageFromUrl(holder.newsImageView).execute();

        }

        @Override
        public int getItemCount() {
            if (currentRequestsArrayList == null)
                return 0;
            return 1000;
        }

        public class ViewHolderRightMessage extends RecyclerView.ViewHolder {

            PorterShapeImageView newsImageView;

            public ViewHolderRightMessage(@NonNull View v) {
                super(v);
                newsImageView = v.findViewById(R.id.news_imageview_home);
            }
        }

//        public void addLayout() {
//
//            currentRequestsArrayList.add("");
//            notifyItemInserted(currentRequestsArrayList.size() - 1);
//
//        }

    }

    private class displayImageFromUrl extends AsyncTask<Void, Void, Void> {

        PorterShapeImageView imageView;
        Bitmap imageBitmap;

        public displayImageFromUrl(PorterShapeImageView imageView) {
            this.imageView = imageView;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                URL url = new URL("https://picsum.photos/200");
                imageBitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (imageView != null && getActivity() != null) {

                Glide.with(getActivity()).load(imageBitmap)
                        .placeholder(R.drawable.rectangle_4)
                        .into(imageView);
            }
        }
    }

}

