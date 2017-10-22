package com.supachai.oramon.myeasyservice;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.supachai.oramon.myeasyservice.fragment.MainFragment;
import com.supachai.oramon.myeasyservice.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Add Fragment to Activity
        addFragment(savedInstanceState);

        //Setup Drawer
        setupDrawer();

        //Text Controller
        textController();

        //Create ToolBar
        createToolBar();


    } // main method

    private void createToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolBarMain);
        setSupportActionBar(toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawerLayout,
                R.string.open,
                R.string.close
        );
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void textController() {
        TextView mainTextView = (TextView) findViewById(R.id.txtMainFragment);
        TextView secondTextView = (TextView) findViewById(R.id.txtSecondFragment);
        TextView exitTextView = (TextView) findViewById(R.id.txtExit);

        // For MainFragment
        mainTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.contentFragmentMain, new MainFragment()).commit();

                drawerLayout.closeDrawers();
            }
        });
        // For SecondFragment
        secondTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.contentFragmentMain, new SecondFragment()).commit();
                drawerLayout.closeDrawers();
            }
        });

        // For Exit
        exitTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                drawerLayout.closeDrawers();
            }
        });
    }

    private void setupDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.myDrawerLayout);
    }

    private void addFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFragmentMain, new MainFragment()).commit();
        }
    }
} // main class
