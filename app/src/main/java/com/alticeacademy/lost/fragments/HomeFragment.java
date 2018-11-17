package com.alticeacademy.lost.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alticeacademy.lost.Post;
import com.alticeacademy.lost.R;
import com.alticeacademy.lost.adpaters.PostRecyclerAdpater;

import java.util.ArrayList;
import java.util.List;

public final class HomeFragment extends Fragment {

    //private static final HomeFragment homeFragment = new HomeFragment();

    public HomeFragment() {
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.my_recycler_view);
        recyclerView.setFocusable(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(new PostRecyclerAdpater(getActivity(), getPosts()));

        return v;
    }


    private List<Post> getPosts(){
        List<Post> posts = new ArrayList<>();

        posts.add(new Post("548ss5", "Manzana Roja", getString(R.string.txt_lost_description)
                ,"25 Nom. a las 5:30 pm", "Franklin Frias",
                "http://vinrosa.com/example/pineapple.jpg"));

        posts.add(new Post("548ss5", "Manzana Roja", getString(R.string.txt_lost_description)
                ,"25 Nom. a las 5:30 pm", "Franklin Frias",
                "http://vinrosa.com/example/pineapple.jpg"));

        posts.add(new Post("548ss5", "Manzana Roja", getString(R.string.txt_lost_description)
                ,"25 Nom. a las 5:30 pm", "Franklin Frias",
                "http://vinrosa.com/example/pineapple.jpg"));

        posts.add(new Post("548ss5", "Manzana Roja", getString(R.string.txt_lost_description)
                ,"25 Nom. a las 5:30 pm", "Franklin Frias",
                "http://vinrosa.com/example/pineapple.jpg"));

        posts.add(new Post("548ss5", "Manzana Roja", getString(R.string.txt_lost_description)
                ,"25 Nom. a las 5:30 pm", "Franklin Frias",
                "http://vinrosa.com/example/pineapple.jpg"));

        posts.add(new Post("548ss5", "Manzana Roja", getString(R.string.txt_lost_description)
                ,"25 Nom. a las 5:30 pm", "Pedro",
                "http://vinrosa.com/example/pineapple.jpg"));

        posts.add(new Post("548ss5", "Manzana Roja", getString(R.string.txt_lost_description)
                ,"25 Nom. a las 5:30 pm", "Franklin Frias",
                "http://vinrosa.com/example/pineapple.jpg"));

        return posts;
    }

}
