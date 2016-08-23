package com.ad.reckittbenckiser.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.views.CustomTextView;
import com.ad.reckittbenckiser.vo.ProductInfo;
import com.ad.reckittbenckiser.vo.StoreInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Laxmi.Khatri on 8/20/2016.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private List<ProductInfo> mProductList;
    private Context mContext;

    public ProductListAdapter(Context context, List<ProductInfo> productList) {
        mProductList = productList;
        mContext = context;
    }

    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_list_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ProductInfo productInfo = mProductList.get(position);

        holder.tvStoreName.setText(productInfo.getProductName());
        holder.tvGrowth.setText(productInfo.getGrowth());
        holder.tvOpp.setText(productInfo.getOpportunity());
        if (position % 2 == 0) {
            holder.view.setBackgroundColor(mContext.getResources().getColor(R.color.purple));
        } else {
            holder.view.setBackgroundColor(mContext.getResources().getColor(R.color.pink));
        }
        if (position == 0 || position == 1 || position == 2 || position == 3 || position == 4 || position == 8) {
            holder.tvGrowth.setTextColor(mContext.getResources().getColor(R.color.red_color));
        } else {
            holder.tvGrowth.setTextColor(mContext.getResources().getColor(R.color.green_color));
        }

    }

    @Override
    public int getItemCount() {
        return mProductList.size();
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

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

    }
}
