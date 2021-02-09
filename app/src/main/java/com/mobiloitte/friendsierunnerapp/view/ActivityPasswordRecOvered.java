package com.mobiloitte.friendsierunnerapp.view;


import com.mobiloitte.friendsierunnerapp.BR;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.activity.BindingActivity;
import com.mobiloitte.friendsierunnerapp.databinding.ActivityPasswordRecoveredMessageBinding;
import com.mobiloitte.friendsierunnerapp.viewModel.ActivityPasswordReMessageViewModel;

public class ActivityPasswordRecOvered extends BindingActivity<ActivityPasswordRecoveredMessageBinding, ActivityPasswordReMessageViewModel> {
    @Override
    public ActivityPasswordReMessageViewModel onCreate() {
        return new ActivityPasswordReMessageViewModel(this);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_password_recovered_message;
    }
}
