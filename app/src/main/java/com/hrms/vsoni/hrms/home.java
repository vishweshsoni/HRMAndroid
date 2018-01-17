package com.hrms.vsoni.hrms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home extends Fragment{

    public home() {
    }
    public static home newInstance() {
        home fragment = new home();
        return fragment;
    }
    public void leave_click(View view){

        Fragment fr=new Fragment();
        FragmentManager manager=getActivity().getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.leave_status, fr);
        transaction.addToBackStack(null);
        transaction.commit();


    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home, container, false);
        Toolbar toolbar = rootView.findViewById(R.id.toolbar);
        toolbar.setTitle(getActivity().getResources().getString(R.string.res_hrm));
        LinearLayout ll_leavestatsus=(LinearLayout)rootView.findViewById(R.id.ll_leavestatus);
        LinearLayout ll_profile=(LinearLayout)rootView.findViewById(R.id.ll_profile);
        LinearLayout ll_salary=(LinearLayout)rootView.findViewById(R.id.ll_salary);
        LinearLayout ll_about=(LinearLayout)rootView.findViewById(R.id.ll_about);
        LinearLayout ll_logout=(LinearLayout)rootView.findViewById(R.id.ll_logout);
        ll_leavestatsus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LeaveStatus leaveStatus=LeaveStatus.newInstance();
                replaceFragment(leaveStatus);

            }
        });

//        ll_profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fragment=new LeaveStatus();
//                replaceFragment(fragment);
//
//            }
//        });
        ll_salary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment=new salary();
                replaceFragment(fragment);

            }
        });
//        ll_about.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fragment=new About();
//                replaceFragment(fragment);
//
//            }
//        });


        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return rootView;
    }
    public void replaceFragment(Fragment someFragment) {


        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.myMain, someFragment,"Fragment").setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}
