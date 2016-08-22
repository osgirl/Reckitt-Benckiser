package com.ad.reckittbenckiser.fragments.zonelevelopportunity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.adapter.ASMListAdapter;
import com.ad.reckittbenckiser.utils.Constants;
import com.ad.reckittbenckiser.vo.ASMInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by bansal.shiva on 8/22/2016.
 */
public class AsmListFragment extends Fragment {

    @Bind(R.id.fragment_asm_list_rv)
    RecyclerView asmRecyclerView;

    ASMListAdapter asmListAdapter;
    List<ASMInfo> asmInfoList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        asmInfoList = Constants.getASMList();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asm_list, null);
        ButterKnife.bind(this, view);
        initViewAndAdapter();
        return view;
    }

    private void initViewAndAdapter() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        asmRecyclerView.setLayoutManager(llm);

        asmListAdapter = new ASMListAdapter(getActivity(), asmInfoList);
        asmRecyclerView.setAdapter(asmListAdapter);
    }
}



