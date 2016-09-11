package com.example.aldulaimi.testing;

/**
 * Created by Aldulaimi on 9/10/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TypeList extends Fragment {
    private View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_typelist, container, false);

        return rootView;
    }
}
