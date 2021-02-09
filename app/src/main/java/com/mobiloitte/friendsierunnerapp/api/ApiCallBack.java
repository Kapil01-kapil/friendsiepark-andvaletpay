package com.mobiloitte.friendsierunnerapp.api;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.util.LogUtils;
import com.mobiloitte.friendsierunnerapp.util.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCallBack<T> implements Callback<T> {
    private ApiResponseListener<T> apiListener;
    private String apiName;
    private Context mContext;

    public ApiCallBack(ApiResponseListener<T> apiListener, String apiName, Context mContext) {
        this.apiListener = apiListener;
        this.apiName = apiName;
        this.mContext = mContext;
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {

//        ApiResponse apiResponse = (ApiResponse) response.body();
        LogUtils.LOGD("Response:", new Gson().toJson(response));
        Log.d("Taju-Log", "ApiCallBack - onResponse : " + new Gson().toJson(response));

        if (response.code() == HttpURLConnection.HTTP_OK) {
            apiListener.onApiSuccess(response.body(), apiName);
            System.out.println("response 200");
        } else if (response.code() == HttpURLConnection.HTTP_BAD_REQUEST) {

            String apiResponseError = "";
            String fdsf = "";
            try {
                if (response.errorBody() != null) {
                    apiResponseError = response.errorBody().string();
                    JSONObject jsonObject = new JSONObject(apiResponseError);
                    fdsf = jsonObject.getString("message");
                    //        ToastUtils.showToastShort(mContext, String.valueOf(fdsf));
                } else {
                    apiResponseError = response.message();
                    JSONObject jsonObject = new JSONObject(apiResponseError);
                    fdsf = jsonObject.getString("message");
                    //    ToastUtils.showToastShort(mContext, String.valueOf(fdsf));
                    System.out.println("onApiSuccess");
                    LogUtils.LOGD("Taju-Log", String.valueOf(response.code()));
                    // ToastUtils.showToastShort(mContext, "something went wrong!");
                    // ToastUtils.showToastLong(mContext, String.valueOf(response.code()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            apiListener.onApiError(fdsf, apiName);
        } else {
            ToastUtils.showToastShort(mContext, String.valueOf(response.code()));
            String apiResponseError = "";
            apiListener.onApiError(response.message(), apiName);
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        System.out.println("ApiFailure");
        LogUtils.LOGE("FAILURE", t.getMessage());

        LogUtils.LOGD("assert_log", "ApiCallBack - onFailure : " + t.getMessage());
        apiListener.onApiFailure(mContext.getString(R.string.server_error), apiName);
    }


}
