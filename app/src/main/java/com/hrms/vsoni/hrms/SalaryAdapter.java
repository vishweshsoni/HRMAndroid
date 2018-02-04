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

public class SalaryAdapter extends RecyclerView.Adapter<SalaryAdapter.MyViewHolder> {
    private List<SalaryBin> salryList;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView month,rupees,year;

        public MyViewHolder(View itemView) {
            super(itemView);
            month=(TextView)itemView.findViewById(R.id.Month);
            rupees=(TextView)itemView.findViewById(R.id.Rupees);
            year=(TextView)itemView.findViewById(R.id.Year);

        }
    }

    public SalaryAdapter(List<SalaryBin> salryList){
         this.salryList=salryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_salary,parent,false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SalaryBin salary=salryList.get(position);
        holder.month.setText(salary.getMonth());
        holder.rupees.setText(salary.getRupees());
        holder.year.setText(salary.getYear());

    }

    @Override
    public int getItemCount() {
        return salryList.size();
    }
}
