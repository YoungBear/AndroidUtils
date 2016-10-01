package com.example.androidutils.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.example.androidutils.R;

public class BuildInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_info);

        initView();
    }

    private void initView() {
        TextView txtContent = (TextView) findViewById(R.id.txt_content);

        txtContent.setScrollContainer(true);

        txtContent.setText(getBuildInfo());
    }

    private static String getBuildInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ID: " + Build.ID + "\n");
        stringBuilder.append("DISPLAY: " + Build.DISPLAY + "\n");
        stringBuilder.append("Product: " + Build.PRODUCT + "\n");
        stringBuilder.append("DEVICE: " + Build.DEVICE + "\n");
        stringBuilder.append("BOARD: " + Build.BOARD + "\n");
        stringBuilder.append("MANUFACTURER: " + Build.MANUFACTURER + "\n");
        stringBuilder.append("BRAND: " + Build.BRAND + "\n");
        stringBuilder.append("MODEL: " + Build.MODEL + "\n");
        stringBuilder.append("BOOTLOADER: " + Build.BOOTLOADER + "\n");
        stringBuilder.append("HARDWARE: " + Build.HARDWARE + "\n");
        stringBuilder.append("SERIAL: " + Build.SERIAL + "\n");

        stringBuilder.append("版本信息: \n");

        stringBuilder.append("INCREMENTAL: " + Build.VERSION.INCREMENTAL + "\n");
        stringBuilder.append("RELEASE: " + Build.VERSION.RELEASE + "\n");
        stringBuilder.append("SDK: " + Build.VERSION.SDK + "\n");
        stringBuilder.append("SDK_INT: " + Build.VERSION.SDK_INT + "\n");
        stringBuilder.append("CODENAME: " + Build.VERSION.CODENAME + "\n");

        return stringBuilder.toString();
    }
}
