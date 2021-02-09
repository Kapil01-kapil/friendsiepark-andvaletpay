package com.mobiloitte.friendsierunnerapp.api.response.DashboardResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashboardDataResponse {
    @SerializedName("user_image")
    @Expose
    private String userImage;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("provider_name")
    @Expose
    private String providerName;
    @SerializedName("provider_phone_number")
    @Expose
    private String providerPhoneNumber;
    @SerializedName("lot_id")
    @Expose
    private Integer lotId;
    @SerializedName("lot_name")
    @Expose
    private String lotName;
    @SerializedName("lot_address")
    @Expose
    private String lotAddress;

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderPhoneNumber() {
        return providerPhoneNumber;
    }

    public void setProviderPhoneNumber(String providerPhoneNumber) {
        this.providerPhoneNumber = providerPhoneNumber;
    }

    public Integer getLotId() {
        return lotId;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public String getLotName() {
        return lotName;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public String getLotAddress() {
        return lotAddress;
    }

    public void setLotAddress(String lotAddress) {
        this.lotAddress = lotAddress;
    }
}
