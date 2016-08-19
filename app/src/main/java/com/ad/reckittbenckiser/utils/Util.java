package com.ad.reckittbenckiser.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Shiva.Bansal on 8/18/2016.
 */

public class Util {

    /**
     * @param mContext - Activity context
     * @return - device width
     */
    public static int getDeviceWidth(Context mContext)
    {
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity)mContext).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    public static int getDeviceHeight(Context mContext)
    {
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity)mContext).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }
}
