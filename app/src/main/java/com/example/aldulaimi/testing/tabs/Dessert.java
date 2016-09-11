package com.example.aldulaimi.testing.tabs;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aldulaimi.testing.R;

/**
 * Created by Aldulaimi on 9/8/2016.
 */
public class Dessert extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_my,container,false);
        return rootView;
    }
}
