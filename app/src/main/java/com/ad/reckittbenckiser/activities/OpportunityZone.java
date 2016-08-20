package com.ad.reckittbenckiser.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.ad.reckittbenckiser.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Shiva.Bansal on 8/20/2016.
 */

public class OpportunityZone extends Activity {

    @Bind(R.id.east)
    FrameLayout eastLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunity_zone);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.east)
    public void goToEastZone(){
        Intent intent = new Intent(OpportunityZone.this, DashBoardActivity.class);
        startActivity(intent);
    }

}
