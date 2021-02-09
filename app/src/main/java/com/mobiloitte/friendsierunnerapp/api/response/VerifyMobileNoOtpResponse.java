package com.mobiloitte.friendsierunnerapp.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyMobileNoOtpResponse {
    @SerializedName("user_id")
    @Expose
    public String userId;

    @SerializedName("service_provider_id")
    @Expose

    public String service_provider_id;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getService_provider_id() {
        return service_provider_id;
    }

    public void setService_provider_id(String service_provider_id) {
        this.service_provider_id = service_provider_id;
    }
}
