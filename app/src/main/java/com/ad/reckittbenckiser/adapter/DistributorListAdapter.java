package com.ad.reckittbenckiser.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.activities.DbsrActivity;
import com.ad.reckittbenckiser.activities.DistributorListActivity;
import com.ad.reckittbenckiser.views.CustomTextView;
import com.ad.reckittbenckiser.vo.DistributorInfo;
import com.ad.reckittbenckiser.vo.TSIInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by laxmi.khatri on 8/19/2016.
 */
public class DistributorListAdapter extends RecyclerView.Adapter<DistributorListAdapter.ViewHolder> {

    private List<DistributorInfo> mDistList;
    private Context mContext;

    public DistributorListAdapter(Context context, List<DistributorInfo> distList) {
        mDistList = distList;
        mContext = context;
    }

    @Override
    public DistributorListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dist_list_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final DistributorInfo distributorInfo = mDistList.get(position);

        holder.tvDistName.setText(distributorInfo.getDistributorName());
        holder.tvGrowth.setText(distributorInfo.getGrowth());
        holder.tvOpp.setText(distributorInfo.getOpportunity());
        if (position % 2 == 0) {
            holder.view.setBackgroundColor(mContext.getResources().getColor(R.color.purple));
        } else {
            holder.view.setBackgroundColor(mContext.getResources().getColor(R.color.pink));
        }
        if (position == 0) {
            holder.tvGrowth.setTextColor(mContext.getResources().getColor(R.color.red_color));
        } else {
            holder.tvGrowth.setTextColor(mContext.getResources().getColor(R.color.green_color));
        }
        holder.llContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Intent intent = new Intent(mContext, DbsrActivity.class);
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDistList.size();
    }

    /*
    This class holds all the view objects for list
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.ll_container)
        LinearLayout llContainer;

        @Bind(R.id.view)
        View view;

        @Bind(R.id.tv_dist_name)
        CustomTextView tvDistName;

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
