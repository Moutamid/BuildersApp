package dev.moutamid.buildersapp;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentOnBoardingSpace extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_on_boarding_space, container, false);

//        ImageView progress = view.findViewById(R.id.welcome_imageView);
//
//        AnimationDrawable frameAnimation = (AnimationDrawable) progress.getDrawable();
//        frameAnimation.setCallback(progress);
//        frameAnimation.setVisible(true, true);
//        frameAnimation.start();

        return view;
    }
}
