package com.ad.reckittbenckiser.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.ad.reckittbenckiser.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Shiva.Bansal on 8/20/2016.
 */

public class OpportunityZone extends AppCompatActivity {

    @Bind(R.id.east)
    FrameLayout eastLayout;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opporyunity_zone_design);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Opportunity Assessment Tool");
    }

    @OnClick(R.id.east)
    public void goToEastZone() {
        /*Intent intent = new Intent(OpportunityZone.this, DashBoardActivity.class);
        startActivity(intent);*/
        Intent intent = new Intent(OpportunityZone.this, AsmLeaderBoardActivity.class);
        startActivity(intent);
    }

}
