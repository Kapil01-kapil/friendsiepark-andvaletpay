package com.mobiloitte.friendsierunnerapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mobiloitte.friendsierunnerapp.BR;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.activity.BindingActivity;
import com.mobiloitte.friendsierunnerapp.databinding.ActivityAddClientBinding;
import com.mobiloitte.friendsierunnerapp.databinding.ActivitySplashScreenBinding;
import com.mobiloitte.friendsierunnerapp.util.ActivityController;
import com.mobiloitte.friendsierunnerapp.view.FragmentDashBoard;
import com.mobiloitte.friendsierunnerapp.viewModel.ActivityClientViewModel;
import com.mobiloitte.friendsierunnerapp.viewModel.ActivitySplashViewModel;

public class AddClientActivity extends BindingActivity<ActivityAddClientBinding, ActivityClientViewModel> {
    @Override
    public ActivityClientViewModel onCreate() {

        return new ActivityClientViewModel(this);
    }
    @Override
    public int getVariable() {
        return BR.viewModel;
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_add_client;
    }
}
