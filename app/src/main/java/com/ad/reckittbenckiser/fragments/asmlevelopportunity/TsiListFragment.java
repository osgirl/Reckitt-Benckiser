package com.ad.reckittbenckiser.fragments.asmlevelopportunity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.activities.DistributorListActivity;
import com.ad.reckittbenckiser.activities.TsiListActivity;
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
public class TsiListFragment extends Fragment {

    @Bind(R.id.fragment_tsi_list_rv)
    RecyclerView tsiRecyclerView;

    TsiListAdapter tsiListAdapter;

    List<TSIInfo> tsiInfoList;

    private String TAG = AppConfig.BaseTag + "." + TsiListFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tsiInfoList = Constants.getTsiList();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tsi_list, null);
        ButterKnife.bind(this, view);
        Tracer.info(TAG, "DistributorListFragment().onCreateView()");
        initViewAndAdapter();
        return view;
    }

    private void initViewAndAdapter() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        tsiRecyclerView.setLayoutManager(llm);
        tsiListAdapter = new TsiListAdapter(getActivity(), tsiInfoList);
        tsiRecyclerView.setAdapter(tsiListAdapter);

        /*final GestureDetector mGestureDetector = new GestureDetector(getActivity(),
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        return true;
                    }

                });

        tsiRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());


                if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
                    // call fragment on main container form here
                    Intent intent = new Intent(getActivity(), DistributorListActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }
        });*/
    }
}
