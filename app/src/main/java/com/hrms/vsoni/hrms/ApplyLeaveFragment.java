package com.hrms.vsoni.hrms;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
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
import java.util.Calendar;

/**
 * Created by vishwesh on 4/2/18.
 */

public class ApplyLeaveFragment extends Fragment implements AdapterView.OnItemSelectedListener{
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
                     req_to_Date= DateFormat.getDateInstance().format(c.getTime());

                          }
                        else{
                             fromDateTextView.setText(String.valueOf(dayOfMonth)+"/"+String.valueOf(month+1)+"/"
                             +String.valueOf(year));
                     req_from_Date= DateFormat.getDateInstance().format(c.getTime());

                         }

                    }

                  };


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
            Toast.makeText(getActivity(),"plese select leave type",Toast.LENGTH_LONG).show();
            pos=false;
        }

    }
}
