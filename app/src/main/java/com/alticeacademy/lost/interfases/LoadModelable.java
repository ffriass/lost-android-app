package com.alticeacademy.lost.interfases;

import com.alticeacademy.lost.Post;

import java.util.List;

public interface LoadModelable {

    void onStartLoading(String node );
    void onFinished(List<Post> posts, String node);
}
