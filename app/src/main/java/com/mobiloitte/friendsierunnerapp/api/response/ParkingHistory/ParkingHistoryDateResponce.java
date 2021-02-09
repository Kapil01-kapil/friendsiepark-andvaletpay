package com.mobiloitte.friendsierunnerapp.api.response.ParkingHistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ParkingHistoryDateResponce {
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("parking_details")
    @Expose
    private List<ParkingHistoryDetailResponce> parkingDetails = null;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ParkingHistoryDetailResponce> getParkingDetails() {
        return parkingDetails;
    }

    public void setParkingDetails(List<ParkingHistoryDetailResponce> parkingDetails) {
        this.parkingDetails = parkingDetails;
    }
}
