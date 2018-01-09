package com.hrms.vsoni.hrms;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class HomeMainActivity extends AppCompatActivity /*implements home.OnFragmentInteractionListener,salary.OnSalaryFragmentInteractionListener*/ {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.homemain);
        Fragment fr=new Fragment();
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
                transaction.add(R.id.main,fr);
                transaction.commit();

    }



}
