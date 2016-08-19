package com.ad.reckittbenckiser.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ad.reckittbenckiser.R;

/**
 * Created by Shiva.Bansal on 8/18/2016.
 */

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

       /* ImageView imageView = (ImageView) findViewById(R.id.btnLogin);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, TsiListActivity.class);
                startActivity(intent);
            }
        });*/
    }
}
