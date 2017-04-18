package com.example.lenovo.controller.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.lenovo.controller.R;

/**
 * Created by lenovo on 2017/4/14.
 */

public class ContentNowFragment extends android.support.v4.app.Fragment{
    private SeekBar seekBar;
    private TextView seekBarValue;
    private Spinner tempSp;
    private Spinner humSp;
    String[] tempData={"无","10","20"};
    String[] humData={"无","10","20"};

    public static ContentNowFragment newInstance(String param1){
        ContentNowFragment fragment=new ContentNowFragment();
        //Bundle args=new Bundle();
        //args.putString("args1",param1);
        //fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.content_now_fragment,container,false);
        //Bundle bundle=getArguments();
        //String args1=bundle.getString("args1");
        seekBar=(SeekBar)view.findViewById(R.id.seekBar);
        seekBarValue=(TextView)view.findViewById(R.id.seekBarValue);
        seekBar.setMax(100);
        seekBar.setProgress(20);
        seekBarValue.setText("当前数值为：20");
        tempSp=(Spinner)view.findViewById(R.id.temperature_sp);
        humSp=(Spinner)view.findViewById(R.id.humidity_sp);
        ArrayAdapter<String> adapterTemp=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,tempData);
        adapterTemp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tempSp.setAdapter(adapterTemp);
        ArrayAdapter<String> adapterHum=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,tempData);
        adapterHum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        humSp.setAdapter(adapterHum);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarValue.setText("当前数值为："+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
