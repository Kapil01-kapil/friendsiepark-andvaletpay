package com.mobiloitte.friendsierunnerapp.viewModel;

import android.view.View;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.api.ApiCallBack;
import com.mobiloitte.friendsierunnerapp.api.ApiManager;
import com.mobiloitte.friendsierunnerapp.api.ApiResponseListener;
import com.mobiloitte.friendsierunnerapp.api.response.DashboardResponse.DashboardMainResponse;
import com.mobiloitte.friendsierunnerapp.api.response.InviteResponse;
import com.mobiloitte.friendsierunnerapp.base.activity.ActivityViewModel;
import com.mobiloitte.friendsierunnerapp.util.ActivityController;
import com.mobiloitte.friendsierunnerapp.util.AppConstant;
import com.mobiloitte.friendsierunnerapp.util.CommonUtils;
import com.mobiloitte.friendsierunnerapp.util.ProgressDialogUtils;
import com.mobiloitte.friendsierunnerapp.util.SavedPrefManager;
import com.mobiloitte.friendsierunnerapp.util.ToastUtils;
import com.mobiloitte.friendsierunnerapp.view.AddClientActivity;
import com.mobiloitte.friendsierunnerapp.view.DashboardActivity;
import com.squareup.picasso.Picasso;

public class ActivityClientViewModel extends ActivityViewModel<AddClientActivity>  {
    AddClientActivity activity;

    public ActivityClientViewModel(final AddClientActivity activity) {
        super(activity);
        this.activity=activity;

        initControl();
    }

    private void initControl() {
        activity.getBinding().ivBackEditPhoneno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityController.startActivity(activity, DashboardActivity.class,true);
            }
        });

        activity.getBinding().tvVerifyCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activity.getBinding().etPhoneNumber.getText().toString().length()>5){
                    inviteApi();
                }else {
                    ToastUtils.showToastLong(activity,"Please enter valid phone number");
                }
            }
        });

    }

    private void inviteApi(){
        if(CommonUtils.isOnline(activity)){
            ProgressDialogUtils.show(activity, AppConstant.PLEASE_WAIT);
            ApiManager apiManager= new ApiManager(activity);
            ApiCallBack<InviteResponse> callBack=new ApiCallBack<>(new ApiResponseListener<InviteResponse>() {
                @Override
                public void onApiSuccess(InviteResponse response, String apiName) {
                    ProgressDialogUtils.dismiss();
                    if(response!=null){

                        ToastUtils.showToastLong(activity,response.getMessage());
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

            },"Invite Api",activity);
            JsonObject jsonObject=new JsonObject();
            jsonObject.addProperty("phone_number",activity.getBinding().etPhoneNumber.getText().toString());
            apiManager.getInviteRespone(callBack,jsonObject);

        } else {
            ToastUtils.showToastLong(activity,"No Internet Connection");

        }


    }

}
