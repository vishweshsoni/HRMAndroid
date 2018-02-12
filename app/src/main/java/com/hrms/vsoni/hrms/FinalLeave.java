package com.hrms.vsoni.hrms;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class FinalLeave extends AppCompatActivity {
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leave_final);
        ArrayList<Fragment> listOfFragments = new ArrayList<>();
        listOfFragments.add(LeaveApplication.getInstance());
        listOfFragments.add(ApplyLeaveFragment.getInstance());

        ArrayList<String> listOfTitles = new ArrayList<>();
        listOfTitles.add(getResources().getString(R.string.res_Leavestatus));
        listOfTitles.add(getResources().getString(R.string.res_ApplyLeave));
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), listOfFragments, listOfTitles);
        TabLayout tabLayoutMain = (TabLayout) findViewById(R.id.tabLayoutLeave);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPagerLeave);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayoutMain.setupWithViewPager(viewPager);

    }
}
