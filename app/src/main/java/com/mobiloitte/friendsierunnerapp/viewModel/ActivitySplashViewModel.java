package com.mobiloitte.friendsierunnerapp.viewModel;

import android.os.Handler;
import android.view.WindowManager;

import com.mobiloitte.friendsierunnerapp.base.activity.ActivityViewModel;
import com.mobiloitte.friendsierunnerapp.util.ActivityController;
import com.mobiloitte.friendsierunnerapp.util.AppConstant;
import com.mobiloitte.friendsierunnerapp.util.SavedPrefManager;
import com.mobiloitte.friendsierunnerapp.view.ActivityLandingPage;
import com.mobiloitte.friendsierunnerapp.view.ActivitySplash;
import com.mobiloitte.friendsierunnerapp.view.DashboardActivity;


public class ActivitySplashViewModel extends ActivityViewModel<ActivitySplash> {
    private ActivitySplash activity;
    private static int SPLASHTIMEOUT=3000;


    public ActivitySplashViewModel(final ActivitySplash activity) {
        super(activity);
        this.activity=activity;
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Boolean isLogin=SavedPrefManager.getBooleanPreferences(activity,AppConstant.IS_LOGIN);
                if (isLogin){
                    ActivityController.startActivity(activity, DashboardActivity.class,true);
                    finish();
                }else {
                    ActivityController.startActivity(activity, ActivityLandingPage.class,true);
                    finish();
                }

            }
        },SPLASHTIMEOUT);
    }
}
