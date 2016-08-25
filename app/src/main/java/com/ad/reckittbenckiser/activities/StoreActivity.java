package com.ad.reckittbenckiser.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.adapter.StoreListAdapter;
import com.ad.reckittbenckiser.utils.AppConfig;
import com.ad.reckittbenckiser.utils.Constants;
import com.ad.reckittbenckiser.vo.StoreInfo;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Laxmi.Khatri on 8/20/2016.
 */
public class StoreActivity extends AppCompatActivity {

    @Bind(R.id.activity_store_list_rv)
    RecyclerView storeRecyclerView;

    @Bind(R.id.tv_toolbar_title)
    TextView tv_toolbar_title;

    @Bind(R.id.tv_opp)
    TextView tvOpp;

    StoreListAdapter storeListAdapter;

    List<StoreInfo> storeInfoList;

    private String TAG = AppConfig.BaseTag + "." + StoreActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        storeInfoList = Constants.getStoreList();
        ButterKnife.bind(this);
        initViewAndAdapter();
    }

    private void initViewAndAdapter() {

        tv_toolbar_title.setText("OPPORTUNITY BY STORE");
        tvOpp.setText(getString(R.string.rs) + "49.19L");
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        storeRecyclerView.setLayoutManager(llm);
        storeListAdapter = new StoreListAdapter(this, storeInfoList);
        storeRecyclerView.setAdapter(storeListAdapter);
    }

    @OnClick(R.id.backBtn)
    public void back(){
        finish();
    }
}
