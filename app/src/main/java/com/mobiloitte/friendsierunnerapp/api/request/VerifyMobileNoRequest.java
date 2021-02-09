package com.mobiloitte.friendsierunnerapp.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyMobileNoRequest {

    @SerializedName("otp")
    @Expose
    private String verify_otp;

    public String getVerify_otp() {
        return verify_otp;
    }

    public void setVerify_otp(String verify_otp) {
        this.verify_otp = verify_otp;
    }
}
