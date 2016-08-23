package com.ad.reckittbenckiser.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.adapter.AsmFragmentAdapter;
import com.ad.reckittbenckiser.components.SlidingTabLayout;
import com.ad.reckittbenckiser.fragments.root.NavigationDrawerFragment;
import com.ad.reckittbenckiser.utils.SharedPreferenceManager;

/**
 * Created by Shiva.Bansal on 8/19/2016.
 */

public class DashBoardActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    NavigationDrawerFragment mNavigationDrawerFragment;
    DrawerLayout drawerLayout;
    SharedPreferenceManager preferenceManager;
    Toolbar toolbar;
    ViewPager pager;
    AsmFragmentAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Overall Performance", "ASM list"};
    int Numboftabs = 2;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity_design);
        preferenceManager = new SharedPreferenceManager(this);

        mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, drawerLayout);

        // Creating The Toolbar and setting it as the Toolbar for the activity
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        View logo = getLayoutInflater().inflate(R.layout.action_bar_view, null);
        toolbar.addView(logo);

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter = new AsmFragmentAdapter(getSupportFragmentManager(), Titles, Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width


        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.icons);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
            }
        }
    }
}