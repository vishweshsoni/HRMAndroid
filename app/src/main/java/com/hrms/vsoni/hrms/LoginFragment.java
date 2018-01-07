package com.hrms.vsoni.hrms;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by HSoni on 1/6/2018.
 */

public class LoginFragment extends Fragment {

    private TextInputLayout textInputLayoutUsername;
    private TextInputLayout textInputLayoutPassword;
    public static LoginFragment getInstance (){
        return new LoginFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login, container, false);
        textInputLayoutUsername = rootView.findViewById(R.id.txtLoginUserName);
        textInputLayoutPassword = rootView.findViewById(R.id.txtLoginPassword);

        Button btnLogin = rootView.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= textInputLayoutUsername.getEditText().toString();
                String password= textInputLayoutPassword.getEditText().toString();

                Intent i= new Intent(getActivity(),HomeMainActivity.class);
                startActivity(i);
                BackgroundWorker backgroundWorker=new BackgroundWorker();
                backgroundWorker.execute(username,password,null);
            }
        });
        return rootView;
    }
}
