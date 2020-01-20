package com.example.darkmode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darkmode.NavDrawer.NavActivity1;
import com.example.darkmode.NavDrawer.NavActivity2;
import com.example.darkmode.NavDrawer.NavActivity3;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbarTitle;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    Button switchModes;
    ThemeSettings themeSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Theme Settings
        themeSettings = new ThemeSettings(this);
        if(themeSettings.loadNightModeState()==false){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        //...............
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);
        switchModes = findViewById(R.id.switch_btn);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle.setText("Dark Mode");

        switchModes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(themeSettings.loadNightModeState()==false){
                    themeSettings.setNightModeState(true);
                    restartApp();   //Recreate activity
                } else {
                    themeSettings.setNightModeState(false);
                    restartApp();   //Recreate activity
                }
            }
        });

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

    //Options Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item2:
                Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Item 3 selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //...................

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


    //Recreate activity

    private void restartApp() {
        Intent i = new Intent(MainActivity.this,MainActivity.class);
        startActivity(i);
        finish();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    //...............
}
