package com.ad.reckittbenckiser.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.components.RadiationView;
import com.ad.reckittbenckiser.utils.PreferenceKeys;
import com.ad.reckittbenckiser.utils.SharedPreferenceManager;
import com.ad.reckittbenckiser.utils.Util;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Shiva.Bansal on 8/18/2016.
 */
public class SplashActivity extends Activity implements View.OnClickListener {

    private RadiationView radiationView;

    @Bind(R.id.frame)
    FrameLayout frame;

    @Bind(R.id.layoutKiaOra)
    LinearLayout layoutKiaOra;

    private SharedPreferenceManager mSharedPreferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_design);
        ButterKnife.bind(this);
        mSharedPreferenceManager = new SharedPreferenceManager(this);


        layoutKiaOra.setOnClickListener(this);
    }

    private void startRadarAnimation() {
        if (radiationView == null) {
            radiationView = new RadiationView(SplashActivity.this);
            radiationView.setBackgroundColor(Color.TRANSPARENT);
        }
        FrameLayout.LayoutParams radarParams = new FrameLayout.LayoutParams(
                Util.getDeviceWidth(this), Util.getDeviceWidth(this)- Util.getDeviceWidth(this)/5);

        radarParams.gravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
        radarParams.setMargins(0, 0, 0, 110);
        frame.removeView(radiationView);
        frame.addView(radiationView, radarParams);
        radiationView.startRadarAnimation();
    }

    private void stopRadarAnimation() {

        if (radiationView == null)
            return;
        radiationView.clearAnimation();
        radiationView.setAnimation(null);
        frame.removeView(radiationView);
        radiationView = null;

    }

    @Override
    public void onClick(View v) {
        startRadarAnimation();
        layoutKiaOra.setOnClickListener(null);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //stopRadarAnimation();
                        layoutKiaOra.setOnClickListener(SplashActivity.this);

                        if (mSharedPreferenceManager.getBooleanData(PreferenceKeys.IS_UER_USER_LOGIN)) {
                            Intent intent = new Intent(SplashActivity.this, OpportunityZone.class);
                            startActivity(intent);
                        } else {
                            Intent registerIntent = new Intent(SplashActivity.this, LoginActivity.class);
                            startActivity(registerIntent);

                        }
                        stopRadarAnimation();
                    }
                });
            }

        }, 1000);
    }



}
