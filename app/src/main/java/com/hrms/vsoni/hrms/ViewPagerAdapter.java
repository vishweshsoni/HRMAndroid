package com.hrms.vsoni.hrms;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by HSoni on 1/6/2018.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    /**
     * List of fragments that needs to be added on page
     */
    private ArrayList<Fragment> mFragmentsList;
    /**
     * List of titles for each fragments
     */
    private ArrayList<String> mTitles;
    private int mNumOfFragments;


    public ViewPagerAdapter(android.support.v4.app.FragmentManager fm, ArrayList<Fragment> fragmentsList, ArrayList<String> titlesList) {
        super(fm);
        mFragmentsList = fragmentsList;
        mTitles = titlesList;
        mNumOfFragments = fragmentsList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles != null || mTitles.size() > 0) return mTitles.get(position);
        return super.getPageTitle(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return mNumOfFragments;
    }
}
