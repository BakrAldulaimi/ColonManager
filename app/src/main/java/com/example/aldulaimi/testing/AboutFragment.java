package com.example.aldulaimi.testing;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aldulaimi.testing.recyclerview.MyAdapter;
import com.example.aldulaimi.testing.recyclerview.Player;
import com.example.aldulaimi.testing.recyclerview.SimpleDividerItemDecoration;

import java.util.ArrayList;

/**
 * Created by Aldulaimi on 9/2/2016.
 */
public class AboutFragment extends Fragment {
    String[] crime={"Blindspot","The Player","Silicon Valley","Hannibal","XIII"};
    ArrayList<Player> list;
    private SearchView sv;
    private String[] titles;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.activity_about,container,false);
        getActivity().setTitle("ألفهرس");

        // Set the the recycler with an item divider
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.myRecycler);
        rv.addItemDecoration(new SimpleDividerItemDecoration(getActivity().getApplicationContext()));
        //SET ITS PROPETRIES
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setItemAnimator(new DefaultItemAnimator());
        //ADAPTER
        final MyAdapter adapter = new MyAdapter(getActivity(),getData(), 1);
        rv.setAdapter(adapter);

        return rootView;
    }

    private ArrayList getData() {

        list=new ArrayList<>();

        Resources res = getResources();
        Player r = new Player();
        titles = res.getStringArray(R.array.titles);
        String[] descriptions = res.getStringArray(R.array.descriptions);
        //int[] images = {R.drawable.download, R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download};
        int[] nextImages = {R.drawable.ic_next, R.drawable.ic_next,R.drawable.ic_next,R.drawable.ic_next,R.drawable.ic_next,R.drawable.ic_next,R.drawable.ic_next,R.drawable.ic_next,R.drawable.ic_next,R.drawable.ic_next};
        for(int i = 0; i<13; i++) {
            r = new Player();
            r.setName(titles[i]);
            r.setPos(descriptions[i]);
           // r.setImg(nextImages[i]);
            list.add(r);
        }
        return list;
    }

}



