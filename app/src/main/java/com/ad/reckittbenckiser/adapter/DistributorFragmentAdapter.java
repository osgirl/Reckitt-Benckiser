package com.ad.reckittbenckiser.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ad.reckittbenckiser.fragments.asmlevelopportunity.AsmPerformanceFragment;
import com.ad.reckittbenckiser.fragments.asmlevelopportunity.TsiListFragment;
import com.ad.reckittbenckiser.fragments.tsilevelopportunity.DistributorListFragment;
import com.ad.reckittbenckiser.fragments.tsilevelopportunity.TsiPerformanceFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laxmi.khatri on 8/19/2016.
 */
public class DistributorFragmentAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public DistributorFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    // This method return the titles for the Tabs in the Tab Strip
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}

