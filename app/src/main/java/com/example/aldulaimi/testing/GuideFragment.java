package com.example.aldulaimi.testing;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.aldulaimi.testing.recyclerview.MyAdapter;
import com.example.aldulaimi.testing.recyclerview.Player;
import com.example.aldulaimi.testing.recyclerview.SimpleDividerItemDecoration;

import java.util.ArrayList;

/**
 * Created by Aldulaimi on 9/2/2016.
 */
public class GuideFragment extends Fragment {
    private View rootView;
    private ArrayList<Player> list;
    private EditText editText;
    private String[] titles;
    private SearchView sv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_guide, container, false);

        getActivity().setTitle("الدليل");

        sv = (SearchView) rootView.findViewById(R.id.mSearch);
         // Set the the recycler with an item divider
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.myRecycler);
        rv.addItemDecoration(new SimpleDividerItemDecoration(getActivity().getApplicationContext()));

        //SET ITS PROPETRIES
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setItemAnimator(new DefaultItemAnimator());
        //ADAPTER
        final MyAdapter adapter = new MyAdapter(getActivity(), getData(), 1);
        rv.setAdapter(adapter);
        //SEARCH
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE
                adapter.getFilter().filter(query);
                return false;
            }
        });
        return rootView;
    }

    // Get data from the xml file
    private ArrayList getData() {

        list = new ArrayList<>();

        Resources res = getResources();
        Player r = new Player();
        titles = res.getStringArray(R.array.GuideTitles);
        String[] descriptions = res.getStringArray(R.array.GuideDescriptions);
        int[] images = {R.mipmap.ic_drinkss, R.mipmap.ic_grain, R.mipmap.ic_spice, R.mipmap.ic_sugar, R.mipmap.ic_milk, R.mipmap.ic_oil, R.mipmap.ic_fruit, R.mipmap.ic_meat, R.mipmap.ic_legumes, R.mipmap.ic_vegetables};
        int[] nextImages = {R.drawable.ic_next, R.drawable.ic_next, R.drawable.ic_next, R.drawable.ic_next, R.drawable.ic_next, R.drawable.ic_next, R.drawable.ic_next, R.drawable.ic_next, R.drawable.ic_next, R.drawable.ic_next};
        for (int i = 0; i < 10; i++) {
            r = new Player();
            r.setName(titles[i]);
            r.setPos(descriptions[i]);
            r.setImg(nextImages[i]);
            r.setImg(images[i]);
            list.add(r);
        }
        return list;
    }
}