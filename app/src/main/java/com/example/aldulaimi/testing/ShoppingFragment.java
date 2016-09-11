package com.example.aldulaimi.testing;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aldulaimi.testing.recyclerview.MyAdapter;
import com.example.aldulaimi.testing.recyclerview.Player;

import java.util.ArrayList;

/**
 * Created by Aldulaimi on 9/3/2016.
 */
public class ShoppingFragment extends Fragment{

    private View rootView;
    private ArrayList<Player> list;
    private EditText editText;
    private String[] titles;
    private SearchView sv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.activity_shopping,container,false);

        getActivity().setTitle("About");

        sv = (SearchView) rootView.findViewById(R.id.mSearch);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.myRecycler);
        //SET ITS PROPETRIES
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setItemAnimator(new DefaultItemAnimator());
        //ADAPTER
        final MyAdapter adapter = new MyAdapter(getActivity(),getData(), 2);
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

    private ArrayList getData() {

        list=new ArrayList<>();

        Resources res = getResources();
        Player r = new Player();
        titles = res.getStringArray(R.array.GuideTitles);
        String[] descriptions = res.getStringArray(R.array.GuideDescriptions);
        int[] images = {R.drawable.download, R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download,R.drawable.download};
        int[] nextImages = {R.drawable.ic_next, R.drawable.ic_next,R.drawable.ic_next,R.drawable.ic_next,R.drawable.ic_next,R.drawable.ic_next,R.drawable.ic_next,R.drawable.ic_next,R.drawable.ic_next,R.drawable.ic_next};
        for(int i = 0; i<10; i++) {
            r = new Player();
            r.setName(titles[i]);
            r.setPos(descriptions[i]);
            r.setImg(nextImages[i]);
             list.add(r);
        }
        return list;
    }


}
