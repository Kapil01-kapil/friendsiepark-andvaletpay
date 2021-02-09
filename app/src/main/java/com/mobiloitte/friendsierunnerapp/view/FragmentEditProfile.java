package com.mobiloitte.friendsierunnerapp.view;


import com.mobiloitte.friendsierunnerapp.BR;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.fragment.BindingFragment;
import com.mobiloitte.friendsierunnerapp.databinding.ActivityProfileBinding;
import com.mobiloitte.friendsierunnerapp.viewModel.FragmentEditProfileViewModel;

public class FragmentEditProfile extends BindingFragment<FragmentEditProfileViewModel, ActivityProfileBinding> {
    @Override
    protected FragmentEditProfileViewModel onCreateViewModel(ActivityProfileBinding binding) {
        return new FragmentEditProfileViewModel(this,getBinding());
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutResources() {
        return R.layout.activity_profile;
    }








}

