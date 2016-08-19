package com.ad.reckittbenckiser.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.adapter.TsiFragmentAdapter;
import com.ad.reckittbenckiser.utils.AppConfig;
import com.ad.reckittbenckiser.utils.Tracer;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by laxmi.khatri on 8/19/2016.
 */
public class TsiListActivity extends AppCompatActivity {

    @Bind(R.id.activity_tsi_list_view_pager)
    ViewPager viewPager;

    private String TAG = AppConfig.BaseTag + "." + TsiListActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsi_list);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        Tracer.info(TAG, "TsiListActivity().init()");
        TsiFragmentAdapter tsiFragmentAdapter = new TsiFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tsiFragmentAdapter);
    }
}
