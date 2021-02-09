package com.mobiloitte.friendsierunnerapp.view;


import com.mobiloitte.friendsierunnerapp.BR;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.fragment.BindingFragment;
import com.mobiloitte.friendsierunnerapp.databinding.ActivityParkingBinding;
import com.mobiloitte.friendsierunnerapp.databinding.FragmentDashboardBinding;
import com.mobiloitte.friendsierunnerapp.viewModel.FragmentDashBoardViewModel;
import com.mobiloitte.friendsierunnerapp.viewModel.FragmentParkingHistoryViewModel;

public class FragmentParkingHistory extends BindingFragment<FragmentParkingHistoryViewModel, ActivityParkingBinding> {
    @Override
    protected FragmentParkingHistoryViewModel onCreateViewModel(ActivityParkingBinding binding) {
        return new FragmentParkingHistoryViewModel(this,getBinding());
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutResources() {
        return R.layout.activity_parking;
    }
}
