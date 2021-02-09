package com.mobiloitte.friendsierunnerapp.view;


import com.mobiloitte.friendsierunnerapp.BR;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.activity.BindingActivity;
import com.mobiloitte.friendsierunnerapp.databinding.ActivityForgotPasswordBinding;
import com.mobiloitte.friendsierunnerapp.viewModel.ActivityForgotPasswordViewModel;

public class ActivityForgotPassword extends BindingActivity<ActivityForgotPasswordBinding, ActivityForgotPasswordViewModel> {
    @Override
    public ActivityForgotPasswordViewModel onCreate() {
        return new ActivityForgotPasswordViewModel(this);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_forgot_password;
    }
}
