package com.mobiloitte.friendsierunnerapp.view;


import com.mobiloitte.friendsierunnerapp.BR;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.activity.BindingActivity;
import com.mobiloitte.friendsierunnerapp.databinding.ActivityLandingPageBinding;
import com.mobiloitte.friendsierunnerapp.viewModel.ActivityLandingPageViewModel;

public class ActivityLandingPage extends BindingActivity<ActivityLandingPageBinding, ActivityLandingPageViewModel> {
    @Override
    public ActivityLandingPageViewModel onCreate() {
        return new ActivityLandingPageViewModel(this);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_landing__page_;
    }
}
