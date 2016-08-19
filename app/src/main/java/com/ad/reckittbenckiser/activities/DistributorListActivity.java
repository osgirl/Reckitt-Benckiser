package com.ad.reckittbenckiser.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.adapter.DistributorFragmentAdapter;
import com.ad.reckittbenckiser.adapter.TsiFragmentAdapter;
import com.ad.reckittbenckiser.utils.AppConfig;
import com.ad.reckittbenckiser.utils.Tracer;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by laxmi.khatri on 8/19/2016.
 */
public class DistributorListActivity extends AppCompatActivity {

    @Bind(R.id.activity_dist_list_view_pager)
    ViewPager viewPager;

    private String TAG = AppConfig.BaseTag + "." + DistributorListActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsi_list);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        Tracer.info(TAG, "DistributorListActivity().init()");
        DistributorFragmentAdapter distributorFragmentAdapter = new DistributorFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(distributorFragmentAdapter);
    }
}
