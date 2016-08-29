package com.ad.reckittbenckiser.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.adapter.ProductListAdapter;
import com.ad.reckittbenckiser.adapter.StoreListAdapter;
import com.ad.reckittbenckiser.utils.AppConfig;
import com.ad.reckittbenckiser.utils.Constants;
import com.ad.reckittbenckiser.vo.ProductInfo;
import com.ad.reckittbenckiser.vo.StoreInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by laxmi.khatri on 8/22/2016.
 */
public class ProductActivity extends AppCompatActivity {

    @Bind(R.id.activity_product_list_rv)
    RecyclerView productRecyclerView;

    @Bind(R.id.tv_toolbar_title)
    TextView tv_toolbar_title;

    ProductListAdapter productListAdapter;

    List<ProductInfo> productInfoList;

    private String TAG = AppConfig.BaseTag + "." + ProductActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        productInfoList = Constants.getProductList();
        ButterKnife.bind(this);
        initViewAndAdapter();
    }

    private void initViewAndAdapter() {
        tv_toolbar_title.setText("Opportunity  by  Product");
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        productRecyclerView.setLayoutManager(llm);
        productListAdapter = new ProductListAdapter(this, productInfoList);
        productRecyclerView.setAdapter(productListAdapter);
    }

    @OnClick(R.id.backBtn)
    public void back(){
        finish();
    }
}
