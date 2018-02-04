package com.hrms.vsoni.hrms;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by vishwesh on 3/1/18.
 */

public class DatePickerFragment extends DialogFragment {
//    @NonNull
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        Calendar c=Calendar.getInstance();
//        int year =c.get(Calendar.YEAR);
//        int month=c.get(Calendar.MONTH);
//        int day=c.get(Calendar.DAY_OF_MONTH);
//        return new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener)getActivity(),year,month,day);
//    }

    DatePickerDialog.OnDateSetListener onDateSet;
    private int year,month,day;
    public DatePickerFragment(){}
    public  void  setCallBack(DatePickerDialog.OnDateSetListener ondate){
            onDateSet=ondate;

    }
    @SuppressLint("NewApi")
    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        year = args.getInt("year");
        month = args.getInt("month");
        day = args.getInt("day");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new DatePickerDialog(getActivity(), android.R.style.Theme_DeviceDefault_Light_Dialog,onDateSet, year, month, day);
    }
}
