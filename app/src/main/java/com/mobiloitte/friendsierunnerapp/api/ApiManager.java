package com.mobiloitte.friendsierunnerapp.api;

import android.content.Context;

import com.google.gson.JsonObject;
import com.mobiloitte.friendsierunnerapp.api.response.AddClientResponse;
import com.mobiloitte.friendsierunnerapp.api.response.ClientInformationResponse.ClientInformationMainResponse;
import com.mobiloitte.friendsierunnerapp.api.response.DashboardResponse.DashboardMainResponse;
import com.mobiloitte.friendsierunnerapp.api.response.GetProfileResponse.GetProfileMainResponse;
import com.mobiloitte.friendsierunnerapp.api.response.GetProfileResponse.GetProfileMainResponse;
import com.mobiloitte.friendsierunnerapp.api.response.GetProviderResponse.GetProviderMainResponse;
import com.mobiloitte.friendsierunnerapp.api.response.InviteResponse;
import com.mobiloitte.friendsierunnerapp.api.response.LogoutResponse;
import com.mobiloitte.friendsierunnerapp.api.response.ParkingHistory.ParkingHistoryMainResponce;
import com.mobiloitte.friendsierunnerapp.api.response.PrivacyPolicy.PrivacyPloicyMainResponce;
import com.mobiloitte.friendsierunnerapp.api.response.RunnerTipResponse;
import com.mobiloitte.friendsierunnerapp.api.response.SendOtpResponse;
import com.mobiloitte.friendsierunnerapp.api.response.VerifyMobileNoResponse;


public class ApiManager extends ApiClient {


    private static ApiManager apiManager;
    private Context mContext;
    private String accessToken;

    public ApiManager(Context context) {
        super(context);
        mContext = context;

    }


    public static ApiManager getInstance(Context context) {
        if (apiManager == null) {
            apiManager = new ApiManager(context);
        }
        return apiManager;
    }

   public void sendOtpApi(ApiCallBack<SendOtpResponse> callBack , JsonObject jsonObject){
        ApiClient.current(mContext,false).sendotp(jsonObject).enqueue(callBack);
   }
   public void verifymobile(ApiCallBack<VerifyMobileNoResponse> callBack, JsonObject jsonObject){
        ApiClient.current(mContext,false).verifyotp(jsonObject).enqueue(callBack);
   }

   public void getPolicy(ApiCallBack<PrivacyPloicyMainResponce> callBack){
        ApiClient.current(mContext,false).getPolicy().enqueue(callBack);
   }

   public void parkingHistory(ApiCallBack<ParkingHistoryMainResponce> callBack, JsonObject jsonObject){
      ApiClient.current(mContext,false).parkinghistory(jsonObject).enqueue(callBack);
   }
    public void logout(ApiCallBack<LogoutResponse> callBack, JsonObject jsonObject){
        ApiClient.current(mContext,false).logout(jsonObject).enqueue(callBack);
    }

    public void GetProfile(ApiCallBack<GetProfileMainResponse> callBack, JsonObject jsonObject){
        ApiClient.current(mContext,false).getprofile(jsonObject).enqueue(callBack);
    }

    public void DashbordProfile(ApiCallBack<DashboardMainResponse> callBack, JsonObject jsonObject){
        ApiClient.current(mContext ,false).dashbord(jsonObject).enqueue(callBack);
    }

    public  void AddClient(ApiCallBack<AddClientResponse> callBack, JsonObject jsonObject){
        ApiClient.current(mContext,false).invite(jsonObject).enqueue(callBack);
    }

    public void clientInformation(ApiCallBack<ClientInformationMainResponse> callBack,JsonObject jsonObject){
        ApiClient.current(mContext,false).clientinformation(jsonObject).enqueue(callBack);
    }

    public void Provider(ApiCallBack<GetProviderMainResponse> callBack,JsonObject jsonObject) {
        ApiClient.current(mContext,false).ProviderInformation(jsonObject).enqueue(callBack);
    }


    public void getRunnerTipApi(ApiCallBack<RunnerTipResponse> callBack,JsonObject jsonObject){
        ApiClient.current(mContext,false).getRunnerTipResponse(jsonObject).enqueue(callBack);
    }

    public void getInviteRespone(ApiCallBack<InviteResponse> callBack,JsonObject jsonObject){
        ApiClient.current(mContext,false).getInvite(jsonObject).enqueue(callBack);
    }


}
