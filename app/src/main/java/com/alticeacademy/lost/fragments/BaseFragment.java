package com.alticeacademy.lost.fragments;

import android.support.v4.app.Fragment;

import com.alticeacademy.lost.R;

public class BaseFragment extends Fragment {

    public BaseFragment(){}

    private static final BaseFragment baseFragment = new BaseFragment();

    public static BaseFragment getInstance(){
        return baseFragment;
    }
}
