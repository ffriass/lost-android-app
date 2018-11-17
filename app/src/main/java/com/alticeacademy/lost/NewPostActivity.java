package com.alticeacademy.lost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alticeacademy.lost.firebase.AuthAbstratActivity;

public class NewPostActivity extends AuthAbstratActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
    }

    @Override
    public String getActivityName() {
        return null;
    }

    @Override
    public void onClick(View v) {

    }
}
