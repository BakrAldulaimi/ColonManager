package com.example.aldulaimi.testing.tabs;

/**
 * Created by Aldulaimi on 9/8/2016.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aldulaimi.testing.R;

public class Lunch extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my2, container, false);
    }
}