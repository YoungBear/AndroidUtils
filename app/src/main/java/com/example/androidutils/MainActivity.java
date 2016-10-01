package com.example.androidutils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidutils.activity.AppActivity;
import com.example.androidutils.activity.BuildInfoActivity;
import com.example.androidutils.activity.DisplayActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        Button btnDisplay = (Button) findViewById(R.id.btn_display);
        Button btnBuild = (Button) findViewById(R.id.btn_build);
        Button btnApp = (Button) findViewById(R.id.btn_app);

        btnDisplay.setOnClickListener(btnOnClickListener);
        btnBuild.setOnClickListener(btnOnClickListener);
        btnApp.setOnClickListener(btnOnClickListener);
    }

    private void startActivity(Class<?> cls) {
        startActivity(new Intent(MainActivity.this, cls));
    }

    private View.OnClickListener btnOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_display:
                    startActivity(DisplayActivity.class);
                    break;
                case R.id.btn_build:
                    startActivity(BuildInfoActivity.class);
                    break;
                case R.id.btn_app:
                    startActivity(AppActivity.class);
                    break;
            }
        }
    };
}
