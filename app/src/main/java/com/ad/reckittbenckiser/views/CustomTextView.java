package com.ad.reckittbenckiser.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.utils.CustomFontUtil;

/**
 * Created by shiva.bansal on 4/8/2016.
 */
@SuppressLint("NewApi")
public class CustomTextView extends TextView {

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public CustomTextView(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        init(attributeSet);
    }

    public CustomTextView(Context context, AttributeSet attributeSet, int defStyle, int defStyleRes) {
        super(context, attributeSet, defStyle, defStyleRes);
        init(attributeSet);
    }

    private void init(AttributeSet attrs) {
        CustomFontUtil.setCustomFont(this, getContext(), attrs, R.styleable.TextCustomFont, R.styleable.TextCustomFont_font);
    }
}
