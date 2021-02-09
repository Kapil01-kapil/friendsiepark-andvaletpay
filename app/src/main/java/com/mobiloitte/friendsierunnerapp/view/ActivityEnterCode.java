package com.mobiloitte.friendsierunnerapp.view;



import com.mobiloitte.friendsierunnerapp.BR;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.activity.BindingActivity;
import com.mobiloitte.friendsierunnerapp.databinding.ActivityEnterCodeBinding;
import com.mobiloitte.friendsierunnerapp.viewModel.ActivityEnterCodeViewModel;

public class ActivityEnterCode extends BindingActivity<ActivityEnterCodeBinding, ActivityEnterCodeViewModel> {
    @Override
    public ActivityEnterCodeViewModel onCreate() {
        return new ActivityEnterCodeViewModel(this);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_enter__code_;
    }
}
