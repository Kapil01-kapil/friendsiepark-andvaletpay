package com.mobiloitte.friendsierunnerapp.api.response.GetProfileResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetProfileResultResponse {
    @SerializedName("data")
    @Expose
    private GetProfileDataResponse data;

    public GetProfileDataResponse getData() {
        return data;
    }

    public void setData(GetProfileDataResponse data) {
        this.data = data;
    }
}
