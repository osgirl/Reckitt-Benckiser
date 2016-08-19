package com.ad.reckittbenckiser.components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.utils.Util;

/**
 * Created by Shiva.Bansal on 8/18/2016.
 */

public class RadiationView extends View {

    private Paint paint;
    private int radarRadius ;
    private int strokeWidth = 1;
    private int outerArcWidth;
    private AnimationSet animationSet;
    private int animDuration;
    private int center;
    private Resources resources;
    private Context mContext;
    /**
     * @param context
     */
    public RadiationView(Context context) {
        super(context);
        mContext = context;
        resources = context.getResources();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(4);
        paint.setColor(getResources().getColor(R.color.radiation_color));
        paint.setStyle(Paint.Style.STROKE);

        outerArcWidth = (int)resources.getDimension(R.dimen.outer_arc_width);
        animDuration = getAnimDuration ();
    }

    private int getAnimDuration() {
        return animDuration == 0 ? (Util.getDeviceWidth(mContext)/2 - outerArcWidth)*10 : animDuration;
    }

    /* (non-Javadoc)
     * @see android.view.View#onDraw(android.graphics.Canvas)
     */
    @Override
    protected void onDraw(Canvas canvas) {

        center = getWidth()/2;
        RectF rect = new RectF(center-radarRadius, center-radarRadius, center+radarRadius, center+radarRadius);
        paint.setStrokeWidth(strokeWidth);
        canvas.drawArc(rect, 0, 360, false, paint);
        super.onDraw(canvas);
    }

    public void startRadarAnimation() {

        animationSet = new AnimationSet(false);

        RadarAnimation radarAnimation = new RadarAnimation();
        radarAnimation.setDuration(animDuration);
        radarAnimation.setFillAfter(false);
        animationSet.addAnimation(radarAnimation);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.01f);
        alphaAnimation.setDuration(animDuration);
        alphaAnimation.setFillAfter(false);
        animationSet.addAnimation(alphaAnimation);

        animationSet.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startRadarAnimation();
            }
        });

        startAnimation(animationSet);

    }


    public class RadarAnimation extends Animation {

        public RadarAnimation() {
            super();
            radarRadius = (int)resources.getDimension(R.dimen.my_profile_view_radius);
            strokeWidth = 1;
        }

        public RadarAnimation(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        /* (non-Javadoc)
         * @see android.view.animation.Animation#applyTransformation(float, android.view.animation.Transformation)
         */
        @Override
        protected void applyTransformation(float interpolatedTime,
                                           Transformation t) {

            if(strokeWidth <= center - (outerArcWidth)) {
                radarRadius = radarRadius+3;
                strokeWidth = strokeWidth+6;
                invalidate();
            }
            super.applyTransformation(interpolatedTime, t);
        }
    }


}
