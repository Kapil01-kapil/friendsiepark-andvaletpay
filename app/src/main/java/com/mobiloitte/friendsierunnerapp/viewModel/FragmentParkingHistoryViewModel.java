package com.mobiloitte.friendsierunnerapp.viewModel;


import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.JsonObject;
import com.mobiloitte.friendsierunnerapp.Adapter.ParkingHistoryParentAdapter;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.api.ApiCallBack;
import com.mobiloitte.friendsierunnerapp.api.ApiManager;
import com.mobiloitte.friendsierunnerapp.api.ApiResponseListener;
import com.mobiloitte.friendsierunnerapp.api.response.GetProviderResponse.GetProviderMainResponse;
import com.mobiloitte.friendsierunnerapp.api.response.GetProviderResponse.GetProviderResultResponse;
import com.mobiloitte.friendsierunnerapp.api.response.ParkingHistory.ParkingHistoryDateResponce;
import com.mobiloitte.friendsierunnerapp.api.response.ParkingHistory.ParkingHistoryMainResponce;
import com.mobiloitte.friendsierunnerapp.base.fragment.FragmentViewModel;
import com.mobiloitte.friendsierunnerapp.databinding.ActivityParkingBinding;
import com.mobiloitte.friendsierunnerapp.util.AppConstant;
import com.mobiloitte.friendsierunnerapp.util.CommonUtils;
import com.mobiloitte.friendsierunnerapp.util.ProgressDialogUtils;
import com.mobiloitte.friendsierunnerapp.util.SavedPrefManager;
import com.mobiloitte.friendsierunnerapp.util.ToastUtils;
import com.mobiloitte.friendsierunnerapp.view.FragmentParkingHistory;

import java.util.ArrayList;
import java.util.List;

public class FragmentParkingHistoryViewModel extends FragmentViewModel<FragmentParkingHistory, ActivityParkingBinding> implements  android.widget.AdapterView.OnItemSelectedListener  {
    private List<String>list = new ArrayList<>();
    private FragmentParkingHistory fragment;
    private Spinner spinner;
    public Activity activity;

    public FragmentParkingHistoryViewModel(FragmentParkingHistory fragment, ActivityParkingBinding binding) {
        super(fragment, binding);
        this.activity = getActivity();
        this.fragment = fragment;
        parkingHistory();
        getprovider();
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /* setRecycler();*/
       addItemsOnSpinner2();

    }

    private void getprovider() {
        if(CommonUtils.isOnline(activity)){
            ProgressDialogUtils.show(activity);
            ApiManager apiManager =new ApiManager(activity);
            ApiCallBack<GetProviderMainResponse> callBack=new ApiCallBack<>(new ApiResponseListener<GetProviderMainResponse>() {
                @Override
                public void onApiSuccess(GetProviderMainResponse response, String apiName) {
                    ProgressDialogUtils.dismiss();

                    if(response.getResponseCode()==200){
                        ToastUtils.showToastShort(activity,response.getMessage());
                        SavedPrefManager.getStringPreferences(activity,AppConstant.USER_ID);
                        List<GetProviderResultResponse>resultResponses=response.getResult();

                        for(GetProviderResultResponse resultResponse:resultResponses){
                            list.add(resultResponse.getProviderName());
                        }
                    }

                }

                @Override
                public void onApiError(String responses, String apiName) {

                }

                @Override
                public void onApiFailure(String failureMessage, String apiName) {

                }
            },"",activity);
            JsonObject jsonObject=new JsonObject();
            apiManager.Provider(callBack,jsonObject);
        } else {

        }
    }


    public void addItemsOnSpinner2() {
        spinner = activity.findViewById(R.id.textView);
        spinner.setOnItemSelectedListener(this);
        list.add("SHOW ALL PROVIDERS");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(dataAdapter);
    }


    private void parkingHistory() {
        if (CommonUtils.isOnline(activity)){
            ProgressDialogUtils.show(activity);
            ApiManager apiManager =new ApiManager(activity);
            ApiCallBack<ParkingHistoryMainResponce> callBack=new ApiCallBack<>(new ApiResponseListener<ParkingHistoryMainResponce>() {
                @Override
                public void onApiSuccess(ParkingHistoryMainResponce response, String apiName) {
                    ProgressDialogUtils.dismiss();
                    ToastUtils.showToastShort(activity,response.getMessage());
                    if (response.getResult()!=null){
                        recycleParkingHistory(response.getResult());
                    }
                    ToastUtils.showToastLong(activity,response.getMessage());
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
            },"",activity );
            JsonObject jsonObject=new JsonObject();
            jsonObject.addProperty("user_id", SavedPrefManager.getStringPreferences(activity, AppConstant.USER_ID));
            apiManager.parkingHistory(callBack, jsonObject);
        }
    }

    private void recycleParkingHistory(List<ParkingHistoryDateResponce> dateResponces){
        ParkingHistoryParentAdapter adapter=new ParkingHistoryParentAdapter(activity,dateResponces);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false);
        fragment.getBinding().rvParkingHistory.setLayoutManager(linearLayoutManager);
        fragment.getBinding().rvParkingHistory.setAdapter(adapter);
    }


    @Override
    protected void initialize(ActivityParkingBinding binding) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ((TextView)adapterView.getChildAt(0)).setTextColor(Color.WHITE);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

/*
    private void setRecycler() {
        ProfileAdapter auctionRecyclerAdapter = new ProfileAdapter(fragment,new List<ProfileModel>());
        fragment.getBinding().rvOwnerShip.setLayoutManager(new LinearLayoutManager(activity));
        fragment.getBinding().rvOwnerShip.setAdapter(auctionRecyclerAdapter);
    }*/

}
