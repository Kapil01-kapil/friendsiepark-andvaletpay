package com.mobiloitte.friendsierunnerapp.view;

import com.mobiloitte.friendsierunnerapp.BR;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.activity.BindingActivity;
import com.mobiloitte.friendsierunnerapp.databinding.ActivityLogInBinding;
import com.mobiloitte.friendsierunnerapp.viewModel.ActivityLoginViewModel;

public class ActivityLogin extends BindingActivity<ActivityLogInBinding, ActivityLoginViewModel> {
    @Override
    public ActivityLoginViewModel onCreate() {
        return new ActivityLoginViewModel(this);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_log_in_;
    }
}
