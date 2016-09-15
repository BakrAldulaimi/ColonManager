package com.example.aldulaimi.testing.recyclerview;

/**
 * Created by Aldulaimi on 9/6/2016.
 */

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.example.aldulaimi.testing.R;

import java.util.ArrayList;

/**
 * Created by Hp on 3/17/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> implements Filterable{
    Context c;
    ArrayList<Player> players,filterList;
    CustomFilter filter;
    private int layout;
    private View v;
    public MyAdapter(Context ctx, ArrayList<Player> players, int layout)
    {
        this.layout = layout;
        this.c = ctx;
        this.players = players;
        this.filterList = players;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Check which view to dislpay
        switch (layout) {
            // Set about fragment layout
            case 1:  v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);
                // Set guide fragment layout
            case 2:  v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row2, null);
        }
        //CONVERT XML TO VIEW ONBJ
        //View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,null);
        //HOLDER
        MyHolder holder=new MyHolder(v);
        return holder;
    }
    //DATA BOUND TO VIEWS
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        //BIND DATA
        holder.posTxt.setText(players.get(position).getPos());
        holder.nameTxt.setText(players.get(position).getName());
        if(layout == 1) {
            holder.img.setImageResource(players.get(position).getImg());
        }
        //IMPLEMENT CLICK LISTENET
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Snackbar.make(v,players.get(pos).getName(), Snackbar.LENGTH_SHORT).show();
            }
        });
    }
    //GET TOTAL NUM OF PLAYERS
    @Override
    public int getItemCount() {
        return players.size();
    }
    //RETURN FILTER OBJ
    @Override
    public Filter getFilter() {
        if(filter==null)
        {
            filter=new CustomFilter(filterList,this);
        }
        return filter;
    }
}