package com.mobiloitte.friendsierunnerapp.view;


import com.mobiloitte.friendsierunnerapp.BR;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.activity.BindingActivity;
import com.mobiloitte.friendsierunnerapp.databinding.ActivityResetCodeBinding;
import com.mobiloitte.friendsierunnerapp.viewModel.ActivityResetCodeViewModel;

public class ActivityResetCode extends BindingActivity<ActivityResetCodeBinding, ActivityResetCodeViewModel> {
    @Override
    public ActivityResetCodeViewModel onCreate() {
        return new ActivityResetCodeViewModel(this);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_reset_code;
    }
}
