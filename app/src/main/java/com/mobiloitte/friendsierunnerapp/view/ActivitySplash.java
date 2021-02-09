package com.mobiloitte.friendsierunnerapp.view;



import com.mobiloitte.friendsierunnerapp.BR;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.activity.BindingActivity;
import com.mobiloitte.friendsierunnerapp.databinding.ActivitySplashScreenBinding;
import com.mobiloitte.friendsierunnerapp.viewModel.ActivitySplashViewModel;

public class ActivitySplash extends BindingActivity<ActivitySplashScreenBinding, ActivitySplashViewModel> {
    @Override
    public ActivitySplashViewModel onCreate() {
        return new ActivitySplashViewModel(this);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash_screen;
    }
}
