package com.alticeacademy.lost.fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alticeacademy.lost.LoginActivity;
import com.alticeacademy.lost.MainActivity;
import com.alticeacademy.lost.R;
import com.alticeacademy.lost.User;
import com.alticeacademy.lost.firebase.AuthAbstratFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpFragment extends AuthAbstratFragment implements View.OnClickListener {



    public SignUpFragment() {
        // Required empty public constructor
    }


    private EditText userName, userLastName;
    private Button buttonSignUp;
    private ProgressDialog progressDialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_signup, container, false);

        LostDatabase = FirebaseDatabase.getInstance().getReference("LostDatabase");
        mAuth = FirebaseAuth.getInstance();

        userName = v.findViewById(R.id.txtUserName);
        userLastName = v.findViewById(R.id.txtUserlastName);
        user =  v.findViewById(R.id.txtUserEmail);
        pass =  v.findViewById(R.id.txtUserPassword);
        buttonSignUp = v.findViewById(R.id.btn_SignUp);
        progressDialog = new ProgressDialog(getActivity());
        buttonSignUp.setOnClickListener(this);

        return  v;
    }

    @Override
    public String getActivityName() {
        return "LoginActivity";
    }

    //for registering users
    private void signUp(){
        //at the moment I'm only using the email and password
        //Here a catch te full name of the user
        String userCompleteName = userName.getText().toString()+" "+ userLastName.getText();

        progressDialog.setMessage("Registering User");
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(user.getText().toString().trim(),
                pass.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    String id = task.getResult().getUser().getUid();

                    try {
                        //I build the user into the method
                        saveUserInfo(new User(id,userName.getText().toString(), userLastName.getText().toString(),""));
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        intent.putExtra(MainActivity.user,userCompleteName);
                        startActivity(intent);
                        Toast.makeText(getActivity(), "Registro exitoso", Toast.LENGTH_LONG).show();
                        getActivity().finish();
                    }catch (Exception e){
                        Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
                    }

                } else {
                    //TODO manage error because it only advice to the user that something went wrong
                    Toast.makeText(getActivity(), "Error al registrase", Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });
    }

    private void saveUserInfo(User user){
        try {
            LostDatabase.child("Users").child(user.getUserID()).setValue(user);
        }catch (Exception e){

        }

    }

    @Override
    public void onClick(View v) {
        //validate if user and pass are not empty
        if(validateFields(user.getText().toString(), pass.getText().toString())){
            switch (v.getId()){

                case R.id.btn_SignUp:
                    signUp();
                    return;

                case 2:
                    //signUp(new User());
                    return;
            }
        }
        else{
            Toast.makeText(getActivity(), "Not blanc fields are allowed", Toast.LENGTH_LONG).show();
        }

    }
}
