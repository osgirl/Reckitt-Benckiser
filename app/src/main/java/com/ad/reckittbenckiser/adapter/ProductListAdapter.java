package com.ad.reckittbenckiser.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ProductInfo productInfo = mProductList.get(position);

        holder.tvProductName.setText(productInfo.getProductName());
        holder.tvGrowth.setText("   "+productInfo.getGrowth());
        holder.tvOpp.setText(mContext.getString(R.string.rs) + productInfo.getOpportunity());
        if (position == 0 || position == 1 || position == 2 || position == 3 || position == 4 || position == 8) {
            holder.tvGrowth.setTextColor(mContext.getResources().getColor(R.color.red_color));
        } else {
            holder.tvGrowth.setTextColor(mContext.getResources().getColor(R.color.green_color));
        }
        if (position == 0) {
            holder.ivProduct.setImageResource(R.drawable.dettol_soap);
        } else if (position == 1) {
            holder.ivProduct.setImageResource(R.drawable.dettol_handwash);
        } else if (position == 2) {
            holder.ivProduct.setImageResource(R.drawable.harpic);
        } else if (position == 3) {
            holder.ivProduct.setImageResource(R.drawable.lizol);
        } else if (position == 4) {
            holder.ivProduct.setImageResource(R.drawable.mortein);
        } else if (position == 5) {
            holder.ivProduct.setImageResource(R.drawable.veet);
        } else if (position == 6) {
            holder.ivProduct.setImageResource(R.drawable.health_care);
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

        @Bind(R.id.iv_product)
        ImageView ivProduct;

        @Bind(R.id.ll_container)
        LinearLayout llContainer;

        @Bind(R.id.tv_product_name)
        CustomTextView tvProductName;

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
