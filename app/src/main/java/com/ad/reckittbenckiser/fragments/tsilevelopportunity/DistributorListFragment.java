package com.ad.reckittbenckiser.fragments.tsilevelopportunity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.adapter.DistributorListAdapter;
import com.ad.reckittbenckiser.adapter.TsiListAdapter;
import com.ad.reckittbenckiser.utils.AppConfig;
import com.ad.reckittbenckiser.utils.Constants;
import com.ad.reckittbenckiser.utils.Tracer;
import com.ad.reckittbenckiser.vo.TSIInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by laxmi.khatri on 8/17/2016.
 */
public class DistributorListFragment extends Fragment {

    @Bind(R.id.fragment_distributor_list_rv)
    RecyclerView tsiRecyclerView;

    DistributorListAdapter distributorListAdapter;

    List<TSIInfo> tsiInfoList;

    private String TAG = AppConfig.BaseTag + "." + DistributorListFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tsiInfoList = Constants.getTsiList();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_distributor_list, null);
        ButterKnife.bind(this, view);
        Tracer.info(TAG, "DistributorListFragment().onCreateView()");
        initViewAndAdapter();
        return view;
    }

    private void initViewAndAdapter() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        tsiRecyclerView.setLayoutManager(llm);
        distributorListAdapter = new DistributorListAdapter(getActivity(), tsiInfoList);
        tsiRecyclerView.setAdapter(distributorListAdapter);
    }
}
