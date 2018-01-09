package com.hrms.vsoni.hrms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splash_anim);
        ImageView iv = (ImageView)findViewById(R.id.spashLogo);
        TextView tv = (TextView)findViewById(R.id.splashText);
        iv.setAnimation(animation);
        tv.setAnimation(animation);
        final Intent intent = new Intent(this, MainActivity.class);

        Thread timer = new Thread(){
            public void run (){
                try {
                    sleep(5000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                    finish();
                }
                finally {
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }
}
