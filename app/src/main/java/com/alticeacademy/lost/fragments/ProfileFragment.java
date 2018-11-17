package com.alticeacademy.lost.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;

import com.alticeacademy.lost.MainActivity;
import com.alticeacademy.lost.R;
import com.bumptech.glide.Glide;

import static android.content.Intent.getIntent;

public class ProfileFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView textView = v.findViewById(R.id.txtNameUser);
        ImageView imageView = v.findViewById(R.id.imgUserPhoho);

        String user = getActivity().getIntent().getStringExtra("names");
        textView.setText(user);
        if (URLUtil.isValidUrl(MainActivity.userPhoto))
                                Glide.with(getActivity()).load(Uri.parse(MainActivity.userPhoto)).into(imageView);

        return v;
    }
}
