package com.ad.reckittbenckiser.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ad.reckittbenckiser.fragments.asmlevelopportunity.AsmPerformanceFragment;
import com.ad.reckittbenckiser.fragments.asmlevelopportunity.TsiListFragment;

/**
 * Created by laxmi.khatri on 8/19/2016.
 */
public class DistributorFragmentAdapter extends FragmentPagerAdapter {

    public DistributorFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AsmPerformanceFragment();
            case 1:
                return new TsiListFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}

