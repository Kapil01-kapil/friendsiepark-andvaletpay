package com.mobiloitte.friendsierunnerapp.viewModel;


import android.app.Activity;
import android.view.WindowManager;

import com.google.gson.JsonObject;
import com.mobiloitte.friendsierunnerapp.api.ApiCallBack;
import com.mobiloitte.friendsierunnerapp.api.ApiManager;
import com.mobiloitte.friendsierunnerapp.api.ApiResponseListener;
import com.mobiloitte.friendsierunnerapp.api.response.GetProfileResponse.GetProfileMainResponse;
import com.mobiloitte.friendsierunnerapp.base.fragment.FragmentViewModel;
import com.mobiloitte.friendsierunnerapp.databinding.ActivityProfileBinding;
import com.mobiloitte.friendsierunnerapp.util.AppConstant;
import com.mobiloitte.friendsierunnerapp.util.CommonUtils;
import com.mobiloitte.friendsierunnerapp.util.ProgressDialogUtils;
import com.mobiloitte.friendsierunnerapp.util.SavedPrefManager;
import com.mobiloitte.friendsierunnerapp.util.ToastUtils;
import com.mobiloitte.friendsierunnerapp.view.FragmentDashBoard;
import com.mobiloitte.friendsierunnerapp.view.FragmentEditProfile;
import com.squareup.picasso.Picasso;

public class FragmentEditProfileViewModel extends FragmentViewModel<FragmentEditProfile, ActivityProfileBinding> {
    private FragmentEditProfile fragment;
    public Activity activity;



    public FragmentEditProfileViewModel(FragmentEditProfile fragment, ActivityProfileBinding binding) {
        super(fragment, binding);
        this.activity = getActivity();
        this.fragment = fragment;



        GetprofileApi();




        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    @Override
    protected void initialize(ActivityProfileBinding binding) {
       // GetprofileApi();

    }

    private void GetprofileApi() {
        if (CommonUtils.isOnline(activity)){
            ProgressDialogUtils.show(activity, AppConstant.PLEASE_WAIT);
            ApiManager apiManager=new ApiManager(activity);
            ApiCallBack<GetProfileMainResponse> callBack=new ApiCallBack<>(new ApiResponseListener<GetProfileMainResponse>() {
                @Override
                public void onApiSuccess(GetProfileMainResponse response, String apiName) {
                    ProgressDialogUtils.dismiss();
                    if (response != null) {

                   String fname=response.getResult().getData().getFirstName();
                   String lname=response.getResult().getData().getLastName();
                  fragment.getBinding().tvName.setText(fname+" "+lname);

                 String email =response.getResult().getData().getEmailAddress();
                 fragment.getBinding().tvEmail.setText(email);

                 String phone=response.getResult().getData().getPhoneNumber();
                 fragment.getBinding().tvPhoneNo.setText(phone);

                 String imagePath=response.getResult().getData().getUserImage();

                        Picasso.with(activity).load(imagePath).into(fragment.getBinding().profile);



                        ToastUtils.showToastShort(activity, response.getMessage());
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
            },AppConstant.USER_ID,activity);
            JsonObject jsonObject=new JsonObject();
            jsonObject.addProperty("user_id", SavedPrefManager.getStringPreferences(activity,AppConstant.USER_ID));
            apiManager.GetProfile(callBack,jsonObject);
        }else {
            ToastUtils.showToastShort(activity, AppConstant.CHECK_INTERNET);
        }
    }




    /*private void ProfileApi() {
        if (CommonUtils.isOnline(activity)) {
            ProgressDialogUtils.show(activity, AppConstant.PLEASE_WAIT);
            ApiManager apiManager = new ApiManager(activity);
            ApiCallBack<GetProfileMainResponse> callBack = new ApiCallBack<>(new ApiResponseListener<GetProfileMainResponse>(){

                @Override
                public void onApiSuccess(GetProfileMainResponse response, String apiName) {
                    ProgressDialogUtils.dismiss();
                    if (response != null) {

                        fname=response.getResult().getData().getFirstName();
                        lname=response.getResult().getData().getLastName();
                        fragment.getBinding().nameProfile.setText(fname+" "+lname);
//fragment.getBinding().lastnameProfile.setText(lname);
                        email= response.getResult().getData().getEmailAddress();
                        fragment.getBinding().emailProfile.setText(email);
                        String phone=response.getResult().getData().getPhoneNumber();
                        fragment.getBinding().phoneProfile.setText(phone);






                        ToastUtils.showToastShort(activity, response.getMessage());
// SavedPrefManager.saveStringPreferences(activity, AppConstant.USER_ID,response.getResult().getData().getUserId());
//ActivityController.startActivity(activity, ActivityDashBoard.class,true);
                    }
                }
                @Override
                public void onApiError(String responses, String apiName) {

                    ProgressDialogUtils.dismiss();
                    LogUtils.LOGE(TAG, responses);
                }

                @Override
                public void onApiFailure(String failureMessage, String apiName) {

                    ProgressDialogUtils.dismiss();
                    LogUtils.LOGE(TAG, failureMessage);
                }
            },AppConstant.GET_PROFILE,activity);

            userId= HawkSaved.getString(AppConstant.USER_ID);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("user_id",userId);
            apiManager.profile(callBack, jsonObject);
        }else {
            ToastUtils.showToastShort(activity, AppConstant.CHECK_INTERNET);
        }
    }*/
}
