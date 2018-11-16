package com.alticeacademy.lost;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alticeacademy.lost.fragments.BaseFragment;
import com.alticeacademy.lost.fragments.HomeFragment;
import com.alticeacademy.lost.fragments.MessagesFragment;
import com.alticeacademy.lost.fragments.PostingFragment;
import com.alticeacademy.lost.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
                    selectedFragment = new MessagesFragment();//temporary
                  break;
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

        /*RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setFocusable(true);*/
        Toolbar toolbar = findViewById(R.id.myActioBar);
        setSupportActionBar(toolbar);

       // FloatingActionButton fab =  findViewById(R.id.fab);
        BottomNavigationView myNavigation = findViewById(R.id.navigation);
        myNavigation.setOnNavigationItemSelectedListener(myNavigationItemListener);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentsContainer,
                    new HomeFragment()).commit();
        }
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
