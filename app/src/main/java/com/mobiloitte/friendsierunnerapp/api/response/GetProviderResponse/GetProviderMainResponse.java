package com.mobiloitte.friendsierunnerapp.api.response.GetProviderResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetProviderMainResponse {
    @SerializedName("result")
    @Expose
    private List<GetProviderResultResponse> result = null;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName(value = "status")
    @Expose
    private Integer status;

    public List<GetProviderResultResponse> getResult() {
        return result;
    }

    public void setResult(List<GetProviderResultResponse> result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
