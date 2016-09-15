package com.example.aldulaimi.testing.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aldulaimi.testing.R;

/**
 * Created by Aldulaimi on 9/8/2016.
 */
public class Dinner extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.activity_dinner,container,false);
        return rootView;
    }

}
