package com.example.aldulaimi.testing.tabs;

/**
 * Created by Aldulaimi on 9/8/2016.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter1 extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter1(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0: BreakFast breakFast = new BreakFast();
                return breakFast;

            case 1: Lunch lunch = new Lunch();
                return lunch;

            case 2: Dinner dinner = new Dinner();
                return dinner;

            case 3: Dessert dessert = new Dessert();
                return dessert;

            case 4: Snacks snacks = new Snacks();
                return snacks;
              default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}