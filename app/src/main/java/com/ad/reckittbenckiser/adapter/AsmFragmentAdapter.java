package com.ad.reckittbenckiser.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ad.reckittbenckiser.fragments.zonelevelopportunity.AsmListFragment;
import com.ad.reckittbenckiser.fragments.zonelevelopportunity.ZonePerformanceFragment;

/**
 * Created by bansal.shiva on 8/19/2016.
 */
public class AsmFragmentAdapter extends FragmentPagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created

    public AsmFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public AsmFragmentAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ZonePerformanceFragment();
            case 1:
                return new AsmListFragment();
        }
        return null;
    }

    // This method return the titles for the Tabs in the Tab Strip
    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}
