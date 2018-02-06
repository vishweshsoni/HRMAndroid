package com.hrms.vsoni.hrms;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by VSoni on 1/7/2018.
 */

public class LeaveStatus extends Fragment implements BackgroundLeaveStatus.goBackToParentFragment {

    TextView sick,casual,privillages;
    Button b1;

    public static LeaveStatus newInstance() {
        return new LeaveStatus();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_leave_status, container, false);
        sick = rootView.findViewById(R.id.remaining_sick);
        casual = rootView.findViewById(R.id.remaining_casual);
        privillages = rootView.findViewById(R.id.remaining_privillages);
        b1 = rootView.findViewById(R.id.apply_leave_btn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(),Apply_leave.class);
                startActivity(i);
            }
        });

        return rootView;
    }

    @Override
    public void setResponse(Employee e) {
   Log.d("Leave status", "------->>> Ai gayu..." + e.toString());
        sick.setText(e.getRemaining_sick());
        casual.setText(e.getRemaining_casual());
        privillages.setText(e.getGetRemaining_privillages());


    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        HashMap<String,String> params=new HashMap<>();
        params.put("emp_id","1");
//            params.put("policy_id","STD009");
        Httpcall httpCall = new Httpcall();
            httpCall.setParams(params);
        BackgroundWorker bg_ls=new BackgroundWorker(this);
        bg_ls.execute(httpCall);



    }

}
