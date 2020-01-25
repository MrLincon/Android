package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navigationdrawer.NavDrawer.NavActivity1;
import com.example.navigationdrawer.NavDrawer.NavActivity2;
import com.example.navigationdrawer.NavDrawer.NavActivity3;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbarTitle;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle.setText("Navigation Drawer");


        //Navigation Drawer

        navigationView = findViewById(R.id.navigation_view_left);
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open, R.string.close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        NavigationItems();

        //.................

    }

    //Navigation Drawer Items

    public void NavigationItems() {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull final MenuItem menuItem) {

                //Handler for closing navigation first
                // and performing action onClick after a certain delay

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        switch (menuItem.getItemId()) {
                            case R.id.activity1:
                                Intent activity1 = new Intent(MainActivity.this, NavActivity1.class);
                                startActivity(activity1);
                                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);    //Animation for opening activity
                                Toast.makeText(MainActivity.this, "Activity 1", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.activity2:
                                Intent activity2 = new Intent(MainActivity.this, NavActivity2.class);
                                startActivity(activity2);
                                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);    //Animation for opening activity
                                Toast.makeText(MainActivity.this, "Activity 2", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.activity3:
                                Intent activity3 = new Intent(MainActivity.this, NavActivity3.class);
                                startActivity(activity3);
                                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);    //Animation for opening activity
                                Toast.makeText(MainActivity.this, "Activity 3", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                }, 200);

                //...............

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    //................
}
