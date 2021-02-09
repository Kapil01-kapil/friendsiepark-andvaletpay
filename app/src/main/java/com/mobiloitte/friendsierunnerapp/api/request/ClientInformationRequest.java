package com.mobiloitte.friendsierunnerapp.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientInformationRequest {
    @SerializedName("customer_id")
    @Expose
    private String customer_id;
    @SerializedName("car_id")
    @Expose
    private String car_id;
    @SerializedName("lot_id")
    @Expose
    private String lot_id;
}
