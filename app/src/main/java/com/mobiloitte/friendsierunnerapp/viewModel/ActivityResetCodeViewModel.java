package com.mobiloitte.friendsierunnerapp.viewModel;


import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.activity.ActivityViewModel;
import com.mobiloitte.friendsierunnerapp.util.ActivityController;
import com.mobiloitte.friendsierunnerapp.util.RegexUtils;
import com.mobiloitte.friendsierunnerapp.util.StringUtils;
import com.mobiloitte.friendsierunnerapp.view.ActivityForgotPassword;
import com.mobiloitte.friendsierunnerapp.view.ActivityLogin;
import com.mobiloitte.friendsierunnerapp.view.ActivityPasswordRecOvered;
import com.mobiloitte.friendsierunnerapp.view.ActivityResetCode;

public class ActivityResetCodeViewModel extends ActivityViewModel<ActivityResetCode> implements View.OnClickListener, TextWatcher {


    private ActivityResetCode activity;
    String password,confirmpassword;
    public ActivityResetCodeViewModel(ActivityResetCode activity) {
        super(activity);
        this.activity=activity;

        activity.getBinding().ivBack.setOnClickListener(this);
        activity.getBinding().btLogin.setOnClickListener(this);
        activity.getBinding().etPassword.addTextChangedListener(this);
        activity.getBinding().etConfirmPassword.addTextChangedListener(this);
        activity.getBinding().etForgotEmail.addTextChangedListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btLogin:
if(checkValidation()){
    ActivityController.startActivity(activity, ActivityLogin.class,true);

}
break;

            case R.id.ivBack:
                ActivityController.startActivity(activity, ActivityForgotPassword.class,true);
                break;
                default:break;
        }

    }


    @Override
    public void onBackPressed() {


        ActivityController.startActivity(activity, ActivityForgotPassword.class,true);

        ActivityController.startActivity(activity, ActivityPasswordRecOvered.class,true);


    }

    private boolean checkValidation() {
        clearAll();

        password = activity.getBinding().etPassword.getText().toString();
        confirmpassword = activity.getBinding().etConfirmPassword.getText().toString();


        if (StringUtils.isBlank(activity.getBinding().etForgotEmail.getText().toString())) {
            activity.getBinding().etForgotEmail.requestFocus();
            activity.getBinding().tvEmailError.setVisibility(View.VISIBLE);
            activity.getBinding().tvEmailError.setText(R.string.enter_email);
            return false;
        } else if (!RegexUtils.isValidEmail(activity.getBinding().etForgotEmail.getText().toString())) {
            activity.getBinding().etForgotEmail.requestFocus();
            activity.getBinding().tvEmailError.setVisibility(View.VISIBLE);
            activity.getBinding().tvEmailError.setText(R.string.enter_valid_email);
            return false;


        } else if (StringUtils.isBlank(activity.getBinding().etPassword.getText().toString())) {
            activity.getBinding().etPassword.requestFocus();
            activity.getBinding().tvPassswordError.setVisibility(View.VISIBLE);
            activity.getBinding().tvPassswordError.setText(R.string.enter_password);
            return false;
        } else if (!RegexUtils.ValidPassword(activity.getBinding().etPassword.getText().toString())) {
            activity.getBinding().etPassword.requestFocus();
            activity.getBinding().tvPassswordError.setVisibility(View.VISIBLE);
            activity.getBinding().tvPassswordError.setText(R.string.password_contain_uppercase);
            return false;
        } else if (StringUtils.isBlank(activity.getBinding().etConfirmPassword.getText().toString())) {
            activity.getBinding().etConfirmPassword.requestFocus();
            activity.getBinding().tvConfirmPassswordError.setVisibility(View.VISIBLE);
            activity.getBinding().tvConfirmPassswordError.setText(R.string.enter_confirm_password);
            return false;
        } else if (!activity.getBinding().etConfirmPassword.getText().toString().equals(activity.getBinding().etPassword.getText().toString())) {
            activity.getBinding().etConfirmPassword.requestFocus();
            activity.getBinding().tvConfirmPassswordError.setVisibility(View.VISIBLE);
            activity.getBinding().tvConfirmPassswordError.setText(activity.getString(R.string.password_changepassword_same));
            return false;
        }

        return true;

    }

    private void clearAll() {
        activity.getBinding().tvEmailError.setVisibility(View.GONE);
        activity.getBinding().tvPassswordError.setVisibility(View.GONE);
        activity.getBinding().tvConfirmPassswordError.setVisibility(View.GONE);
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        activity.getBinding().tvEmailError.setVisibility(View.GONE);
        activity.getBinding().tvPassswordError.setVisibility(View.GONE);
        activity.getBinding().tvConfirmPassswordError.setVisibility(View.GONE);
    }

    @Override
    public void afterTextChanged(Editable editable) {

        password = activity.getBinding().etPassword.getText().toString();
        confirmpassword = activity.getBinding().etConfirmPassword.getText().toString();

        if (!RegexUtils.isValidEmail(activity.getBinding().etForgotEmail.getText().toString())) {
            activity.getBinding().tvEmailError.setVisibility(View.VISIBLE);
            activity.getBinding().tvEmailError.setText(R.string.enter_valid_email);
        } else if (StringUtils.isBlank(activity.getBinding().etPassword.getText().toString())) {
            activity.getBinding().tvPassswordError.setVisibility(View.VISIBLE);
            activity.getBinding().tvPassswordError.setText(R.string.enter_password);
        } else if (!RegexUtils.ValidPassword(activity.getBinding().etPassword.getText().toString())) {
            activity.getBinding().tvPassswordError.setVisibility(View.VISIBLE);
            activity.getBinding().tvPassswordError.setText(R.string.password_contain_uppercase);
        } else if (!activity.getBinding().etConfirmPassword.getText().toString().equals(activity.getBinding().etPassword.getText().toString())) {
            activity.getBinding().tvConfirmPassswordError.setVisibility(View.VISIBLE);
            activity.getBinding().tvConfirmPassswordError.setText(activity.getString(R.string.password_changepassword_same));
        }

    }
}
