package com.ad.reckittbenckiser.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.adapter.DbsrListAdapter;
import com.ad.reckittbenckiser.adapter.DistributorListAdapter;
import com.ad.reckittbenckiser.fragments.tsilevelopportunity.DistributorListFragment;
import com.ad.reckittbenckiser.utils.AppConfig;
import com.ad.reckittbenckiser.utils.Constants;
import com.ad.reckittbenckiser.vo.DbsrInfo;
import com.ad.reckittbenckiser.vo.DistributorInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Laxmi.Khatri on 8/20/2016.
 */
public class DbsrActivity extends AppCompatActivity {

    @Bind(R.id.activity_dbsr_list_rv)
    RecyclerView dbsrRecyclerView;

    @Bind(R.id.tv_toolbar_title)
    TextView tv_toolbar_title;

    DbsrListAdapter dbsrListAdapter;

    List<DbsrInfo> dbsrInfoList;


    private String TAG = AppConfig.BaseTag + "." + DbsrActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbsr);
        dbsrInfoList = Constants.getDbsrList();
        ButterKnife.bind(this);
        initViewAndAdapter();
    }

    private void initViewAndAdapter() {
        tv_toolbar_title.setText("Raipur TSI");
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        dbsrRecyclerView.setLayoutManager(llm);
        dbsrListAdapter = new DbsrListAdapter(this, dbsrInfoList);
        dbsrRecyclerView.setAdapter(dbsrListAdapter);
    }
}
