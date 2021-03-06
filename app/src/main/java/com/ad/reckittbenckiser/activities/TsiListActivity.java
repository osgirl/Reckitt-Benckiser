package com.ad.reckittbenckiser.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.adapter.TsiFragmentAdapter;
import com.ad.reckittbenckiser.fragments.asmlevelopportunity.AsmPerformanceFragment;
import com.ad.reckittbenckiser.fragments.asmlevelopportunity.TsiListFragment;
import com.ad.reckittbenckiser.utils.AppConfig;
import com.ad.reckittbenckiser.utils.Tracer;
import com.ad.reckittbenckiser.views.CustomTextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by laxmi.khatri on 8/19/2016.
 */
public class TsiListActivity extends AppCompatActivity {

    @Bind(R.id.activity_tsi_list_view_pager)
    ViewPager viewPager;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    /*@Bind(R.id.tabs)
    TabLayout tabLayout;*/

    @Bind(R.id.tv_toolbar_title)
    CustomTextView tvTitle;

    private String TAG = AppConfig.BaseTag + "." + TsiListActivity.class.getSimpleName();

    //String Titles[] = {"Overall Performance", "TSI list"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsi_list);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        Tracer.info(TAG, "TsiListActivity().init()");
        // Creating The Toolbar and setting it as the Toolbar for the activity
        setSupportActionBar(toolbar);
        tvTitle.setText("Chhattisgarh   Opportunity");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setupViewPager();

        // Setting the ViewPager For the SlidingTabsLayout
//        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager() {
        TsiFragmentAdapter tsiFragmentAdapter = new TsiFragmentAdapter(getSupportFragmentManager());
        tsiFragmentAdapter.addFragment(new AsmPerformanceFragment(), "");
//        tsiFragmentAdapter.addFragment(new TsiListFragment(), Titles[1]);
        viewPager.setAdapter(tsiFragmentAdapter);
    }

    @OnClick(R.id.backBtn)
    public void back() {
        finish();
    }
}
