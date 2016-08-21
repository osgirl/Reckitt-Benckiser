package com.ad.reckittbenckiser.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.ImageView;

import com.ad.reckittbenckiser.R;
import com.ad.reckittbenckiser.utils.AppConfig;
import com.ad.reckittbenckiser.utils.PreferenceKeys;
import com.ad.reckittbenckiser.utils.SharedPreferenceManager;
import com.ad.reckittbenckiser.utils.Util;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Shiva.Bansal on 8/18/2016.
 */

public class LoginActivity extends Activity {

    @Bind(R.id.editEmail)
    EditText editEmail;

    @Bind(R.id.editPassword)
    EditText editPassword;

    @Bind(R.id.layoutTop)
    RelativeLayout mRelativeLayoutTop;

    private SharedPreferenceManager mSharedPreferenceManager;
    private int deviceHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_design);
        ButterKnife.bind(this);
        mSharedPreferenceManager = new SharedPreferenceManager(this);
        initiateView();
    }

    private void initiateView(){
        deviceHeight = Util.getDeviceHeight(this);
        mRelativeLayoutTop.addView(new MyTopView(this));

        TextView mTextView2 = new TextView(this);
        mTextView2.setLayoutParams(new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));
        RelativeLayout.LayoutParams lay2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lay2.setMargins(0,40,0,0);
        lay2.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        lay2.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        mTextView2.setText("Login");
        mTextView2.setTextColor(Color.WHITE);
        mTextView2.setTextSize(35);
        mRelativeLayoutTop.addView(mTextView2, lay2);
    }

    public class MyTopView extends View{

        public MyTopView(Context context) {
            super(context);
        }

        @Override

        protected void onDraw(Canvas canvas) {
            Paint p = new Paint();
            p.setAntiAlias(true);
            RectF rectF = new RectF(-100, -deviceHeight/4, Util.getDeviceWidth(LoginActivity.this)+100, deviceHeight/4);
            p.setColor(getResources().getColor(R.color.primary));
            canvas.drawArc(rectF, 0, 180, true, p);
        }
    }

    @OnClick(R.id.btnLogin)
    public void onLoginClick() {
        if (editEmail.getText().toString().trim().equalsIgnoreCase("")) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.oops) + " " + getResources().getString(R.string.validation_email), Toast.LENGTH_LONG).show();
        } else if (!Util.isEmailValid(editEmail.getText().toString().trim())) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.oops) + " " + getResources().getString(R.string.validation_valid_email), Toast.LENGTH_LONG).show();
        } else if (editPassword.getText().toString().trim().equalsIgnoreCase("")) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.oops) + " " + getResources().getString(R.string.validation_password), Toast.LENGTH_LONG).show();
        } else {
            verifyUser();
        }
    }

    private void verifyUser() {
        if (editEmail.getText().toString().trim().equals(AppConfig.USER_EMAIL) && editPassword.getText().toString().equals(AppConfig.USER_PASSWORD)) {
            goToHome();
            mSharedPreferenceManager.setBooleanData(PreferenceKeys.IS_UER_USER_LOGIN, true);
        } else {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.oops) + " " + getResources().getString(R.string.valid_user_error), Toast.LENGTH_LONG).show();
        }
    }

    private void goToHome(){
        Intent intent = new Intent(LoginActivity.this, OpportunityZone.class);
        startActivity(intent);
    }
}