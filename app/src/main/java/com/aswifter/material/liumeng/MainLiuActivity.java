package com.aswifter.material.liumeng;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.aswifter.material.AboutFragment;
import com.aswifter.material.BlogFragment;
import com.aswifter.material.ExampleFragment;
import com.aswifter.material.R;
import com.aswifter.material.book.BooksFragment;
import com.aswifter.material.widget.BackHandledFragment;

public class MainLiuActivity extends AppCompatActivity {

    private DrawerLayout          mDrawerLayout;
    private   ActionBarDrawerToggle mDrawerToggle;
    private   Toolbar               mToolbar;
    private   BackHandledFragment   selectedFragment;
    private   NavigationView        mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_liu);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle); //不知道这句干啥的去掉也没有看出效果
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        setupDrawerContent(mNavigationView);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {

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
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private void switchToBook() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new BooksFragment()).commit();
        mToolbar.setTitle(R.string.navigation_book);
    }

    private void switchToExample() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new ExampleFragment()).commit();
        mToolbar.setTitle(R.string.navigation_example);
    }

    private void switchToBlog() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new BlogFragment()).commit();
        mToolbar.setTitle(R.string.navigation_my_blog);
    }


    private void switchToAbout() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new AboutFragment()).commit();
        mToolbar.setTitle(R.string.navigation_about);
    }

}
