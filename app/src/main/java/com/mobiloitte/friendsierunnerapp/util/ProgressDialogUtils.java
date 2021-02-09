package com.mobiloitte.friendsierunnerapp.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;

import com.mobiloitte.friendsierunnerapp.R;


public class ProgressDialogUtils {

    private static ProgressDialog progressDialog;

    public ProgressDialogUtils() {
        throw new Error("U will not able to instantiate it");
    }

    public static void show(Context context) {
        try {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            int style;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                style = android.R.style.Theme_Material_Light_Dialog;
            } else {
                //noinspection deprecation
                style = ProgressDialog.THEME_HOLO_LIGHT;
            }

            progressDialog = new ProgressDialog(context, style);
            progressDialog.setMessage(context.getResources().getString(R.string.please_wait_));
            progressDialog.setCancelable(false);
            progressDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void show(Context context, String message) {
        try {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            int style;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                style = android.R.style.Theme_Material_Light_Dialog;
            } else {
                //noinspection deprecation
                style = ProgressDialog.THEME_HOLO_LIGHT;
            }

            progressDialog = new ProgressDialog(context, style);
            progressDialog.setMessage(message);
            progressDialog.setCancelable(false);
            progressDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeDialogMessage(String message) {
        if(progressDialog != null && progressDialog.isShowing()) {
            progressDialog.setMessage(message);
        }
    }

    public static void dismiss() {
        if (progressDialog != null && progressDialog.isShowing()) {
            try {
                progressDialog.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
            progressDialog = null;
        }
    }
}
