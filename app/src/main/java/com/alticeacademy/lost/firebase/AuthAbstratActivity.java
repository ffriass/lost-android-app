package com.alticeacademy.lost.firebase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public abstract class AuthAbstratActivity extends AppCompatActivity {

    protected FirebaseAuth mAuth;
    protected EditText user;
    protected EditText pass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        sendAnalytics(getActivityName());
    }

    private void sendAnalytics(String activityName) {
        //TODO send name to GA
    }

    public abstract String getActivityName();

    protected void goActivity(Context context, Class myClass){
        startActivity(new Intent(context, myClass));
    }
}