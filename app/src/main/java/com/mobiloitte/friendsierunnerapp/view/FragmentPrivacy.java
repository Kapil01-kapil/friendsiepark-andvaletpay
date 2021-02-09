package com.mobiloitte.friendsierunnerapp.view;

import com.mobiloitte.friendsierunnerapp.BR;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.fragment.BindingFragment;
import com.mobiloitte.friendsierunnerapp.databinding.FragmentPrivacyPolicyBinding;
import com.mobiloitte.friendsierunnerapp.viewModel.FragmentPrivacyPolicyViewModel;

public class FragmentPrivacy extends  BindingFragment<FragmentPrivacyPolicyViewModel, FragmentPrivacyPolicyBinding> {

@Override
protected FragmentPrivacyPolicyViewModel onCreateViewModel(FragmentPrivacyPolicyBinding binding) {
        return new FragmentPrivacyPolicyViewModel(this,getBinding());
        }


        @Override
public int getVariable() {
        return BR.viewModel;
        }

@Override
public int getLayoutResources() {
        return R.layout.fragment_privacy_policy;
        }
        }
