package com.mobiloitte.friendsierunnerapp.viewModel;

import android.app.ProgressDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

import com.google.gson.JsonObject;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.api.ApiCallBack;
import com.mobiloitte.friendsierunnerapp.api.ApiManager;
import com.mobiloitte.friendsierunnerapp.api.ApiResponseListener;
import com.mobiloitte.friendsierunnerapp.api.response.SendOtpResponse;
import com.mobiloitte.friendsierunnerapp.base.activity.ActivityViewModel;
import com.mobiloitte.friendsierunnerapp.util.ActivityController;
import com.mobiloitte.friendsierunnerapp.util.AppConstant;
import com.mobiloitte.friendsierunnerapp.util.CommonUtils;
import com.mobiloitte.friendsierunnerapp.util.LogUtils;
import com.mobiloitte.friendsierunnerapp.util.ProgressDialogUtils;
import com.mobiloitte.friendsierunnerapp.util.LogUtils;
import com.mobiloitte.friendsierunnerapp.util.ProgressDialogUtils;
import com.mobiloitte.friendsierunnerapp.util.RegexUtils;
import com.mobiloitte.friendsierunnerapp.util.SavedPrefManager;
import com.mobiloitte.friendsierunnerapp.util.StringUtils;
import com.mobiloitte.friendsierunnerapp.util.ToastUtils;
import com.mobiloitte.friendsierunnerapp.view.ActivityEnterCode;
import com.mobiloitte.friendsierunnerapp.view.ActivityLandingPage;
import com.mobiloitte.friendsierunnerapp.view.ActivityLogin;

public class ActivityLandingPageViewModel extends ActivityViewModel<ActivityLandingPage> implements View.OnClickListener, TextWatcher {
    String voucherPINLength;
    private ActivityLandingPage activity;
    private int keyDel = 1;





    private static final String TAG = ActivityLandingPageViewModel.class.getSimpleName();










    public ActivityLandingPageViewModel(final ActivityLandingPage activity) {
        super(activity);
        this.activity = activity;
//        activity.getBinding().tvLogin.setOnClickListener(this);
        activity.getBinding().tvLogin.setOnClickListener(this);
        activity.getBinding().btnGetstarted.setOnClickListener(this);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activity.getBinding().etText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                voucherPINLength = activity.getBinding().etText.getText().toString();
                activity.getBinding().etText.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_DEL)
                            keyDel = 1;
                        return false;
                    }
                });
                if (keyDel == 0) {
                    int len = activity.getBinding().etText.getText().length();
                    if (len == 3) {
                        activity.getBinding().etText.setText(activity.getBinding().etText.getText() + "-");
                        activity.getBinding().etText.setSelection(activity.getBinding().etText.getText().length());
                    } else if (len == 7) {
                        activity.getBinding().etText.setText(activity.getBinding().etText.getText() + "-");
                        activity.getBinding().etText.setSelection(activity.getBinding().etText.getText().length());
//                    } else if (len == 11) {
//                        activity.getBinding().etText.setText(activity.getBinding().etText.getText() + "-");
//                        activity.getBinding().etText.setSelection(activity.getBinding().etText.getText().length());
//                    } else {
                    }
                } else {
                    keyDel = 0;
                }
                if (voucherPINLength == null || voucherPINLength == "" || voucherPINLength.length() == 19) {
                    activity.getBinding().tvPhoneError.setVisibility(View.GONE);
                    //CommonUtils.savePreferencesString(activity, AppConstant.APP_Voucher, voucherPINLength);
                } else {
                    //activity.getBinding().tvPhoneError.ivError.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                activity.getBinding().tvPhoneError.setVisibility(View.GONE);
            }
        });



    }







    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvLogin:

                ActivityController.startActivity(activity, ActivityLogin.class, true);

                break;


            case R.id.btnGetstarted:

                if (checkValidation()) {
                    sendOtpApi();
                    // ActivityController.startActivity(activity, ActivityEnterCode.class, true);
                }
                break;

            default:
                break;
        }
    }



    private void sendOtpApi() {
        if (CommonUtils.isOnline(activity)) {
            ProgressDialogUtils.show(activity, AppConstant.PLEASE_WAIT);
            ApiManager apiManager= new ApiManager(activity);
           ApiCallBack<SendOtpResponse> callBack = new ApiCallBack<>(new ApiResponseListener<SendOtpResponse>() {
               @Override
               public void onApiSuccess(SendOtpResponse response, String apiName) {
                   ProgressDialogUtils.dismiss();
                   if (response.getResult() != null) {
                       ToastUtils.showToastShort(activity, response.getMessage());
                       SavedPrefManager.saveStringPreferences(activity, AppConstant.OTP, response.getResult().getOtp());
                       SavedPrefManager.saveStringPreferences(activity, AppConstant.PHONE_NO, response.getResult().getPhoneNumber());
                       ActivityController.startActivity(activity, ActivityEnterCode.class, true);
                   }
               }
               @Override
               public void onApiError(String responses, String apiName) {
                   ProgressDialogUtils.dismiss();
                   ToastUtils.showToastShort(activity,responses);
               }

               @Override
               public void onApiFailure(String failureMessage, String apiName) {
                   ProgressDialogUtils.dismiss();
                   ToastUtils.showToastShort(activity,failureMessage);

               }
           },AppConstant.OTP_VERIFY,activity);
           JsonObject jsonObject= new JsonObject();
           jsonObject.addProperty("phone_number",activity.getBinding().etText.getText().toString());
           apiManager.sendOtpApi(callBack,jsonObject);

        }else {
            ToastUtils.showToastShort(activity,AppConstant.CHECK_INTERNET);
        }





    }







    /*@Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvLogin:

                ActivityController.startActivity(activity, ActivityLogin.class, true);

                break;


            case R.id.btnGetstarted:

                if (checkValidation()) {
                    sendOtpApi();
                    // ActivityController.startActivity(activity, ActivityEnterCode.class, true);
                }
                break;

            default:
                break;
        }
    }

*/

    /*private void sendOtpApi() {
        if (CommonUtils.isOnline(activity)) {
            ProgressDialogUtils.show(activity, AppConstant.PLEASE_WAIT);
            ApiManager apiManager= new ApiManager(activity);
           ApiCallBack<SendOtpResponse> callBack = new ApiCallBack<>(new ApiResponseListener<SendOtpResponse>() {
               @Override
               public void onApiSuccess(SendOtpResponse response, String apiName) {
                   ProgressDialogUtils.dismiss();
                   ToastUtils.showToastShort(activity,response.getMessage());
                   SavedPrefManager.saveStringPreferences(activity,AppConstant.OTP,response.getResult().getOtp());
                  SavedPrefManager.saveStringPreferences(activity,AppConstant.PHONE_NO,response.getResult().getPhoneNumber());
                   ActivityController.startActivity(activity, ActivityEnterCode.class, true);
              }

               @Override
               public void onApiError(String responses, String apiName) {
                   ProgressDialogUtils.dismiss();
                   ToastUtils.showToastShort(activity,responses);
               }

               @Override
               public void onApiFailure(String failureMessage, String apiName) {
                   ProgressDialogUtils.dismiss();
                   ToastUtils.showToastShort(activity,failureMessage);

               }
           },AppConstant.OTP_VERIFY,activity);
           JsonObject jsonObject= new JsonObject();
           jsonObject.addProperty("phone_number",activity.getBinding().etText.getText().toString());
           apiManager.sendOtpApi(callBack,jsonObject);

        }else {
            ToastUtils.showToastShort(activity,AppConstant.CHECK_INTERNET);
        }
    }


*/



    private boolean checkValidation() {


        if (StringUtils.isBlank(activity.getBinding().etText.getText().toString())) {
            activity.getBinding().etText.requestFocus();
            activity.getBinding().tvPhoneError.setVisibility(View.VISIBLE);
            activity.getBinding().tvPhoneError.setText(R.string.enter_phone_number);

            return false;
        } else if (!RegexUtils.isValidMobileNumber(activity.getBinding().etText.getText().toString())) {
            activity.getBinding().etText.requestFocus();
            activity.getBinding().tvPhoneError.setVisibility(View.VISIBLE);
            activity.getBinding().tvPhoneError.setText(R.string.valid_phone_number);

            return false;


        }

        return true;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (StringUtils.isBlank(activity.getBinding().etText.getText().toString())) {
            activity.getBinding().tvPhoneError.setVisibility(View.VISIBLE);
            activity.getBinding().tvPhoneError.setText(R.string.enter_phone_number);


        } else if (!RegexUtils.isValidMobileNumber(activity.getBinding().etText.getText().toString())) {
            activity.getBinding().tvPhoneError.setVisibility(View.VISIBLE);
            activity.getBinding().tvPhoneError.setText(R.string.valid_phone_number);
        }
    }


}
