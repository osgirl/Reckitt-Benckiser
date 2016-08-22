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
import com.ad.reckittbenckiser.activities.TsiListActivity;
import com.ad.reckittbenckiser.views.CustomTextView;
import com.ad.reckittbenckiser.vo.ASMInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Shiva.Bansal on 8/22/2016.
 */
public class ASMListAdapter extends  RecyclerView.Adapter<ASMListAdapter.ViewHolder> {

    private List<ASMInfo> mASMist;
    private Context mContext;

    public ASMListAdapter(Context context, List<ASMInfo> asmList) {
        mASMist = asmList;
        mContext = context;
    }

    @Override
    public ASMListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.asm_list_row, parent, false);
        ASMListAdapter.ViewHolder vh = new ASMListAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ASMListAdapter.ViewHolder holder, final int position) {
        final ASMInfo tsiInfo = mASMist.get(position);

        holder.tvTsiName.setText(tsiInfo.getAsmName());
        holder.monthlyGrowth.setText(tsiInfo.getMonthlyGrowth());
        holder.qtrGrowth.setText(tsiInfo.getQtdGrowth());
        holder.urbanStore.setText(tsiInfo.getUrbanStoreCount());
        holder.ruralStore.setText(tsiInfo.getRuralStoreCount());

        if (position % 2 == 0) {
            holder.view.setBackgroundColor(mContext.getResources().getColor(R.color.pink_shade));
        } else {
            holder.view.setBackgroundColor(mContext.getResources().getColor(R.color.purple));
        }
        holder.llContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Intent intent = new Intent(mContext, TsiListActivity.class);
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mASMist.size();
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

        @Bind(R.id.monthly_growth)
        CustomTextView monthlyGrowth;

        @Bind(R.id.qtr_growth)
        CustomTextView qtrGrowth;

        @Bind(R.id.urbanStore)
        CustomTextView urbanStore;

        @Bind(R.id.ruralStore)
        CustomTextView ruralStore;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

    }

}
