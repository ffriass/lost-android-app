package com.alticeacademy.lost.fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.Toast;

import com.alticeacademy.lost.BaseEntity;
import com.alticeacademy.lost.LoginActivity;
import com.alticeacademy.lost.MainActivity;
import com.alticeacademy.lost.R;
import com.alticeacademy.lost.User;
import com.alticeacademy.lost.firebase.AuthAbstratFragment;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SignInFragment extends AuthAbstratFragment implements View.OnClickListener {

    public SignInFragment() {
        //Required empty public constructor
    }

    private Button buttonSignIn;
    private ProgressDialog progressDialog;

    FirebaseAuth.AuthStateListener myAuthListener;
    //FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_signin, container, false);

        mDatabase = FirebaseDatabase.getInstance().getReference("LostDatabase");
        mAuth = FirebaseAuth.getInstance();
        initializeComponents(v);
        return v;
    }

    private void initializeComponents(View v){
        user =  v.findViewById(R.id.txtLoginUserEmail);
        pass =  v.findViewById(R.id.txtLoginUserPassword);
        buttonSignIn = v.findViewById(R.id.btn_SignIn);
        progressDialog = new ProgressDialog(getActivity());
        buttonSignIn.setOnClickListener(this);
    }

    //log into the application
    public void signIn(){
        progressDialog.setMessage("Validating");
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(user.getText().toString().trim(),
                pass.getText().toString().trim())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            String id = task.getResult().getUser().getUid();
                            String email = task.getResult().getUser().getEmail();
                            //User is logged in
                            Toast.makeText(getActivity(), "Validacion Exitosa", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            intent.putExtra(MainActivity.user,id+" "+ email);
                            startActivity(intent);
                            getActivity().finish();
                        } else {
                            Toast.makeText(getActivity(), "Pass o Usuario incorrecto", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();

                    }
                });
    }

    @Override
    public String getActivityName() {
        return "LoginAcivity";
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onClick(View v) {
        //validate if user and pass are not empty
        if(validateFields(user.getText().toString(), pass.getText().toString())){
            switch (v.getId()){

                case R.id.btn_SignIn:
                    signIn();
                    return;

                case 2:
                    //signUp(new User());
                    return;
            }
        }
        else{
            Toast.makeText(getActivity(), "Not empty fields are allowed", Toast.LENGTH_LONG).show();
        }


    }

    public  void getUserByID(String id){
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
                    mDatabase.child(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String name = String.valueOf(dataSnapshot.child("userName").getValue());
                            String lastname = String.valueOf(dataSnapshot.child("userLastname"));
                            String imageUrl = String.valueOf(dataSnapshot.child("userPhotoURL").getValue());

                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            intent.putExtra(MainActivity.user,name+" "+ lastname);
                            intent.putExtra(MainActivity.userPhoto,imageUrl);
                            startActivity(intent);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                } else {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().finish();
                }
            }
        };


    }



}
