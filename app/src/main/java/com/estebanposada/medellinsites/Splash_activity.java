package com.estebanposada.medellinsites;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by usuario on 27/11/2015.
 */
public class Splash_activity extends Activity{

    private static final long SP_delay = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent maintent = new Intent().setClass(Splash_activity.this, MainActivity.class);
                startActivity(maintent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SP_delay);
    }
}
