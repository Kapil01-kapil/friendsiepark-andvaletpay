package com.mobiloitte.friendsierunnerapp.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashboardRequest {
    @SerializedName("user_id")
    @Expose
    private String user_id;


    @SerializedName("service_provider_id")
    @Expose
    private String sevice_provider_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getSevice_provider_id() {
        return sevice_provider_id;
    }

    public void setSevice_provider_id(String sevice_provider_id) {
        this.sevice_provider_id = sevice_provider_id;
    }
}
