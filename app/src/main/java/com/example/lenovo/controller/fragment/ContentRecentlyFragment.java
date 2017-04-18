package com.example.lenovo.controller.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.controller.R;

/**
 * Created by lenovo on 2017/4/14.
 */

public class ContentRecentlyFragment extends android.support.v4.app.Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.content_recently_fragment,container,false);
        return view;
    }
}
