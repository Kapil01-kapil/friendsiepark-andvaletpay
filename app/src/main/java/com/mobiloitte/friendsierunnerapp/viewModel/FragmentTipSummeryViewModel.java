package com.mobiloitte.friendsierunnerapp.viewModel;

import android.app.Activity;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.JsonObject;
import com.mobiloitte.friendsierunnerapp.Adapter.MyTipSummaryAdapter;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.api.ApiCallBack;
import com.mobiloitte.friendsierunnerapp.api.ApiManager;
import com.mobiloitte.friendsierunnerapp.api.ApiResponseListener;
import com.mobiloitte.friendsierunnerapp.api.response.GetProviderResponse.GetProviderMainResponse;
import com.mobiloitte.friendsierunnerapp.api.response.GetProviderResponse.GetProviderResultResponse;
import com.mobiloitte.friendsierunnerapp.api.response.RunnerTipResponse;
import com.mobiloitte.friendsierunnerapp.base.fragment.FragmentViewModel;
import com.mobiloitte.friendsierunnerapp.databinding.FragmentTipSummaryBinding;
import com.mobiloitte.friendsierunnerapp.util.AppConstant;
import com.mobiloitte.friendsierunnerapp.util.CommonUtils;
import com.mobiloitte.friendsierunnerapp.util.ProgressDialogUtils;
import com.mobiloitte.friendsierunnerapp.util.SavedPrefManager;
import com.mobiloitte.friendsierunnerapp.util.ToastUtils;
import com.mobiloitte.friendsierunnerapp.view.FragmentTipSummery;

import java.util.List;


public class FragmentTipSummeryViewModel extends FragmentViewModel<FragmentTipSummery, FragmentTipSummaryBinding> {

    private FragmentTipSummery fragment;
    public Activity activity;

    public FragmentTipSummeryViewModel(FragmentTipSummery fragment, FragmentTipSummaryBinding binding) {
        super(fragment, binding);
        this.activity = getActivity();
        this.fragment = fragment;
        initializeControl();
    }

    @Override
    protected void initialize(FragmentTipSummaryBinding binding) {

    }


    private void initializeControl() {

        getRunnerTip();
    }



    private void getRunnerTip() {
        if(CommonUtils.isOnline(activity)){
            ProgressDialogUtils.show(activity);
            ApiManager apiManager =new ApiManager(activity);
            ApiCallBack<RunnerTipResponse> callBack=new ApiCallBack<>(new ApiResponseListener<RunnerTipResponse>() {
                @Override
                public void onApiSuccess(RunnerTipResponse response, String apiName) {
                    ProgressDialogUtils.dismiss();
                    if(response.getResponseCode()==200){
                        setRecycle(response.getResult().getData());
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
            jsonObject.addProperty("user_id",SavedPrefManager.getStringPreferences(activity, AppConstant.USER_ID));
            apiManager.getRunnerTipApi(callBack,jsonObject);
        } else {
            ToastUtils.showToastLong(activity,"No Internet Connection");
        }
    }

    private void setRecycle(List<RunnerTipResponse.Datum> data){
        MyTipSummaryAdapter adapter=new MyTipSummaryAdapter(activity,data);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false);
        fragment.getBinding().rvMyTipSummery.setLayoutManager(linearLayoutManager);
        fragment.getBinding().rvMyTipSummery.setAdapter(adapter);
    }
}
