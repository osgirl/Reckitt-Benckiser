package com.ad.reckittbenckiser.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.activities.TsiListActivity;
import com.ad.reckittbenckiser.views.CustomTextView;
import com.ad.reckittbenckiser.vo.ASMInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by laxmi.khatri on 8/25/2016.
 */
public class AsmLeaderBoardAdapter extends RecyclerView.Adapter<AsmLeaderBoardAdapter.ViewHolder> {

    private List<ASMInfo> mASMist;
    private Context mContext;

    public AsmLeaderBoardAdapter(Context context, List<ASMInfo> asmList) {
        mASMist = asmList;
        mContext = context;
    }

    @Override
    public AsmLeaderBoardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.asm_leader_board_row, parent, false);
        AsmLeaderBoardAdapter.ViewHolder vh = new AsmLeaderBoardAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final AsmLeaderBoardAdapter.ViewHolder holder, final int position) {
        final ASMInfo asmInfo = mASMist.get(position);

        holder.tvAsmName.setText(asmInfo.getAsmName());
        holder.tvRank.setText(asmInfo.getRank() + "");
        holder.tvGrowth.setText(asmInfo.getMonthlyGrowth());

        if (position % 2 == 0) {
            holder.tvRank.setBackgroundColor(mContext.getResources().getColor(R.color.light_grey1));
            holder.tvAsmName.setBackgroundColor(mContext.getResources().getColor(R.color.light_grey2));
            holder.tvGrowth.setBackgroundColor(mContext.getResources().getColor(R.color.light_grey3));
        } else {
            holder.tvRank.setBackgroundColor(mContext.getResources().getColor(R.color.light_purple1));
            holder.tvAsmName.setBackgroundColor(mContext.getResources().getColor(R.color.light_purple2));
            holder.tvGrowth.setBackgroundColor(mContext.getResources().getColor(R.color.light_purple3));
        }
        if (position == 8) {
            holder.tvGrowth.setTextColor(mContext.getResources().getColor(R.color.red_color));
        } else {
            holder.tvGrowth.setTextColor(mContext.getResources().getColor(R.color.green_color));
        }
        holder.llContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 3) {
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

        @Bind(R.id.tv_rank)
        CustomTextView tvRank;

        @Bind(R.id.tv_asm_name)
        CustomTextView tvAsmName;

        @Bind(R.id.tv_growth)
        CustomTextView tvGrowth;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

    }
}
