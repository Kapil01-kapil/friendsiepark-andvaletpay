package com.mobiloitte.friendsierunnerapp.api.response.PrivacyPolicy;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrivacyPolicyDataResponse {
    @SerializedName("data")
    @Expose
    private PrivacyPolicyResultResponce data;

    public PrivacyPolicyResultResponce getData() {
        return data;
    }

    public void setData(PrivacyPolicyResultResponce data) {
        this.data = data;
    }
}
