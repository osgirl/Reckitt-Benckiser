package com.ad.reckittbenckiser.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ad.reckittbenckiser.fragments.zonelevelopportunity.AsmListFragment;
import com.ad.reckittbenckiser.fragments.zonelevelopportunity.ZonePerformanceFragment;

/**
 * Created by laxmi.khatri on 8/17/2016.
 */
public class AsmFragmentAdapter extends FragmentPagerAdapter {

    public AsmFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
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

    @Override
    public int getCount() {
        return 2;
    }
}
