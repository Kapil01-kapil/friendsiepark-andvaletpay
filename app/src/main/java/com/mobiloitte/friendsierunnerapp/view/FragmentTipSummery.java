package com.mobiloitte.friendsierunnerapp.view;

import com.mobiloitte.friendsierunnerapp.BR;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.fragment.BindingFragment;
import com.mobiloitte.friendsierunnerapp.databinding.FragmentTipSummaryBinding;
import com.mobiloitte.friendsierunnerapp.viewModel.FragmentTipSummeryViewModel;

public class FragmentTipSummery extends BindingFragment<FragmentTipSummeryViewModel, FragmentTipSummaryBinding> {
    @Override
    protected FragmentTipSummeryViewModel onCreateViewModel(FragmentTipSummaryBinding binding) {
        return new FragmentTipSummeryViewModel(this,getBinding());
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutResources() {
        return R.layout.fragment_tip_summary;
    }
}
