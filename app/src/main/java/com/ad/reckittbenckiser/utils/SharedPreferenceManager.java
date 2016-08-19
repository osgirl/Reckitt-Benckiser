package com.ad.reckittbenckiser.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Shiva.Bansal on 8/19/2016.
 */

public class SharedPreferenceManager {

    public static final String PREF_NAME = "RACKITT_BENCKISER";
    SharedPreferences pref;

    public SharedPreferenceManager(Context mcontext) {
        pref = mcontext.getSharedPreferences(PREF_NAME, 0);
    }

    public String getStringData(String key) {
        return pref.getString(key, "");
    }

    public int getIntData(String key) {
        return pref.getInt(key, 0);
    }

    public boolean getBooleanData(String key) {
        return pref.getBoolean(key, false);
    }

    public void setStringData(String key, String value) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void setIntData(String key, int value) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void setBooleanData(String key, Boolean value) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void clearPreferences() {
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }
}
