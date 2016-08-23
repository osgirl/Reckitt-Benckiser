package com.ad.reckittbenckiser.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.activities.DistributorListActivity;
import com.ad.reckittbenckiser.views.CustomTextView;
import com.ad.reckittbenckiser.vo.TSIInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by laxmi.khatri on 8/17/2016.
 */
public class TsiListAdapter extends RecyclerView.Adapter<TsiListAdapter.ViewHolder> {

    private List<TSIInfo> mTsiList;
    private Context mContext;

    public TsiListAdapter(Context context, List<TSIInfo> tsiList) {
        mTsiList = tsiList;
        mContext = context;
    }

    @Override
    public TsiListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tsi_list_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final TSIInfo tsiInfo = mTsiList.get(position);

        holder.tvTsiName.setText(tsiInfo.getTsiName());
        holder.tvChannel.setText(tsiInfo.getChannel());
        holder.tvGrowth.setText(tsiInfo.getGrowth());
        holder.tvAs.setText(tsiInfo.getAveSales());
        holder.tvOpp.setText(tsiInfo.getOpportunity());
        if (position % 2 == 0) {
            holder.view.setBackgroundColor(mContext.getResources().getColor(R.color.pink_shade));
        } else {
            holder.view.setBackgroundColor(mContext.getResources().getColor(R.color.purple));
        }
        if (position == 2) {
            holder.tvGrowth.setTextColor(mContext.getResources().getColor(R.color.red_color));
        } else {
            holder.tvGrowth.setTextColor(mContext.getResources().getColor(R.color.green_color));
        }
        holder.llContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Intent intent = new Intent(mContext, DistributorListActivity.class);
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTsiList.size();
    }

    /*
    This class holds all the view objects for list
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.ll_container)
        LinearLayout llContainer;

        @Bind(R.id.view)
        View view;

        @Bind(R.id.tv_tsi_name)
        CustomTextView tvTsiName;

        @Bind(R.id.tv_channel)
        CustomTextView tvChannel;

        @Bind(R.id.tv_growth)
        CustomTextView tvGrowth;

        @Bind(R.id.tv_as)
        CustomTextView tvAs;

        @Bind(R.id.tv_opp)
        CustomTextView tvOpp;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

    }
}
