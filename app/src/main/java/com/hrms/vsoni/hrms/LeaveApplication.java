package com.hrms.vsoni.hrms;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VSoni on 1/7/2018.
 */

public class LeaveApplication extends Fragment{
    public static  LeaveApplication getInstance(){
        return new LeaveApplication();
    }
    private List<LeaveAppBean> leaveAppList=new ArrayList<>();
    private RecyclerView rcyLeaveAppList;
    private LeaveApplicationListAdapter leaveApplicationListAdapter;
    public static LeaveApplication newInstance() {
        return new LeaveApplication();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leave_list, container, false);

        rcyLeaveAppList=(RecyclerView) view.findViewById(R.id.rcyLeaveAppList);
        rcyLeaveAppList.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));



        leaveApplicationListAdapter =new LeaveApplicationListAdapter(leaveAppList);
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        rcyLeaveAppList.setLayoutManager(mLayoutManager);

        rcyLeaveAppList.setItemAnimator(new DefaultItemAnimator());
        rcyLeaveAppList.setAdapter(leaveApplicationListAdapter);

        preapreLeaveAppData();


        return view;
    }
    private void preapreLeaveAppData(){
        for (int i = 0; i <10 ; i++) {
            LeaveAppBean leaveAppBean=new LeaveAppBean();
            leaveAppBean.setLeaveAppNumber("Leave Application"+i);
            leaveAppBean.setStartDate("To:Jan 15 2018");
            leaveAppBean.setEndDate("From:Jan 18 2018");
            leaveAppBean.setMgrName("By:Vishwesh Soni");
            leaveAppBean.setTypeOfLeave("Type:Sick Leave");
            leaveAppBean.setNoOfLeave("45");
            leaveAppBean.setStatus("Pending");
            leaveAppList.add(leaveAppBean);
            leaveApplicationListAdapter.notifyDataSetChanged();
            }
            //leaveApplicationListAdapter.notifyDataSetChanged();

    }


}
