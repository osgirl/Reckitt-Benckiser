package com.ad.reckittbenckiser.fragments.tsilevelopportunity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.utils.AppConfig;
import com.ad.reckittbenckiser.utils.Tracer;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by laxmi.khatri on 8/17/2016.
 */
public class TsiPerformanceFragment extends Fragment {

    private String TAG = AppConfig.BaseTag + "." + TsiPerformanceFragment.class.getSimpleName();

    @Bind(R.id.chart)
    PieChart mChart;

    @Bind(R.id.unbilledChart)
    PieChart mUnbilledChart;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tsi_performance_fragment, null);
        ButterKnife.bind(this, view);

        initiateBilledStoresChart();
        initiateUnBilledStoresChart();
        return view;
    }

    private void initiateUnBilledStoresChart() {
        mUnbilledChart.setDescription("");
        mUnbilledChart.setCenterText("Total 510");
        mUnbilledChart.setCenterTextSize(12f);

        // radius of the center hole in percent of maximum radius
        mUnbilledChart.setHoleRadius(45f);
        mUnbilledChart.setTransparentCircleRadius(50f);

        Legend l = mUnbilledChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        mUnbilledChart.setData(generateUnBilledStoreData());
    }

    private PieData generateUnBilledStoreData() {
        ArrayList<PieEntry> entries1 = new ArrayList<PieEntry>();

        entries1.add(new PieEntry((float) 121, "Urban"));
        entries1.add(new PieEntry((float) 389, "Rural"));

        PieDataSet ds1 = new PieDataSet(entries1, "");
        ds1.setColors(VORDIPLOM_COLORS);
        ds1.setSliceSpace(2f);
        ds1.setValueTextColor(Color.WHITE);
        ds1.setValueTextSize(12f);

        PieData d = new PieData(ds1);
        return d;
    }

    private void initiateBilledStoresChart() {
        mChart.setDescription("");
        mChart.setCenterText("Total 583");
        mChart.setCenterTextSize(12f);

        // radius of the center hole in percent of maximum radius
        mChart.setHoleRadius(45f);
        mChart.setTransparentCircleRadius(50f);

        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        mChart.setData(generateBilledStoreData());
    }

    private PieData generateBilledStoreData() {
        ArrayList<PieEntry> entries1 = new ArrayList<PieEntry>();

        entries1.add(new PieEntry(225, "Rural"));
        entries1.add(new PieEntry((float) 358, "Urban"));

        PieDataSet ds1 = new PieDataSet(entries1, "");
        ds1.setColors(SECOND_CHART);
        ds1.setSliceSpace(2f);
        ds1.setValueTextColor(Color.WHITE);
        ds1.setValueTextSize(12f);

        PieData d = new PieData(ds1);
        return d;
    }

    public static final int[] VORDIPLOM_COLORS = {
            Color.rgb(179, 157, 219), Color.rgb(233, 53, 145)};

    public static final int[] SECOND_CHART = {
            Color.rgb(215, 50, 147), Color.rgb(141, 107, 179)};
}
