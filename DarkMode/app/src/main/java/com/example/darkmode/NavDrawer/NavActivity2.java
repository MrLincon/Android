package com.example.darkmode.NavDrawer;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.darkmode.R;

public class NavActivity2 extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav2);

        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle.setText("Activity 3");
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);     //Animation for closing activity
    }
}
