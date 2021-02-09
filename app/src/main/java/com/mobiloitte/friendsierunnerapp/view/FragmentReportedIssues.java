package com.mobiloitte.friendsierunnerapp.view;


import com.mobiloitte.friendsierunnerapp.BR;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.fragment.BindingFragment;
import com.mobiloitte.friendsierunnerapp.databinding.ActivityRwportedIssuesBinding;
import com.mobiloitte.friendsierunnerapp.databinding.FragmentDashboardBinding;
import com.mobiloitte.friendsierunnerapp.viewModel.FragmentDashBoardViewModel;
import com.mobiloitte.friendsierunnerapp.viewModel.FragmentReportedissuesViewModel;

public class FragmentReportedIssues extends BindingFragment<FragmentReportedissuesViewModel, ActivityRwportedIssuesBinding> {
    @Override
    protected FragmentReportedissuesViewModel onCreateViewModel(ActivityRwportedIssuesBinding binding) {
        return new FragmentReportedissuesViewModel(this,getBinding());
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutResources() {
        return R.layout.activity_rwported_issues;
    }
}

