package com.mobiloitte.friendsierunnerapp.api.response.DashboardResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DashboardResultResponse {

    @SerializedName("data")
    @Expose
    private DashboardDataResponse data;
    @SerializedName("parked_cars")
    @Expose
    private List<DashboardParkedResponse> parkedCars = null;


    public DashboardDataResponse getData() {
        return data;
    }

    public void setData(DashboardDataResponse data) {
        this.data = data;
    }

    public List<DashboardParkedResponse> getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(List<DashboardParkedResponse> parkedCars) {
        this.parkedCars = parkedCars;
    }
}
