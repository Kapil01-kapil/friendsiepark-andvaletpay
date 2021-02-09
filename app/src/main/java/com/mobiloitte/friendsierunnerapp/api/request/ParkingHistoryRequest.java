package com.mobiloitte.friendsierunnerapp.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParkingHistoryRequest {
    @SerializedName("user_id")
    @Expose
    private String user_id;

}
