package com.example.androidutils.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.example.androidutils.R;

public class DisplayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        initView();
    }

    private void initView() {
        TextView txtContent = (TextView) findViewById(R.id.txt_content);

        txtContent.setScrollContainer(true);

        txtContent.setText(getDisplayInfo());
    }

    private String getDisplayInfo() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        float scaledDensity = dm.scaledDensity;
        float widthPixels = dm.widthPixels;
        float heightPixels = dm.heightPixels;
        float densityDpi = dm.densityDpi;
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;
        String result = "density: " + density
                + "\nscaledDensity: " + scaledDensity
                + "\nwidthPixels: " + widthPixels
                + "\nheightPixels: " + heightPixels
                + "\ndensityDpi: " + densityDpi
                + "\nxdpi: " + xdpi
                + "\nydpi: " + ydpi;
        return result;
    }
}
