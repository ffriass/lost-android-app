package com.alticeacademy.lost;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener myNavigationItem
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_profile:
                    mTextMessage.setText(R.string.title_profile);
                    return true;
                case R.id.navigation_post:
                    mTextMessage.setText(R.string.title_post);
                    return  true;
                case R.id.navigation_message:
                    mTextMessage.setText(R.string.title_message);
                    return true;
                case R.id.navigation_settings:
                    mTextMessage.setText(R.string.title_setting);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.mybutton).setOnClickListener(this);

        mTextMessage = findViewById(R.id.txtTabName);
        BottomNavigationView myNavigation = findViewById(R.id.navigation);
        myNavigation.setOnNavigationItemSelectedListener(myNavigationItem);

    }


    public void goActivity(Context context, Class myClass){
        startActivity(new Intent(context, myClass));
    }

    @Override
    public void onClick(View v) {
        //goActivity(this, Main2Activity.class);
    }
}
