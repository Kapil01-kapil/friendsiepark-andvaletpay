package com.mobiloitte.friendsierunnerapp.view;


import com.mobiloitte.friendsierunnerapp.BR;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.fragment.BindingFragment;
import com.mobiloitte.friendsierunnerapp.databinding.FragmentDashboardBinding;
import com.mobiloitte.friendsierunnerapp.viewModel.FragmentDashBoardViewModel;

public class FragmentDashBoard extends BindingFragment<FragmentDashBoardViewModel, FragmentDashboardBinding> {
    @Override
    protected FragmentDashBoardViewModel onCreateViewModel(FragmentDashboardBinding binding) {
        return new FragmentDashBoardViewModel(this,getBinding());
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutResources() {
        return R.layout.fragment_dashboard;
    }
}

