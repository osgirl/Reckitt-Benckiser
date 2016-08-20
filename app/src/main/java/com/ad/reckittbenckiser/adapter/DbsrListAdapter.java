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
import com.ad.reckittbenckiser.activities.StoreActivity;
import com.ad.reckittbenckiser.views.CustomTextView;
import com.ad.reckittbenckiser.vo.DbsrInfo;
import com.ad.reckittbenckiser.vo.DistributorInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Laxmi.Khatri on 8/20/2016.
 */
public class DbsrListAdapter extends RecyclerView.Adapter<DbsrListAdapter.ViewHolder> {

    private List<DbsrInfo> mDbsrList;
    private Context mContext;

    public DbsrListAdapter(Context context, List<DbsrInfo> dbsrList) {
        mDbsrList = dbsrList;
        mContext = context;
    }

    @Override
    public DbsrListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dbsr_list_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final DbsrInfo dbsrInfo = mDbsrList.get(position);

        holder.tvDistName.setText(dbsrInfo.getDbsrName());
        holder.tvGrowth.setText(dbsrInfo.getGrowth());
        holder.tvOpp.setText(dbsrInfo.getOpportunity());
        if (position % 2 == 0) {
            holder.view.setBackgroundColor(mContext.getResources().getColor(R.color.purple));
        } else {
            holder.view.setBackgroundColor(mContext.getResources().getColor(R.color.pink_shade));
        }
        holder.llContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Intent intent = new Intent(mContext, StoreActivity.class);
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDbsrList.size();
    }

    /*
    This class holds all the view objects for list
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.ll_container)
        LinearLayout llContainer;

        @Bind(R.id.view)
        View view;

        @Bind(R.id.tv_dbsr_name)
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
