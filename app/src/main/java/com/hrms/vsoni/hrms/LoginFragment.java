package com.hrms.vsoni.hrms;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by HSoni on 1/6/2018.
 */

public class LoginFragment extends Fragment implements BackgroundWorker.goBackToParentFragment{
    private View rootView;
    public static LeaveStatus newInstance() {
        return new LeaveStatus();
    }
    private TextInputLayout textInputLayoutUsername;
    private TextInputLayout textInputLayoutPassword;
        public static LoginFragment getInstance (){
        return new LoginFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         rootView = inflater.inflate(R.layout.login, container, false);
        textInputLayoutUsername =(TextInputLayout) rootView.findViewById(R.id.txtLoginUserName);
        textInputLayoutPassword = (TextInputLayout) rootView.findViewById(R.id.txtLoginPassword);

        Button btnLogin = rootView.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= textInputLayoutUsername.getEditText().getText().toString();
                String password= textInputLayoutPassword.getEditText().getText().toString();


                HashMap<String,String> params=new HashMap<>();
                params.put("username",username);
                params.put("password",password);
                Httpcall httpCall = new Httpcall();
                httpCall.setParams(params);

                BackgroundWorker backgroundWorker=new BackgroundWorker(LoginFragment.this);
                backgroundWorker.execute(httpCall);
            }
        });
        return rootView;
    }

    @Override
    public void setResponse(Employee employee) {
        String s = employee.getEmail();
        Log.d("Login Fragment", "------->>> Ai gayu..." +s);
        Intent i= new Intent(getActivity(),HomeMainActivity.class);
        startActivity(i);

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



Log.d("yus",getInstance().toString());
    }
}
