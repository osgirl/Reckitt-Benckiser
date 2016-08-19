package com.ad.reckittbenckiser.fragments.asmlevelopportunity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ad.reckittbenckiser.activities.TsiListActivity;
import com.ad.reckittbenckiser.utils.AppConfig;
import com.ad.reckittbenckiser.utils.Tracer;

/**
 * Created by laxmi.khatri on 8/17/2016.
 */
public class AsmPerformanceFragment extends Fragment {

    private String TAG = AppConfig.BaseTag + "." + AsmPerformanceFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Tracer.info(TAG, "TsiPerformanceFragment().onCreateView()");
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
