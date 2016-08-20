package com.ad.reckittbenckiser.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
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


    private SharedPreferenceManager mSharedPreferenceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mSharedPreferenceManager = new SharedPreferenceManager(this);
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