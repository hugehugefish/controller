package com.example.lenovo.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.lenovo.controller.fragment.ContentNowFragment;
import com.example.lenovo.controller.fragment.ContentRecentlyFragment;
import com.example.lenovo.controller.fragment.ContentTodayFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{
    //private LinearLayout tabNow;
    //private LinearLayout tabToday;
    //private LinearLayout tabRecently;

    private ContentNowFragment mNow;
    private ContentTodayFragment mToday;
    private ContentRecentlyFragment mRecently;

    private BottomNavigationBar bottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationBar=(BottomNavigationBar)findViewById(R.id.bottom);
        bottomNavigationBar
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .addItem(new BottomNavigationItem(R.drawable.now,"Now")
                        .setActiveColorResource(R.color.darkforestgreen))
                .addItem(new BottomNavigationItem(R.drawable.today,"Today")
                        .setActiveColorResource(R.color.darkforestgreen))
                .addItem(new BottomNavigationItem(R.drawable.recently,"Recently")
                        .setActiveColorResource(R.color.darkforestgreen))
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
        //初始化下标题栏控件
        //tabNow=(LinearLayout)findViewById(R.id.tab_now);
        //tabToday=(LinearLayout)findViewById(R.id.tab_today);
        //tabRecently=(LinearLayout)findViewById(R.id.tab_recently);
        //tabNow.setOnClickListener(this);
        //tabToday.setOnClickListener(this);
        //tabRecently.setOnClickListener(this);
        //设置默认的Fragment
        setDefaultFragment();
    }

    private void setDefaultFragment(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        mNow=new ContentNowFragment();
        transaction.replace(R.id.content,mNow);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        switch(position){
            case 0:
                if(mNow==null){
                    mNow=new ContentNowFragment();
                }
                transaction.replace(R.id.content,mNow);
                break;
            case 1:
                if(mToday==null){
                    mToday=new ContentTodayFragment();
                }
                transaction.replace(R.id.content,mToday);
                break;
            case 2:
                if(mRecently==null){
                    mRecently=new ContentRecentlyFragment();
                }
                transaction.replace(R.id.content,mRecently);
                break;
            default:
                break;
        }
        transaction.commit();


    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    /*
    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.tab_now:
                if(mNow==null){
                    mNow=new ContentNowFragment();
                }
                transaction.replace(R.id.content,mNow);
                break;
            case R.id.tab_today:
                if(mToday==null){
                    mToday=new ContentTodayFragment();
                }
                transaction.replace(R.id.content,mToday);
                break;
            case R.id.tab_recently:
                if(mRecently==null){
                    mRecently=new ContentRecentlyFragment();
                }
                transaction.replace(R.id.content,mRecently);
                break;
        }
        transaction.commit();
    }
    */

}
