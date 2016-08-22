package com.ad.reckittbenckiser.fragments.zonelevelopportunity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ad.reckittbenckiser.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by bansal.shiva on 8/17/2016.
 */
public class ZonePerformanceFragment extends Fragment {

    @Bind(R.id.chart)
    PieChart mChart;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zone_performace_fragment, null);
        ButterKnife.bind(this, view);

        initiateView();
        return view;
    }

    private void initiateView(){
        mChart.setDescription("Opportunity(Lakhs) from Billed Stores");
        mChart.setCenterText(generateCenterText());
        mChart.setCenterTextSize(14f);

        // radius of the center hole in percent of maximum radius
        mChart.setHoleRadius(45f);
        mChart.setTransparentCircleRadius(50f);

        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        mChart.setData(generatePieData());
    }

    private SpannableString generateCenterText() {
        SpannableString s = new SpannableString("Total 583.7");
        s.setSpan(new RelativeSizeSpan(2f), 0, 11, 0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY), 11, s.length(), 0);
        return s;
    }


    protected PieData generatePieData() {
        ArrayList<PieEntry> entries1 = new ArrayList<PieEntry>();

        entries1.add(new PieEntry(225 , "Rural"));
        entries1.add(new PieEntry((float) 358.6, "Urban"));

        PieDataSet ds1 = new PieDataSet(entries1, "");
        ds1.setColors(ColorTemplate.VORDIPLOM_COLORS);
        ds1.setSliceSpace(2f);
        ds1.setValueTextColor(Color.WHITE);
        ds1.setValueTextSize(12f);

        PieData d = new PieData(ds1);
        return d;
    }

    public static final int[] VORDIPLOM_COLORS = {
            Color.rgb(248, 187, 208), Color.rgb(255, 247, 140)};
}
