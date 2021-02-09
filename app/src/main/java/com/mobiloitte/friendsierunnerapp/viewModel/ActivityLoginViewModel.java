package com.mobiloitte.friendsierunnerapp.viewModel;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;

import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.activity.ActivityViewModel;
import com.mobiloitte.friendsierunnerapp.util.ActivityController;
import com.mobiloitte.friendsierunnerapp.util.RegexUtils;
import com.mobiloitte.friendsierunnerapp.util.StringUtils;
import com.mobiloitte.friendsierunnerapp.view.ActivityForgotPassword;
import com.mobiloitte.friendsierunnerapp.view.ActivityLandingPage;
import com.mobiloitte.friendsierunnerapp.view.ActivityLogin;
import com.mobiloitte.friendsierunnerapp.view.DashboardActivity;


public class ActivityLoginViewModel extends ActivityViewModel<ActivityLogin> implements View.OnClickListener, TextWatcher {

    private ActivityLogin activity;

    String password, email;

    public ActivityLoginViewModel(ActivityLogin activity) {
        super(activity);
        this.activity = activity;



        activity.getBinding().getStarted1.setOnClickListener(this);
        activity.getBinding().ivBack.setOnClickListener(this);
        activity.getBinding().tvClick.setOnClickListener(this);
        activity.getBinding().etPassword.addTextChangedListener(this);
        activity.getBinding().etEmail.addTextChangedListener(this);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.iv_back:
                ActivityController.startActivity(activity, ActivityLandingPage.class, true);
                break;
            case R.id.get_started1:
                if (checkValidation()) {
                    ActivityController.startActivity(activity, DashboardActivity.class, true);
                }
                break;

            case R.id.tvClick:
                ActivityController.startActivity(activity, ActivityForgotPassword.class, true);

                break;
            default:
                break;
        }
        switch (view.getId()) {
            case R.id.iv_back:
                ActivityController.startActivity(activity, ActivityLandingPage.class, true);
                break;
            case R.id.get_started1:
                if (checkValidation()) {
                    ActivityController.startActivity(activity, DashboardActivity.class, true);
                }
                break;

            case R.id.tvClick:
                ActivityController.startActivity(activity, ActivityForgotPassword.class, true);

                break;
            default:
                break;

        }
        }

        @Override
        public void onBackPressed () {


            ActivityController.startActivity(activity, ActivityLandingPage.class, true);


        }

        private boolean checkValidation () {
            clearAll();

            if (StringUtils.isBlank(activity.getBinding().etEmail.getText().toString())) {

                password = activity.getBinding().etPassword.getText().toString();
                email = activity.getBinding().etEmail.getText().toString();

                if (StringUtils.isBlank(activity.getBinding().etEmail.getText().toString())) {

                    activity.getBinding().etEmail.requestFocus();
                    activity.getBinding().tvEmailError.setVisibility(View.VISIBLE);
                    activity.getBinding().tvEmailError.setText(R.string.enter_email);
                    return false;
                } else if (!RegexUtils.isValidEmail(activity.getBinding().etEmail.getText().toString())) {
                    activity.getBinding().etEmail.requestFocus();
                    activity.getBinding().tvEmailError.setVisibility(View.VISIBLE);
                    activity.getBinding().tvEmailError.setText(R.string.enter_valid_email);
                    return false;


                } else if (StringUtils.isBlank(activity.getBinding().etPassword.getText().toString())) {
                    activity.getBinding().etPassword.requestFocus();
                    activity.getBinding().tvPassswordError.setVisibility(View.VISIBLE);
                    activity.getBinding().tvPassswordError.setText(R.string.enter_password);
                    return false;


                }
                if (activity.getBinding().etPassword.getText().toString().length() >= 8) {
                } else {
                    activity.getBinding().etPassword.requestFocus();
                    activity.getBinding().tvPassswordError.setVisibility(View.VISIBLE);
                    activity.getBinding().tvPassswordError.setText(R.string.enter_password_valis);
                    return false;
                }


            } else if (StringUtils.isBlank(activity.getBinding().etPassword.getText().toString())) {
                activity.getBinding().etPassword.requestFocus();
                activity.getBinding().tvPassswordError.setVisibility(View.VISIBLE);
                activity.getBinding().tvPassswordError.setText(R.string.enter_password);
                return false;
//        } else if (!RegexUtils.ValidPassword(activity.getBinding().etPassword.getText().toString())) {
//            activity.getBinding().etPassword.requestFocus();
//            activity.getBinding().tvPassswordError.setVisibility(View.VISIBLE);
//            activity.getBinding().tvPassswordError.setText(R.string.password_contain_uppercase);
//            return false;
//        }
            }

            return true;
        }

        private void clearAll () {

            activity.getBinding().tvEmailError.setVisibility(View.GONE);
            activity.getBinding().tvPassswordError.setVisibility(View.GONE);


        }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        activity.getBinding().tvEmailError.setVisibility(View.GONE);
        activity.getBinding().tvPassswordError.setVisibility(View.GONE);
    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (!RegexUtils.isValidEmail(activity.getBinding().etEmail.getText().toString())) {
            activity.getBinding().tvEmailError.setVisibility(View.VISIBLE);
            activity.getBinding().tvEmailError.setText(R.string.enter_valid_email);

        } else if (activity.getBinding().etPassword.getText().toString().length() >= 8) {
            activity.getBinding().tvPassswordError.setVisibility(View.GONE);
            activity.getBinding().tvPassswordError.setText(R.string.enter_password_8);
        } else {
            activity.getBinding().tvPassswordError.setVisibility(View.VISIBLE);
            activity.getBinding().tvPassswordError.setText(R.string.enter_password_8);

        }
           if (!RegexUtils.ValidPassword(activity.getBinding().etPassword.getText().toString())) {
            activity.getBinding().tvPassswordError.setVisibility(View.VISIBLE);
            activity.getBinding().tvPassswordError.setText(R.string.password_contain_uppercase);


        }
    }
}
