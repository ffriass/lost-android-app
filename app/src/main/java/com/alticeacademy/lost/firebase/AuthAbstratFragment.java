package com.alticeacademy.lost.firebase;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

public abstract class AuthAbstratFragment extends Fragment {

    protected FirebaseAuth.AuthStateListener mAuthListener;
    protected DatabaseReference LostDatabase;
    protected FirebaseAuth mAuth;
    protected int CAMERA_REQUEST_CODE = 0;
    protected ProgressDialog progressDialog;
    protected StorageReference mStorage;
    protected DatabaseReference mDatabase;
    protected EditText user;
    protected EditText pass;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = onCreateView(inflater, container, savedInstanceState);
        LostDatabase = FirebaseDatabase.getInstance().getReference("LostDatabase");
        mAuth = FirebaseAuth.getInstance();
        sendAnalytics(getActivityName());


        return  v;
    }


    private void sendAnalytics(String activityName) {
        //TODO send name to GA
    }

    protected boolean validateFields(String user, String pass){
        boolean okResult = true;
        if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) {
            okResult = false;
        }
        return okResult;
    }
    public abstract String getActivityName();

    protected void goActivity(Context context, Class myClass){
        startActivity(new Intent(context, myClass));
    }

}