package com.hrms.vsoni.hrms;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        ArrayList<Fragment> listOfFragments = new ArrayList<>();
        listOfFragments.add(LoginFragment.getInstance());
        listOfFragments.add(SignupFragment.getInstance());

        ArrayList<String> listOfTitles = new ArrayList<>();
        listOfTitles.add(getResources().getString(R.string.res_login));
        listOfTitles.add(getResources().getString(R.string.res_signup));
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), listOfFragments, listOfTitles);
        TabLayout tabLayoutMain = (TabLayout) findViewById(R.id.tabLayoutMain);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPagerMain);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayoutMain.setupWithViewPager(viewPager);

    }
}
