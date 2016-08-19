package com.ad.reckittbenckiser.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

import com.ad.reckittbenckiser.vo.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /*
    * This method is used to validate email address
    * Currently allowed domain - gmail.com
    */
    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.\\'-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        //String expression = "^[A-Za-z0-9._%+-]+@gmail.com$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }


}
