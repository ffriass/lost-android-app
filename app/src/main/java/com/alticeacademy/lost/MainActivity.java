package com.alticeacademy.lost;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alticeacademy.lost.fragments.BaseFragment;
import com.alticeacademy.lost.fragments.HomeFragment;
import com.alticeacademy.lost.fragments.MessagesFragment;
import com.alticeacademy.lost.fragments.PostingFragment;
import com.alticeacademy.lost.fragments.ProfileFragment;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String user ="names";
    public static final String userPhoto ="photo";

    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;
    private int CAMERA_REQUEST_CODE = 0;
    private ProgressDialog progressDialog;
    private StorageReference mStorage;
    private DatabaseReference mDatabase;
    private ImageView imageProfile;
    private TextView textName;

    private BottomNavigationView.OnNavigationItemSelectedListener myNavigationItemListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navigation_profile:
                    selectedFragment = new ProfileFragment();
                    break;
                case R.id.navigation_post:
                    selectedFragment = new PostingFragment();
                    break;
                case R.id.navigation_message:
                    selectedFragment = new MessagesFragment();
                    break;
                case R.id.navigation_settings:
                    //selectedFragment = new MessagesFragment();//temporary

                  return true;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentsContainer,
                    selectedFragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.myActioBar);
        setSupportActionBar(toolbar);

        BottomNavigationView myNavigation = findViewById(R.id.navigation);
        myNavigation.setOnNavigationItemSelectedListener(myNavigationItemListener);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentsContainer,
                    new HomeFragment()).commit();
        }



        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    mStorage = FirebaseStorage.getInstance().getReference();
                    mDatabase = FirebaseDatabase.getInstance().getReference().child("users");
                    mDatabase.child(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            textName.setText(String.valueOf(dataSnapshot.child("name").getValue()));
                            String imageUrl = String.valueOf(dataSnapshot.child("image").getValue());
                            if (URLUtil.isValidUrl(imageUrl))
                                Glide.with(MainActivity.this).load(Uri.parse(imageUrl)).into(imageProfile);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                } else {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };
    }

    public void goActivity(Context context, Class myClass){
        startActivity(new Intent(context, myClass));
    }

    @Override
    public void onClick(View v) {
        //goActivity(this, Main2Activity.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_elements, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_notification :

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
