package com.example.modulmapper;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Button student_btn, client_btn;
    DatabaseHelper db;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mToggle;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.main_app_bar);
        NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        db=new DatabaseHelper(this);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
      //  navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
        student_btn = (Button)findViewById(R.id.student_btn);
        client_btn = (Button)findViewById(R.id.client_btn);

        student_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, studentLogin.class);
                startActivity(i);
            }
        });
        client_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, clientLogin.class);
                startActivity(i);
            }
        });
        db.addCourses();
        db.addNetworkSem1();
        db.addNetworkSem2();
        db.addNetworkSem3();
        db.addNetworkSem4();
        db.addNetworkSem5();
        db.addNetworkSem6();
        db.addDBSem1();
        db.addDBSem2();
        db.addDBSem3();
        db.addDBSem4();
        db.addDBSem5();
        db.addDBSem6();
        db.addWEBSem1();
        db.addWEBSem2();
        db.addWEBSem3();
        db.addWEBSem4();
        db.addWEBSem5();
        db.addWEBSem6();
        db.addSoftwareSem1();
        db.addSoftwareSem2();
        db.addSoftwareSem3();
        db.addSoftwareSem4();
        db.addSoftwareSem5();
        db.addSoftwareSem6();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment=null;
        int id=item.getItemId();
        if (id == R.id.aboutus) {
            fragment=new fragmentaboutus();

            // Handle the camera actio
        } else if (id == R.id.contactus) {
            fragment=new fragmentcontactus();
        } else if (id == R.id.info) {
            fragment=new fragmentinfo();
        }
        if(fragment!=null){
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction ft=fragmentManager.beginTransaction();
            ft.replace(R.id.linear1,fragment);
            ft.commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}
