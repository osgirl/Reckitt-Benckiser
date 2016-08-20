package com.ad.reckittbenckiser.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.adapter.StoreListAdapter;
import com.ad.reckittbenckiser.utils.AppConfig;
import com.ad.reckittbenckiser.utils.Constants;
import com.ad.reckittbenckiser.vo.StoreInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Laxmi.Khatri on 8/20/2016.
 */
public class StoreActivity extends AppCompatActivity {

    @Bind(R.id.activity_store_list_rv)
    RecyclerView storeRecyclerView;

    StoreListAdapter storeListAdapter;

    List<StoreInfo> storeInfoList;

    private String TAG = AppConfig.BaseTag + "." + DbsrActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        storeInfoList = Constants.getStoreList();
        ButterKnife.bind(this);
        initViewAndAdapter();
    }

    private void initViewAndAdapter() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        storeRecyclerView.setLayoutManager(llm);
        storeListAdapter = new StoreListAdapter(this, storeInfoList);
        storeRecyclerView.setAdapter(storeListAdapter);
    }
}
