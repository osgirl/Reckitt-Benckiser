package com.ad.reckittbenckiser.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.activities.DbsrActivity;
import com.ad.reckittbenckiser.activities.ProductActivity;
import com.ad.reckittbenckiser.activities.StoreActivity;
import com.ad.reckittbenckiser.views.CustomTextView;
import com.ad.reckittbenckiser.vo.DbsrInfo;
import com.ad.reckittbenckiser.vo.StoreInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Laxmi.Khatri on 8/20/2016.
 */
public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.ViewHolder> {

    private List<StoreInfo> mStoreList;
    private Context mContext;

    public StoreListAdapter(Context context, List<StoreInfo> storeList) {
        mStoreList = storeList;
        mContext = context;
    }

    @Override
    public StoreListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_list_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final StoreInfo storeInfo = mStoreList.get(position);

        holder.tvStoreName.setText(storeInfo.getStoreName());
        holder.tvGrowth.setText("  "+storeInfo.getGrowth());
        holder.tvOpp.setText(mContext.getString(R.string.rs) + storeInfo.getOpportunity());
        if (position % 2 == 0) {
            holder.view.setBackgroundColor(mContext.getResources().getColor(R.color.purple));
        } else {
            holder.view.setBackgroundColor(mContext.getResources().getColor(R.color.pink));
        }

        if (position == 0 || position == 3) {
            holder.tvGrowth.setTextColor(mContext.getResources().getColor(R.color.red_color));
        } else {
            holder.tvGrowth.setTextColor(mContext.getResources().getColor(R.color.green_color));
        }

        holder.btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Intent intent = new Intent(mContext, ProductActivity.class);
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mStoreList.size();
    }

    /*
    This class holds all the view objects for list
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.ll_container)
        LinearLayout llContainer;

        @Bind(R.id.view)
        View view;

        @Bind(R.id.tv_store_name)
        CustomTextView tvStoreName;

        @Bind(R.id.tv_growth)
        CustomTextView tvGrowth;

        @Bind(R.id.tv_opp)
        CustomTextView tvOpp;

        @Bind(R.id.btn_product)
        Button btnProduct;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

    }
}
