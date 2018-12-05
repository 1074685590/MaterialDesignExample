package com.liumeng.myapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer_layout;
    private NavigationView mNavigation_view;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigation_view = (NavigationView) findViewById(R.id.navigation_view);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawer_layout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        mActionBarDrawerToggle.syncState();
        mDrawer_layout.addDrawerListener(mActionBarDrawerToggle);
        setupDrawContent(mNavigation_view);

        setUpProfileImage();
    }

    private void setUpProfileImage() {
        View headerView=  mNavigation_view.inflateHeaderView(R.layout.navigation_header);
        View profileView = headerView.findViewById(R.id.profile_image);
        if (profileView != null) {
            profileView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switchToBlog();
                    mDrawer_layout.closeDrawers();
                    mNavigation_view.getMenu().getItem(1).setChecked(true);
                }
            });
        }
    }

    private void setupDrawContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.navigation_item_book:
                        switchToBook();
                        break;
                    case R.id.navigation_item_example:
                        switchToExample();
                        break;
                    case R.id.navigation_item_blog:
                        switchToBlog();
                        break;
                    case R.id.navigation_item_about:
                        switchToAbout();
                        break;

                }
                item.setChecked(true);
                mDrawer_layout.closeDrawers();
                return true;
            }
        });
    }

    private void switchToAbout() {
        mToolbar.setTitle(R.string.navigation_about);
    }

    private void switchToBlog() {
        mToolbar.setTitle(R.string.navigation_my_blog);
    }

    private void switchToExample() {
        mToolbar.setTitle(R.string.navigation_example);
    }

    private void switchToBook() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content,new BookFragment()).commit();
        mToolbar.setTitle(R.string.navigation_book);
    }


}
