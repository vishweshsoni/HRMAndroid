package com.hrms.vsoni.hrms;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by VSoni on 1/7/2018.
 */

public class LeaveApplication extends Fragment{

    public static LeaveApplication newInstance() {
        return new LeaveApplication();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_leave_list, container, false);
        ListView listView = rootView.findViewById(R.id.listLeaveAppList);
        ArrayList<String> tempList = new ArrayList<String>();
        tempList.add("Leave application 1");
        tempList.add("Leave application 2");
        tempList.add("Leave application 3");
        LeaveApplicationListAdapter adapter = new LeaveApplicationListAdapter(getActivity(), R.layout.leave_app_item, tempList);
        listView.setAdapter(adapter);
        return rootView;
    }


}
