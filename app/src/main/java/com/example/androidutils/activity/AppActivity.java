package com.example.androidutils.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidutils.R;
import com.example.androidutils.utils.AppUtils;

import java.io.File;

public class AppActivity extends Activity {

    private Context mContext;

    private static final String TEST_PACKGE_NAME = "com.example.getimage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        mContext = this;
        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView txtContent = (TextView) findViewById(R.id.txt_content);
        int versionCode = AppUtils.getVersionCode(mContext);
        String versionName = AppUtils.getVersionName(mContext);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("versionCode: " + versionCode
                + "\nversionName: " + versionName);
        txtContent.setText(stringBuilder);

        boolean isPackageInstalled = AppUtils.isPackageInstalled(mContext, TEST_PACKGE_NAME);
        txtContent.append("\nisPackageInstalled: " + isPackageInstalled);
    }

    private void initViews() {

        Button btnInstall = (Button) findViewById(R.id.btn_install);
        Button btnUninstall = (Button) findViewById(R.id.btn_uninstall);

        btnInstall.setOnClickListener(btnOnClickListener);
        btnUninstall.setOnClickListener(btnOnClickListener);
    }

    private View.OnClickListener btnOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_install:
                    File apkFile = new File("storage/sdcard0/"+ "getImage.apk");
                    Log.d("bearyang", "apkFile.exists(): " + apkFile.exists());
                    if (AppUtils.isPackageInstalled(mContext, TEST_PACKGE_NAME)) {
                        Toast.makeText(mContext, "this app has installed.", Toast.LENGTH_LONG).show();
                    } else {
                        if (apkFile.exists()) {
                            AppUtils.installApk(mContext, apkFile);
                        }
                    }
                    break;
                case R.id.btn_uninstall:
                    if (AppUtils.isPackageInstalled(mContext, TEST_PACKGE_NAME)) {
                        AppUtils.uninstallApk(mContext, TEST_PACKGE_NAME);
                    } else {
                        Toast.makeText(mContext, "this app has not installed.", Toast.LENGTH_LONG).show();
                    }
                    break;
            }
        }
    };


}
