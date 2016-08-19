package com.ad.reckittbenckiser.utils;

import android.util.Log;

/**
 * Class used to print all the Logs shown at the time of production
 */
public class Tracer {

    private final static Boolean LOG_ENABLE = AppConfig.showLog;

    /**
     * Method to print debug log<br>
     * {@link Log} Information
     *
     * @param TAG
     * @param message
     */
    public static void debug(String TAG, String message) {
        if (LOG_ENABLE) {
            Log.d(TAG, message);
        }
    }

    /**
     * Method to print error log<br>
     * {@link Log} Error
     *
     * @param TAG
     * @param message
     */
    public static void error(String TAG, String message) {
        if (LOG_ENABLE) {
            Log.e(TAG, message);
        }
    }

    /**
     * Method to print information log<br>
     * {@link Log} Debug
     *
     * @param TAG
     * @param message
     */
    public static void info(String TAG, String message) {
        if (LOG_ENABLE) {
            Log.i(TAG, message);
        }
    }
}
