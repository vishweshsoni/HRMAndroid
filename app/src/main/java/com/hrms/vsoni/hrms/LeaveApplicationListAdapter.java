package com.hrms.vsoni.hrms;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vishwesh on 23/1/18.
 */

public class LeaveApplicationListAdapter extends RecyclerView.Adapter<LeaveApplicationListAdapter.MyViewHolder> {
    private List<LeaveAppBean> listLeaveApp;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView txtLeaveAppNumber,txtLeaveAppStartDate,txtLeaveAppEndDate,txtLeaveAppManager
                 ,txtLeaveApptype,txtLeaveAppNumberOfLeaves,txtLeaveAppStatus;


        public MyViewHolder(View itemView) {
            super(itemView);
            txtLeaveAppNumber=(TextView)itemView.findViewById(R.id.txtLeaveAppNumber);
            txtLeaveAppStartDate=(TextView)itemView.findViewById(R.id.txtLeaveAppStartDate);
            txtLeaveAppEndDate=(TextView)itemView.findViewById(R.id.txtLeaveAppEndDate);
            txtLeaveAppManager=(TextView)itemView.findViewById(R.id.txtLeaveAppManager);
            txtLeaveApptype=(TextView)itemView.findViewById(R.id.txtLeaveApptype);
            txtLeaveAppNumberOfLeaves=(TextView)itemView.findViewById(R.id.txtLeaveAppNumberOfLeaves);
            txtLeaveAppStatus=(TextView)itemView.findViewById(R.id.txtLeaveAppStatus);



        }
    }

    public LeaveApplicationListAdapter(List<LeaveAppBean> listLeaveApp){
        this.listLeaveApp = listLeaveApp;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.leave_application_item,parent,false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LeaveAppBean leaveAppBean= listLeaveApp.get(position);
        holder.txtLeaveAppNumber.setText(leaveAppBean.getLeaveAppNumber());
        holder.txtLeaveAppStartDate.setText(leaveAppBean.getStartDate());
        holder.txtLeaveAppEndDate.setText(leaveAppBean.getEndDate());
        holder.txtLeaveAppManager.setText(leaveAppBean.getMgrName());
        holder.txtLeaveApptype.setText(leaveAppBean.getTypeOfLeave());
        holder.txtLeaveAppNumberOfLeaves.setText(leaveAppBean.getLeaveAppNumber());
        holder.txtLeaveAppStatus.setText(leaveAppBean.getStatus());



    }

    @Override
    public int getItemCount() {
        return listLeaveApp.size();
    }
}
