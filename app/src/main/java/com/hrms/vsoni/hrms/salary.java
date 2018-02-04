package com.hrms.vsoni.hrms;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;



public class salary extends Fragment {
//    recyclerView=(RecyclerView) getView().findViewById(R.id.recycler_view);
//    salary_adapter=new SalaryAdapter(salarylist);
//    RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(salary_adapter);
//    prepareSalaryData();

    private List<SalaryBin> salarylist = new ArrayList<>();

    private RecyclerView recyclerView;

    private SalaryAdapter salary_adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view=inflater.inflate(R.layout.fragment_salary,container,false);

         recyclerView=(RecyclerView) view.findViewById(R.id.recycler_view);
        salary_adapter=new SalaryAdapter(salarylist);
    RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(salary_adapter);
    prepareSalaryData();

        return view;
    }
    private void prepareSalaryData(){
         SalaryBin salary=new SalaryBin("January","2015","30000");
         salarylist.add(salary);
         salary =new SalaryBin("January","2015","30000");
        salarylist.add(salary);
        salary =new SalaryBin("January","2015","30000");
        salarylist.add(salary);
        salary =new SalaryBin("January","2015","30000");
        salarylist.add(salary);
        salary =new SalaryBin("January","2015","30000");
        salarylist.add(salary);
        salary =new SalaryBin("January","2015","30000");
        salarylist.add(salary);
        salary =new SalaryBin("January","2015","30000");
        salarylist.add(salary);
        salary =new SalaryBin("January","2015","30000");
        salarylist.add(salary);
        salary =new SalaryBin("January","2015","30000");
        salarylist.add(salary);

        salary_adapter.notifyDataSetChanged();
    }

}
