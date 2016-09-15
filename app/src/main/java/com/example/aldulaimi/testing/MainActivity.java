package com.example.aldulaimi.testing;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;


import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.aldulaimi.testing.tabs.PagerAdapter1;

public class MainActivity extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {
    AHBottomNavigation bottomNavigation;
    private Menu menu;
    private String title;
// testing1989
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        bottomNavigation = (AHBottomNavigation) findViewById(R.id.myBottomNavigation_ID);
        bottomNavigation.setOnTabSelectedListener(this);
        this.createNavItems();
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.bruin));

    }

    // Create bottom bar buttons
    private void createNavItems() {
        //CREATE ITEMS
        AHBottomNavigationItem infoItem = new AHBottomNavigationItem("معلومات", R.drawable.ic_action_info);
        AHBottomNavigationItem guideItem = new AHBottomNavigationItem("دليل", R.drawable.ic_action_food);
        AHBottomNavigationItem recipesItem = new AHBottomNavigationItem("وصفات طعام", R.drawable.ic_action_recipes);
        AHBottomNavigationItem shoppingItem = new AHBottomNavigationItem("التسوق", R.drawable.ic_action_shopping);

        //ADD ITEMS TO BAR
        bottomNavigation.addItem(infoItem);
        bottomNavigation.addItem(guideItem);
        bottomNavigation.addItem(recipesItem);
        bottomNavigation.addItem(shoppingItem);

        bottomNavigation.setForceTitlesDisplay(true);
        // bottomNavigation.addItem(docsItem);
        // PROPERTIES
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#0051ff"));
        bottomNavigation.setAccentColor(Color.parseColor("#ff0000"));
        bottomNavigation.setInactiveColor(Color.parseColor("#FFFFFF"));
        bottomNavigation.setTitleTextSize(25, 35);
        bottomNavigation.setCurrentItem(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Navigate along the fragments
    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {

        switch (position) {
            case 0:
                AboutFragment aboutFragment = new AboutFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content_id, aboutFragment).commit();
                return true;
            case 1:
                GuideFragment guideFragment = new GuideFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content_id, guideFragment).commit();
                return true;
            case 2:
                RecipesFragment recipesFragment = new RecipesFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content_id, recipesFragment).commit();
                return true;
            case 3:
                ShoppingFragment shoppingFragment = new ShoppingFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content_id, shoppingFragment, shoppingFragment.getClass().getName()).commit();
                return true;
            default:
                return false;
        }

    }

}

