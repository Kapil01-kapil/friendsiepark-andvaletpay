package com.mobiloitte.friendsierunnerapp.viewModel;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.google.gson.JsonObject;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.api.ApiCallBack;
import com.mobiloitte.friendsierunnerapp.api.ApiManager;
import com.mobiloitte.friendsierunnerapp.api.ApiResponseListener;
import com.mobiloitte.friendsierunnerapp.api.response.VerifyMobileNoResponse;
import com.mobiloitte.friendsierunnerapp.base.activity.ActivityViewModel;
import com.mobiloitte.friendsierunnerapp.util.ActivityController;
import com.mobiloitte.friendsierunnerapp.util.AppConstant;
import com.mobiloitte.friendsierunnerapp.util.CommonUtils;
import com.mobiloitte.friendsierunnerapp.util.ProgressDialogUtils;
import com.mobiloitte.friendsierunnerapp.util.SavedPrefManager;
import com.mobiloitte.friendsierunnerapp.util.StringUtils;
import com.mobiloitte.friendsierunnerapp.util.ToastUtils;
import com.mobiloitte.friendsierunnerapp.view.ActivityEnterCode;
import com.mobiloitte.friendsierunnerapp.view.ActivityLandingPage;
import com.mobiloitte.friendsierunnerapp.view.DashboardActivity;


public class ActivityEnterCodeViewModel extends ActivityViewModel<ActivityEnterCode> implements View.OnClickListener, TextWatcher {
    private ActivityEnterCode activity;
    String code;

    public ActivityEnterCodeViewModel(ActivityEnterCode activity) {
        super(activity);
        this.activity = activity;
        SavedPrefManager.getStringPreferences(activity,AppConstant.PHONE_NO);
        String otp = SavedPrefManager.getStringPreferences(activity, AppConstant.OTP);
        activity.getBinding().etCode.setText(otp);

        activity.getBinding().tvVerifyCode.setOnClickListener(this);
        activity.getBinding().ivBackEditPhoneno.setOnClickListener(this);
        activity.getBinding().tvVerifyCode.setOnClickListener(this);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activity.getBinding().tvEditNumber.setOnClickListener(this);
        activity.getBinding().tvResendCode.setOnClickListener(this);
        activity.getBinding().etCode.addTextChangedListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_verify_code:
                if (checkValidation()) {
                    //ActivityController.startActivity(activity, DashboardActivity.class, true);
                    VerifyMobileOtp();
                }
                break;

            case R.id.tvEditNumber:
                ActivityController.startActivity(activity, ActivityLandingPage.class, true);
                break;

            case R.id.iv_back_edit_phoneno:
                ActivityController.startActivity(activity, ActivityLandingPage.class, true);
                break;

            default:
                break;
        }

    }


    private void VerifyMobileOtp() {
        if (CommonUtils.isOnline(activity)) {
            ProgressDialogUtils.show(activity, AppConstant.PLEASE_WAIT);
            ApiManager apiManager = new ApiManager(activity);
            ApiCallBack<VerifyMobileNoResponse> callBack = new ApiCallBack<>(new ApiResponseListener<VerifyMobileNoResponse>() {
                @Override
                public void onApiSuccess(VerifyMobileNoResponse response, String apiName) {
                    ProgressDialogUtils.dismiss();
                    if (response.getResponseCode()==200){

                        ToastUtils.showToastShort(activity, response.getMessage());
                        SavedPrefManager.saveStringPreferences(activity, AppConstant.USER_ID, response.getResult().getUserId());
                        SavedPrefManager.saveStringPreferences(activity, AppConstant.SERVICE_PROVIDER_ID, response.getResult().getService_provider_id());
                        SavedPrefManager.savePreferenceBoolean(activity,AppConstant.IS_LOGIN,true);

                        ActivityController.startActivity(activity, DashboardActivity.class, true);
                    }
                }

                @Override
                public void onApiError(String responses, String apiName) {
                    ProgressDialogUtils.dismiss();
                    ToastUtils.showToastShort(activity, responses);

                }

                @Override
                public void onApiFailure(String failureMessage, String apiName) {
                    ProgressDialogUtils.dismiss();
                    ToastUtils.showToastShort(activity, failureMessage);

                }
            }, AppConstant.MOBILE_OTP_VERIFY, activity);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("otp", activity.getBinding().etCode.getText().toString());
            jsonObject.addProperty("phone_number",SavedPrefManager.getStringPreferences(activity,AppConstant.PHONE_NO));
            apiManager.verifymobile(callBack, jsonObject);

        } else {
            ToastUtils.showToastShort(activity, AppConstant.CHECK_INTERNET);
        }
    }


    @Override
    public void onBackPressed() {
        ActivityController.startActivity(activity, ActivityLandingPage.class, true);
    }


    private boolean checkValidation() {

        clearAll();
        code = activity.getBinding().etCode.getText().toString();
        if (StringUtils.isBlank(activity.getBinding().etCode.getText().toString())) {
            activity.getBinding().etCode.requestFocus();
            activity.getBinding().tvverifyCodeError.setVisibility(View.VISIBLE);
            activity.getBinding().tvverifyCodeError.setText("*Please enter code.");
            return false;
        } else if ((code.length() < 5)) {
            activity.getBinding().etCode.requestFocus();
            activity.getBinding().tvverifyCodeError.setVisibility(View.VISIBLE);
            activity.getBinding().tvverifyCodeError.setText("*Please enter full code.");

            return false;
        }

        return true;
    }


    private void clearAll() {
        activity.getBinding().tvverifyCodeError.setVisibility(View.GONE);

    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        activity.getBinding().tvverifyCodeError.setVisibility(View.GONE);

    }

    @Override
    public void afterTextChanged(Editable editable) {
        code = activity.getBinding().etCode.getText().toString();
        if ((code.length() < 5)) {
            activity.getBinding().tvverifyCodeError.setVisibility(View.VISIBLE);
            activity.getBinding().tvverifyCodeError.setText("*Please enter full code.");
        }
    }
}
