package com.ad.reckittbenckiser.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.utils.Constants;
import com.ad.reckittbenckiser.vo.ASMInfo;

import java.util.List;

import butterknife.Bind;

/**
 * Created by laxmi.khatri on 8/25/2016.
 */
public class AsmLeaderBoardActivity extends AppCompatActivity {

    @Bind(R.id.fragment_asm_list_rv)
    RecyclerView asmRecyclerView;

    List<ASMInfo> asmLeaderList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asm_leader_board);
        asmLeaderList = Constants.getASMList();
    }
}
