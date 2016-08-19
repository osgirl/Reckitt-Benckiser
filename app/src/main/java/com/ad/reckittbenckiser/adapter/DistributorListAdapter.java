package com.ad.reckittbenckiser.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.views.CustomTextView;
import com.ad.reckittbenckiser.vo.TSIInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by laxmi.khatri on 8/19/2016.
 */
public class DistributorListAdapter extends RecyclerView.Adapter<DistributorListAdapter.ViewHolder> {

    private List<TSIInfo> mTsiList;
    private Context mContext;

    public DistributorListAdapter(Context context, List<TSIInfo> tsiList) {
        mTsiList = tsiList;
        mContext = context;
    }

    @Override
    public DistributorListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tsi_list_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final TSIInfo tsiInfo = mTsiList.get(position);

        holder.tvTsiName.setText(tsiInfo.getTsiName());
        holder.tvChannel.setText(tsiInfo.getChannel());
        holder.tvGrowth.setText(tsiInfo.getGrowth());
        holder.tvAs.setText(tsiInfo.getAveSales());
        holder.tvOpp.setText(tsiInfo.getOpportunity());
        if (position % 2 == 0) {
            holder.view.setBackgroundColor(mContext.getResources().getColor(R.color.purple));
        } else {
            holder.view.setBackgroundColor(mContext.getResources().getColor(R.color.pink));
        }
    }

    @Override
    public int getItemCount() {
        return mTsiList.size();
    }

    /*
    This class holds all the view objects for list
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

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
