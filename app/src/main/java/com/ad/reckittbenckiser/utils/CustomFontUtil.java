package com.ad.reckittbenckiser.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.ref.SoftReference;
import java.util.Hashtable;

/**
 * Created by laxmi.khatri on 4/20/2016.
 */
public class CustomFontUtil {

    private static final Hashtable<String, SoftReference<Typeface>> fontCache = new Hashtable<String, SoftReference<Typeface>>();

    public static void setCustomFont(View view, Context context, AttributeSet attrs, int[] attributeSet, int fontId) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, attributeSet);
        String customFont = typedArray.getString(fontId);
        setCustomFont(view, context, customFont);
        typedArray.recycle();
    }

    private static boolean setCustomFont(View view, Context context, String asset) {
        if (TextUtils.isEmpty(asset))
            return false;
        Typeface tf = null;
        try {
            tf = getFont(context, asset);
            if (view instanceof TextView) {
                ((TextView) view).setTypeface(tf);
            } else if (view instanceof EditText) {
                ((EditText) view).setTypeface(tf);
            } else if (view instanceof Button) {
                ((Button) view).setTypeface(tf);
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * Method to set type face
     *
     * @param context
     * @param name
     * @return
     */
    public static Typeface getFont(Context context, String name) {
        synchronized (fontCache) {
            if (fontCache.get(name) != null) {
                SoftReference<Typeface> ref = fontCache.get(name);
                if (ref.get() != null) {
                    return ref.get();
                }
            }

            Typeface typeface = Typeface.createFromAsset(context.getAssets(), name);
            fontCache.put(name, new SoftReference<Typeface>(typeface));

            return typeface;
        }
    }
}
