package com.hrms.vsoni.hrms;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by vishwesh on 4/2/18.
 */

public class ApplyLeaveFragment extends Fragment implements AdapterView.OnItemSelectedListener,BackgrounndApplyLeave.goBackToParentFragment{
     View view;
     //declaration part
    boolean fired=false;
    boolean pos=false;
    TextView fromDateTextView,toDateTextView;
    String TypeLeave=" ";
    Button applyLeave;
    Spinner spinner;
    String req_to_Date,req_from_Date;









    public static ApplyLeaveFragment getInstance(){
        return new ApplyLeaveFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.apply_leave, container, false);
         spinner = (Spinner)rootView.findViewById(R.id.applySpinner);
     ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.typeOfLeaveArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(this);
        spinner.setAdapter(adapter);
        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fromDateTextView= (TextView)view.findViewById(R.id.applyFromDate);
            fromDateTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDatePicker();
                }
            });
        toDateTextView= (TextView)view.findViewById(R.id.applyToDate);
        toDateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
                fired=true;

            }
        });
        applyLeave=(Button)view.findViewById(R.id.ApplyLeave);
        applyLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnApply();

            }
        });



    }

        private void showDatePicker(){
            DatePickerFragment date=new DatePickerFragment();
            Calendar calendar=Calendar.getInstance();
            Bundle args=new Bundle();
            args.putInt("year",calendar.get(Calendar.YEAR));
            args.putInt("month",calendar.get(Calendar.MONTH));
            args.putInt("day",calendar.get(Calendar.DAY_OF_MONTH));
            date.setArguments(args);

            //callback to capture selected date because callback is necessary
            date.setCallBack(ondate);

            date.show(getFragmentManager(),"Date picker");
        }
        DatePickerDialog.OnDateSetListener ondate=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar c=Calendar.getInstance();
                 if(fired==true){

                        toDateTextView.setText(String.valueOf(dayOfMonth)+"/"+String.valueOf(month+1)+"/"
                        +String.valueOf(year));
                        
                     populatetoDate(year, month + 1, dayOfMonth);
                                      }
                        else{
                             fromDateTextView.setText(String.valueOf(dayOfMonth)+"/"+String.valueOf(month+1)+"/"
                             +String.valueOf(year));
                     populatefromDate(year, month + 1, dayOfMonth);

                         }

                    }

                  };

    public void populatefromDate(int year, int month, int day) {
        String formattedDay = (String.valueOf(day));
        String formattedMonth = (String.valueOf(month));
        String formattedYear=(String.valueOf(year));
        if (day < 10) {
            formattedDay = "0" + day;
        }

        if (month < 10) {
            formattedMonth = "0" + month;
        }
        req_from_Date=formattedYear+"-"+formattedMonth+"-"+formattedDay;
        Log.d("req_from_day",req_from_Date);






    }



    public void populatetoDate(int year, int month, int day) {
        String formattedDay = (String.valueOf(day));
        String formattedMonth = (String.valueOf(month));
        String formattedYear=(String.valueOf(year));
        if (day < 10) {
            formattedDay = "0" + day;
        }

        if (month < 10) {
            formattedMonth = "0" + month;
        }
        req_to_Date=formattedYear+"-"+formattedMonth+"-"+formattedDay;
        Log.d("req_to_date",req_to_Date);


    }






    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
           TypeLeave=(String)parent.getItemAtPosition(position);
           if(position==0){
               pos=true;
           }

            Log.d("Selected 1->",(String)parent.getItemAtPosition(position));

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(getActivity(), "NothingSelected", Toast.LENGTH_SHORT).show();
    }
    public void OnApply(){

        Log.d("in",TypeLeave);

        if(pos==true){
            spinner.requestFocus();
            spinner.setSelected(true);
            //Toast.makeText(getActivity(),"plese select leave type",Toast.LENGTH_LONG).show();
            pos=false;
        }
        HashMap<String,String> params=new HashMap<>();
        params.put("typeOfLeave",TypeLeave);
        params.put("req_from_date",req_from_Date);
        params.put("req_to_date",req_to_Date);
        params.put("emp_id","1");
        Httpcall httpCall = new Httpcall();
        httpCall.setParams(params);


        BackgrounndApplyLeave backgrounndApplyLeave=new BackgrounndApplyLeave(ApplyLeaveFragment.this);
        backgrounndApplyLeave.execute(httpCall);



    }

    @Override
    public void setResponse(String s) {
        new AlertDialog.Builder(getActivity(),android.R.style.Theme_DeviceDefault_Light_Dialog)
                .setTitle("Applied")
                .setMessage(s)
                .setCancelable(true)
                .setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {
                                // Write your code here to execute after dialog

                            }
                        })
                .show();

    }

    @Override
    public void showError(String message) {
        new AlertDialog.Builder(getActivity(),android.R.style.Theme_DeviceDefault_Light_Dialog)
                .setTitle("Error")
                .setMessage(message)
                .setCancelable(true)
                .setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {
                                // Write your code here to execute after dialog

                            }
                        })
                .show();
    }
}
