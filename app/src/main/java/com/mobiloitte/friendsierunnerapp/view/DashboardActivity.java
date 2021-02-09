package com.mobiloitte.friendsierunnerapp.view;

import com.mobiloitte.friendsierunnerapp.BR;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.activity.BindingActivity;
import com.mobiloitte.friendsierunnerapp.databinding.ActivityDashboardBinding;

import com.mobiloitte.friendsierunnerapp.viewModel.DashboardViewModel;

public class DashboardActivity extends BindingActivity <ActivityDashboardBinding, DashboardViewModel> {
    @Override
    public DashboardViewModel onCreate() {
        return new DashboardViewModel(this);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_dashboard;
    }
}
