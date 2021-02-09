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
import com.mobiloitte.friendsierunnerapp.view.ActivityLogin;
import com.mobiloitte.friendsierunnerapp.view.ActivityPasswordRecOvered;


public class ActivityForgotPasswordViewModel extends ActivityViewModel<ActivityForgotPassword> implements  View.OnClickListener, TextWatcher {
String email;
private ActivityForgotPassword activity;

    public ActivityForgotPasswordViewModel(final ActivityForgotPassword activity) {

        super(activity);
        this.activity=activity;
        activity.getBinding().btnReset.setOnClickListener(this);
        activity.getBinding().ivForgotBackArrow.setOnClickListener(this);
        activity.getBinding().ivForgotBackArrow.setOnClickListener(this);

      /*  activity.getBinding().etForgotEmail.addTextChangedListener(this);*/
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        activity.getBinding().etForgotEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (RegexUtils.isValidEmail(activity.getBinding().etForgotEmail.getText().toString())) {
                    activity.getBinding().tvEmailError.setText(R.string.enter_valid_email);
                    activity.getBinding().tvEmailError.setVisibility(View.GONE);
                }else {
                    activity.getBinding().tvEmailError.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        activity.getBinding().etForgotEmail.addTextChangedListener(this);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnReset:
                if(checkValidation()){

                    ActivityController.startActivity(activity, ActivityPasswordRecOvered.class,true);
                }
                break;


              case  R.id.iv_forgot_back_arrow:
                  ActivityController.startActivity(activity, ActivityLogin.class,true);
            break;



                default:break;
        }

    }
    private boolean checkValidation() {
        clearAll();
        email = activity.getBinding().etForgotEmail.getText().toString().trim();


        if (StringUtils.isBlank(email)) {
            activity.getBinding().etForgotEmail.requestFocus();
            activity.getBinding().tvEmailError.setText(R.string.enter_email);
            activity.getBinding().tvEmailError.setVisibility(View.VISIBLE);
            return false;
        } else if (!RegexUtils.isValidEmail(email)) {
            activity.getBinding().etForgotEmail.requestFocus();
            activity.getBinding().tvEmailError.setText(R.string.enter_valid_email);
            activity.getBinding().tvEmailError.setVisibility(View.VISIBLE);
            return false;
        }
        return true;
    }

    private void clearAll() {
        activity.getBinding().tvEmailError.setVisibility(View.GONE);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        if (RegexUtils.isValidEmail(activity.getBinding().etForgotEmail.getText().toString())) {
            activity.getBinding().tvEmailError.setText(R.string.enter_valid_email);
            activity.getBinding().tvEmailError.setVisibility(View.VISIBLE);
        }else {
            activity.getBinding().tvEmailError.setVisibility(View.GONE);
        }

        activity.getBinding().tvEmailError.setVisibility(View.GONE);

    }

    @Override
    public void afterTextChanged(Editable editable) {
    }


    @Override
    public void onBackPressed() {
        ActivityController.startActivity(activity, ActivityLogin.class,true);

    }
}

