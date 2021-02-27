package dev.moutamid.buildersapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOnBoardingLogoFinal extends Fragment {
    private View view;

//    public LinearLayout logoLayout() {
//
//        return view.findViewById(R.id.logoonboarding);
//
//    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_on_boarding_logofinal, container, false);

        // Extra Coding Here

        return view;
    }
}
