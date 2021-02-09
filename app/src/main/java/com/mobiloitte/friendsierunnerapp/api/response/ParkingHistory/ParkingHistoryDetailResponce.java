package com.mobiloitte.friendsierunnerapp.api.response.ParkingHistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParkingHistoryDetailResponce {
    @SerializedName("car_name")
    @Expose
    private String carName;
    @SerializedName("car_license")
    @Expose
    private String carLicense;
    @SerializedName("booking_status")
    @Expose
    private Integer bookingStatus;
    @SerializedName("car_nickname")
    @Expose
    private String carNickname;
    @SerializedName("remaining_time")
    @Expose
    private String remainingTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public Integer getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(Integer bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getCarNickname() {
        return carNickname;
    }

    public void setCarNickname(String carNickname) {
        this.carNickname = carNickname;
    }

    public String getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(String remainingTime) {
        this.remainingTime = remainingTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }




}
