package com.mobiloitte.friendsierunnerapp.viewModel;

import android.view.View;
import android.view.WindowManager;

import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.activity.ActivityViewModel;
import com.mobiloitte.friendsierunnerapp.util.ActivityController;
import com.mobiloitte.friendsierunnerapp.view.ActivityPasswordRecOvered;
import com.mobiloitte.friendsierunnerapp.view.ActivityResetCode;


public class ActivityPasswordReMessageViewModel extends ActivityViewModel<ActivityPasswordRecOvered> implements View.OnClickListener {
private ActivityPasswordRecOvered activity;



    public ActivityPasswordReMessageViewModel(ActivityPasswordRecOvered activity) {
        super(activity);
        this.activity=activity;
        activity.getBinding().btlogin.setOnClickListener(this);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btlogin:

                ActivityController.startActivity(activity, ActivityResetCode.class,true);
                break;
                default:break;

        }
    }

    @Override
    public void onBackPressed() {
        ActivityController.startActivity(activity, ActivityResetCode.class,true);
    }
}
