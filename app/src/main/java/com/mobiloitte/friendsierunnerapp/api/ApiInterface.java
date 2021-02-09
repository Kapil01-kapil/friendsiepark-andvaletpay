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

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public  interface ApiInterface {
    Context context = null;

      @POST("send/otp")
    Call<SendOtpResponse> sendotp(@Body JsonObject jsonObject);

      @POST("verify/otp")
    Call<VerifyMobileNoResponse> verifyotp(@Body JsonObject jsonObject);


      @GET("privacy/policy")
    Call<PrivacyPloicyMainResponce> getPolicy();


   @POST("parking-history")
    Call<ParkingHistoryMainResponce> parkinghistory(@Body JsonObject jsonObject);

    @POST("logout")
    Call<LogoutResponse> logout(@Body JsonObject jsonObject);


    @POST("get/profile")
    Call<GetProfileMainResponse>getprofile(@Body JsonObject jsonObject);

    @POST("dashboard")
    Call<DashboardMainResponse>dashbord(@Body JsonObject jsonObject);

    @POST("invite")
    Call<AddClientResponse>invite(@Body JsonObject jsonObject);

    @POST("client-info")
    Call<ClientInformationMainResponse>clientinformation(@Body JsonObject jsonObject);

    @POST("get-providers")
    Call<GetProviderMainResponse>ProviderInformation(@Body JsonObject jsonObject);

    @POST("runner/tip")
    Call<RunnerTipResponse> getRunnerTipResponse(@Body JsonObject jsonObject);

    @POST("invite")
    Call<InviteResponse> getInvite(@Body JsonObject jsonObject);
}

