package com.hrms.vsoni.hrms;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Leave extends Fragment  {
    ViewPagerAdapter viewPagerAdapter;

    public Leave() {
    }

    public static Leave newInstance() {
        return new Leave();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.main_screen, container, false);

        // Inflate the layout for this fragment
        ArrayList<Fragment> listOfFragments = new ArrayList<>();
        listOfFragments.add(LeaveStatus.newInstance());
        listOfFragments.add(LeaveApplication.newInstance());

        ArrayList<String> listOfTitles = new ArrayList<>();
        listOfTitles.add(getResources().getString(R.string.res_leave_status));
        listOfTitles.add(getResources().getString(R.string.res_leave_applications));
        viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), listOfFragments, listOfTitles);
        TabLayout tabLayoutMain =  rootView.findViewById(R.id.tabLayoutMain);
        ViewPager viewPager = rootView.findViewById(R.id.viewPagerMain);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayoutMain.setupWithViewPager(viewPager);
        return  rootView;

    }

}
