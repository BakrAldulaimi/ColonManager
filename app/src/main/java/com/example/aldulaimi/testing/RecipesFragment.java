package com.example.aldulaimi.testing;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aldulaimi.testing.tabs.PagerAdapter1;

/**
 * Created by Aldulaimi on 9/3/2016.
 */
public class RecipesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_recipes, container, false);
        getActivity().setTitle("وصفات طعام");

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("الافطار"));
        tabLayout.addTab(tabLayout.newTab().setText("الغداء"));
        tabLayout.addTab(tabLayout.newTab().setText("العشاء"));
        tabLayout.addTab(tabLayout.newTab().setText("الحلويات"));
        tabLayout.addTab(tabLayout.newTab().setText("مقبلات"));
        tabLayout.setTabTextColors(Color.WHITE, Color.RED);
        //tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        final ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.pager);
        final PagerAdapter1 adapter1 = new PagerAdapter1(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter1);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        return rootView;
    }
}
