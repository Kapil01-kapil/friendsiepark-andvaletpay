package com.mobiloitte.friendsierunnerapp.api.response.DashboardResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashboardParkedResponse {
    @SerializedName("car_id")
    @Expose
    private Integer carId;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("customer_id")
    @Expose
    private Integer customerId;
    @SerializedName("car_license")
    @Expose
    private String carLicense;
    @SerializedName("booking_status_id")
    @Expose
    private Integer bookingStatusId;
    @SerializedName("remaining_time")
    @Expose
    private Integer remainingTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public Integer getBookingStatusId() {
        return bookingStatusId;
    }

    public void setBookingStatusId(Integer bookingStatusId) {
        this.bookingStatusId = bookingStatusId;
    }

    public Integer getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(Integer remainingTime) {
        this.remainingTime = remainingTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
