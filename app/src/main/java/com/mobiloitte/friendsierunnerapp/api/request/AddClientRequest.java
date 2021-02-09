package com.mobiloitte.friendsierunnerapp.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddClientRequest {
    @SerializedName("phone_number")
    @Expose
    public String phone_number;
}


