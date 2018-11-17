package com.alticeacademy.lost;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.alticeacademy.lost.adpaters.PageAdapter;
import com.alticeacademy.lost.firebase.AuthAbstratActivity;
import com.alticeacademy.lost.fragments.SignInFragment;
import com.alticeacademy.lost.fragments.SignUpFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    //@SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = findViewById(R.id.myLoginToolBar);
        viewPager = findViewById(R.id.loginViewPager);
        tabLayout = findViewById(R.id.myTabLayout);
        seUpViewPager();

       if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

    }

    private ArrayList<Fragment> addFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new SignInFragment());
        fragments.add(new SignUpFragment());

        return fragments;
    }

    private void seUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), addFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_profile_white);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_add_user);
    }
}

    //log into the application
   /* public void signIn(){
        progressDialog.setMessage("Validating");
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(user.getText().toString().trim(),
                pass.getText().toString().trim())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //User is logged in
                            Toast.makeText(LoginActivity.this, "Registro Exitoso", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Pass o Usuario incorrecto", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }*/


    /*@Override
    public void onClick(View v) {

        //validate if user and pass are not empty
        if(validateFields(user.getText().toString(), pass.getText().toString())){

            switch (v.getId()){

                case R.id.btn_SignIn:
                    signIn();
                    return;

                case 2:
                   // signUp(new User());
                    return;
            }


        }*/

   /* public boolean validateFields(String user, String pass){
        boolean okResult = true;
        if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) {
            okResult = false;
        }
        return okResult;
    }*/


