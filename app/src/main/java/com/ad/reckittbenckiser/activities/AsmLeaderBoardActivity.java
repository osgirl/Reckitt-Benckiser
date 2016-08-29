package com.ad.reckittbenckiser.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.adapter.ASMListAdapter;
import com.ad.reckittbenckiser.adapter.AsmLeaderBoardAdapter;
import com.ad.reckittbenckiser.utils.Constants;
import com.ad.reckittbenckiser.utils.Tracer;
import com.ad.reckittbenckiser.views.CustomTextView;
import com.ad.reckittbenckiser.vo.ASMInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by laxmi.khatri on 8/25/2016.
 */
public class AsmLeaderBoardActivity extends AppCompatActivity {

    @Bind(R.id.fragment_asm_list_rv)
    RecyclerView asmRecyclerView;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.tv_toolbar_title)
    CustomTextView tvTitle;

    List<ASMInfo> asmLeaderList;
    AsmLeaderBoardAdapter asmLeaderBoardAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asm_leader_board);
        asmLeaderList = Constants.getAsmLeadorBoard();
        ButterKnife.bind(this);
        init();
        initViewAndAdapter();
    }

    private void init() {
        // Creating The Toolbar and setting it as the Toolbar for the activity
        setSupportActionBar(toolbar);
        tvTitle.setText("ASM  Leaderboard");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void initViewAndAdapter() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        asmRecyclerView.setLayoutManager(llm);

        asmLeaderBoardAdapter = new AsmLeaderBoardAdapter(this, asmLeaderList);
        asmRecyclerView.setAdapter(asmLeaderBoardAdapter);
    }

    @OnClick(R.id.backBtn)
    public void back() {
        finish();
    }
}
