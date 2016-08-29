package com.ad.reckittbenckiser.fragments.asmlevelopportunity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.activities.DistributorListActivity;
import com.ad.reckittbenckiser.activities.TsiListActivity;
import com.ad.reckittbenckiser.adapter.TsiListAdapter;
import com.ad.reckittbenckiser.utils.AppConfig;
import com.ad.reckittbenckiser.utils.Constants;
import com.ad.reckittbenckiser.utils.Tracer;
import com.ad.reckittbenckiser.views.CustomTextView;
import com.ad.reckittbenckiser.vo.TSIInfo;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.AxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by laxmi.khatri on 8/17/2016.
 */
public class AsmPerformanceFragment extends Fragment {

    private String TAG = AppConfig.BaseTag + "." + AsmPerformanceFragment.class.getSimpleName();

    @Bind(R.id.chart)
    PieChart mChart;

    @Bind(R.id.unbilledChart)
    PieChart mUnbilledChart;

    /*@Bind(R.id.tv_opp)
    CustomTextView tvOpp;*/

    @Bind(R.id.tv_oppor)
    CustomTextView tvOppor;

    @Bind(R.id.fragment_tsi_list_rv)
    RecyclerView tsiRecyclerView;

    @Bind(R.id.bar_chart)
    HorizontalBarChart horizontalBarChart;

    TsiListAdapter tsiListAdapter;

    List<TSIInfo> tsiInfoList;
    float spaceForBar = 10f;
    // global variables
    protected Entry entry;
    protected Highlight highlight;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.asm_performance_fragment, null);
        ButterKnife.bind(this, view);

        //tvOpp.setText(getString(R.string.rs) + "994.6");
        tvOppor.setText(getString(R.string.rs) + "994.6");
        initiateBilledStoresChart();
        initiateUnBilledStoresChart();
        initTsiListAdapter();
        initHorizontalBarChart();
        return view;
    }

    private void initTsiListAdapter() {
        tsiInfoList = Constants.getTsiList();
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        tsiRecyclerView.setLayoutManager(llm);
        tsiListAdapter = new TsiListAdapter(getActivity(), tsiInfoList);
        tsiRecyclerView.setAdapter(tsiListAdapter);

        tsiRecyclerView.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside ScrollView
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }

    private void initiateUnBilledStoresChart() {
        mUnbilledChart.setDescription("");
        mUnbilledChart.setCenterText(getString(R.string.rs) + "410L");
        mUnbilledChart.setCenterTextSize(12f);

        // radius of the center hole in percent of maximum radius
        mUnbilledChart.setHoleRadius(35f);
        mUnbilledChart.setTransparentCircleRadius(38f);
        mUnbilledChart.setDrawEntryLabels(false);

        /*ArrayList<String> xVals = new ArrayList<String>();
        String[] valueArray = new String[]{"Q1", "Q2"};

        for (int i = 0; i < valueArray.length + 1; i++)
            xVals.add(valueArray[i % valueArray.length]);*/

        Legend l = mUnbilledChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);

        /*PieData data = new PieData(generateUnBilledStoreData());
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.WHITE);
        mChart.setData(data);*/

        mUnbilledChart.setData(generateUnBilledStoreData());
    }


    private PieData generateUnBilledStoreData() {
        ArrayList<PieEntry> entries1 = new ArrayList<PieEntry>();

        entries1.add(new PieEntry((float) 21, "Urban"));
        entries1.add(new PieEntry((float) 389, "Rural"));

        PieDataSet ds1 = new PieDataSet(entries1, "");
        ds1.setColors(VORDIPLOM_COLORS);
        ds1.setSliceSpace(2f);
        ds1.setValueTextColor(Color.WHITE);
        ds1.setValueTextSize(12f);

        PieData d = new PieData(ds1);
        d.setValueFormatter(new MyValueFormatter());
        return d;
    }

    private void initiateBilledStoresChart() {
        mChart.setDescription("");
        mChart.setCenterText(getString(R.string.rs) + "583L");
        mChart.setCenterTextSize(12f);

        // radius of the center hole in percent of maximum radius
        mChart.setHoleRadius(35f);
        mChart.setTransparentCircleRadius(38f);
        mChart.setDrawEntryLabels(false);

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
        d.setValueFormatter(new MyValueFormatter());
        return d;
    }

    public static final int[] VORDIPLOM_COLORS = {
            Color.rgb(179, 157, 219), Color.rgb(233, 53, 145)};

    public static final int[] SECOND_CHART = {
            Color.rgb(215, 50, 147), Color.rgb(141, 107, 179)};

    public void initHorizontalBarChart() {
        horizontalBarChart.setDrawGridBackground(false);
        horizontalBarChart.setDescription("");
//        horizontalBarChart.invalidate();

        XAxis xl = horizontalBarChart.getXAxis();
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        xl.setDrawAxisLine(true);
        xl.setDrawGridLines(false);
//        xl.setGranularity(300f);

        YAxis yl = horizontalBarChart.getAxisLeft();
        yl.setDrawAxisLine(false);
        yl.setDrawGridLines(false);
//        yl.setGranularity(50f);
        yl.setDrawLabels(true);
        //yl.setGranularity(10f);

        YAxis yr = horizontalBarChart.getAxisRight();
        yr.setDrawAxisLine(true);
        yr.setDrawGridLines(false);
//        yr.setGranularity(50f);

        setData(5);
        horizontalBarChart.setPinchZoom(false);
        horizontalBarChart.getAxisRight().setDrawLabels(false);
        horizontalBarChart.getLegend().setEnabled(false);   // Hide the legend
        horizontalBarChart.setFitBars(true);
        //horizontalBarChart.animateY(2500);
        Legend l = horizontalBarChart.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        l.setFormSize(8f);
        l.setXEntrySpace(4f);

        horizontalBarChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Tracer.info(TAG, "AsmPerformanceFragment().onValueSelected(): " + e);
                // set global variables
                entry = e;
                highlight = h;
                if (e.getY() == 168.6f) {
                    Intent intent = new Intent(getActivity(), DistributorListActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected() {
                onValueSelected(entry, highlight);
            }
        });
        horizontalBarChart.highlightValues(null);
    }

    private void setData(int count) {

        float barWidth = 9f;

        ArrayList<BarEntry> yVals1 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (i == 4) {
                yVals1.add(new BarEntry(i * spaceForBar, 168.6f));
            } else if (i == 3) {
                yVals1.add(new BarEntry(i * spaceForBar, 130.2f));
            } else if (i == 2) {
                yVals1.add(new BarEntry(i * spaceForBar, 118.2f));
            } else if (i == 1) {
                yVals1.add(new BarEntry(i * spaceForBar, 106.9f));
            } else if (i == 0) {
                yVals1.add(new BarEntry(i * spaceForBar, 59.9f));
            }
        }

        /*for (int i = 0; i < Constants.getTsiList().size(); i++) {
            float val = (float) (Math.random() * range);
            yVals1.add(new BarEntry(i * spaceForBar, val, Constants.getTsiList().get(i).getTsiName()));
            yVals1.add(new BarEntry(i * spaceForBar, val));
        }*/

        XAxis xAxis = horizontalBarChart.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValueFormatter());
        /*YAxis left = horizontalBarChart.getAxisLeft();
        left.setValueFormatter(new MyYAxisValueFormatter(Constants.getTsiNameArray()));*/

        BarDataSet set1;

        if (horizontalBarChart.getData() != null &&
                horizontalBarChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) horizontalBarChart.getData().getDataSetByIndex(0);
            set1.setColors(new int[]{R.color.purple, R.color.accent, R.color.brinjal, R.color.green_color, R.color.red_color});
            set1.setValues(yVals1);
            horizontalBarChart.getData().notifyDataChanged();
            horizontalBarChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "DataSet 1");

            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(barWidth);
            set1.setColors(new int[]{R.color.purple, R.color.accent, R.color.brinjal, R.color.green_color, R.color.red_color});
            horizontalBarChart.setData(data);
        }
    }

    public class MyXAxisValueFormatter implements AxisValueFormatter {

        public MyXAxisValueFormatter() {

        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            // "value" represents the position of the label on the axis (x or y)
            //return mValues[(int) value];
            for (int i = 0; i < 5; i++) {
                if (value == i * spaceForBar) {
                    return Constants.getTsiNameArray()[i];
                }
            }

            return "";
        }

        /**
         * this is only needed if numbers are returned, else return 0
         */
        @Override
        public int getDecimalDigits() {
            return 0;
        }
    }

    public class MyValueFormatter implements ValueFormatter {

        private DecimalFormat mFormat;

        public MyValueFormatter() {
            mFormat = new DecimalFormat("###,###,##0"); // use one decimal
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            // write your logic here
            return getString(R.string.rs) + mFormat.format(value);
//            return getString(R.string.rs) + value; // e.g. append a rs-sign
        }
    }
}
