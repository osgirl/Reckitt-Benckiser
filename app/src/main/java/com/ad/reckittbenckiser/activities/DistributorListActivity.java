package com.ad.reckittbenckiser.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.adapter.DistributorFragmentAdapter;
import com.ad.reckittbenckiser.adapter.TsiFragmentAdapter;
import com.ad.reckittbenckiser.components.SlidingTabLayout;
import com.ad.reckittbenckiser.fragments.asmlevelopportunity.AsmPerformanceFragment;
import com.ad.reckittbenckiser.fragments.asmlevelopportunity.TsiListFragment;
import com.ad.reckittbenckiser.fragments.tsilevelopportunity.DistributorListFragment;
import com.ad.reckittbenckiser.fragments.tsilevelopportunity.TsiPerformanceFragment;
import com.ad.reckittbenckiser.utils.AppConfig;
import com.ad.reckittbenckiser.utils.Tracer;
import com.ad.reckittbenckiser.views.CustomTextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by laxmi.khatri on 8/19/2016.
 */
public class DistributorListActivity extends AppCompatActivity {

    @Bind(R.id.activity_dist_list_view_pager)
    ViewPager viewPager;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.tabs)
    TabLayout tabLayout;

    @Bind(R.id.tv_toolbar_title)
    CustomTextView tvTitle;

    private String TAG = AppConfig.BaseTag + "." + DistributorListActivity.class.getSimpleName();

    String Titles[] = {"Overall Performance", "Distributor List"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dist_list);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        Tracer.info(TAG, "DistributorListActivity().init()");
        // Creating The Toolbar and setting it as the Toolbar for the activity
        setSupportActionBar(toolbar);
        tvTitle.setText("RAIPUR TSI OPPORTUNITY");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setupViewPager();

        // Setting the ViewPager For the SlidingTabsLayout
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager() {
        DistributorFragmentAdapter distributorFragmentAdapter = new DistributorFragmentAdapter(getSupportFragmentManager());
        distributorFragmentAdapter.addFragment(new TsiPerformanceFragment(), Titles[0]);
        distributorFragmentAdapter.addFragment(new DistributorListFragment(), Titles[1]);
        viewPager.setAdapter(distributorFragmentAdapter);
        viewPager.setAdapter(distributorFragmentAdapter);
    }

    @OnClick(R.id.backBtn)
    public void back(){
        finish();
    }
}
