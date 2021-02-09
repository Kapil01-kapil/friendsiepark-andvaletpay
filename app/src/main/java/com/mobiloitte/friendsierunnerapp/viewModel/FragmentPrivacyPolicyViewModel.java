package com.mobiloitte.friendsierunnerapp.viewModel;

import android.app.Activity;
import android.view.WindowManager;



import com.mobiloitte.friendsierunnerapp.api.ApiCallBack;

import com.mobiloitte.friendsierunnerapp.api.ApiManager;
import com.mobiloitte.friendsierunnerapp.api.ApiResponseListener;
import com.mobiloitte.friendsierunnerapp.api.response.PrivacyPolicy.PrivacyPloicyMainResponce;
import com.mobiloitte.friendsierunnerapp.base.fragment.FragmentViewModel;
import com.mobiloitte.friendsierunnerapp.databinding.FragmentPrivacyPolicyBinding;

import com.mobiloitte.friendsierunnerapp.util.CommonUtils;
import com.mobiloitte.friendsierunnerapp.util.ProgressDialogUtils;
import com.mobiloitte.friendsierunnerapp.util.ToastUtils;

import com.mobiloitte.friendsierunnerapp.view.FragmentPrivacy;

public class FragmentPrivacyPolicyViewModel extends FragmentViewModel<FragmentPrivacy, FragmentPrivacyPolicyBinding> {

    private FragmentPrivacy fragment;
    public Activity activity;
    public FragmentPrivacyPolicyViewModel(FragmentPrivacy fragment, FragmentPrivacyPolicyBinding binding) {
        super(fragment, binding);
        this.activity = getActivity();
        this.fragment = fragment;



        getPrivacyPolicyApi();
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected void initialize(FragmentPrivacyPolicyBinding binding) {

    }

    private void getPrivacyPolicyApi() {
        if (CommonUtils.isOnline(activity)){
            ProgressDialogUtils.show(activity);
            ApiManager apiManager= new ApiManager(activity);

            ApiCallBack<PrivacyPloicyMainResponce> callBack=new ApiCallBack<>(new ApiResponseListener<PrivacyPloicyMainResponce>() {
                @Override

                public void onApiSuccess(PrivacyPloicyMainResponce response, String apiName) {
                    ProgressDialogUtils.dismiss();

                   /* if(response.getResponseCode()==200){*/

                    ToastUtils.showToastShort(activity,response.getMessage());
                    getBinding().tvText.setText(response.getResult().getData().getDescription());

                }
                /*else{
                    ToastUtils.showToastShort(activity,response.getMessage());
                    }*/
               /* }*/

                @Override
                public void onApiError(String responses, String apiName) {
                    ToastUtils.showToastShort(activity,responses);
                 ProgressDialogUtils.dismiss();
                }

                @Override
                public void onApiFailure(String failureMessage, String apiName) {
                 ProgressDialogUtils.dismiss();
                 ToastUtils.showToastShort(activity,failureMessage);
                }
            },"",activity);
            apiManager.getPolicy(callBack);


        }else {

        }

    }



   /* private void getPrivacyPolicyApi() {
        if (CommonUtils.isOnline(activity)){
            ProgressDialogUtils.show(activity);
            ApiManager apiManager= new ApiManager(activity);

            ApiCallBack<PrivacyPloicyMainResponce> callBack=new ApiCallBack<>(new ApiResponseListener<PrivacyPloicyMainResponce>() {
                @Override

                public void onApiSuccess(PrivacyPloicyMainResponce response, String apiName) {
                    ProgressDialogUtils.dismiss();

                   *//* if(response.getResponseCode()==200){*//*

                    ToastUtils.showToastShort(activity,response.getMessage());
                    getBinding().tvText.setText(response.getResult().getData().getDescription());

                }
                *//*else{
                    ToastUtils.showToastShort(activity,response.getMessage());
                    }*//*
               *//* }*//*

                @Override
                public void onApiError(String responses, String apiName) {
                    ToastUtils.showToastShort(activity,responses);
                 ProgressDialogUtils.dismiss();
                }

                @Override
                public void onApiFailure(String failureMessage, String apiName) {
                 ProgressDialogUtils.dismiss();
                 ToastUtils.showToastShort(activity,failureMessage);
                }
            },"",activity);
            apiManager.getPolicy(callBack);


        }else {

        }

    }
*/


}
