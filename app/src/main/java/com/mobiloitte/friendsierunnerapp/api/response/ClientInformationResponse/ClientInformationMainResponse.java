package com.mobiloitte.friendsierunnerapp.api.response.ClientInformationResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientInformationMainResponse {
    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("status")
    @Expose
    private Integer status;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public class Result {
        @SerializedName("data")
        @Expose
        private Data data;
        public Data getData() {
            return data;
        }
        public void setData(Data data) {
            this.data = data;
        }
    }

    public class Data {
        @SerializedName("car_id")
        @Expose
        private Integer carId;
        @SerializedName("customer_id")
        @Expose
        private Integer customerId;
        @SerializedName("car_license")
        @Expose
        private String carLicense;
        @SerializedName("user_name")
        @Expose
        private String userName;
        @SerializedName("car_model")
        @Expose
        private String carModel;
        @SerializedName("car_color")
        @Expose
        private String carColor;
        @SerializedName("car_year")
        @Expose
        private String carYear;
        @SerializedName("booking_status")
        @Expose
        private Integer bookingStatus;

        public Integer getCarId() {
            return carId;
        }
        public void setCarId(Integer carId) {
            this.carId = carId;
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
        public String getUserName() {
            return userName;
        }
        public void setUserName(String userName) {
            this.userName = userName;
        }
        public String getCarModel() {
            return carModel;
        }
        public void setCarModel(String carModel) {
            this.carModel = carModel;
        }
        public String getCarColor() {
            return carColor;
        }
        public void setCarColor(String carColor) {
            this.carColor = carColor;
        }
        public String getCarYear() {
            return carYear;
        }

        public void setCarYear(String carYear) {
            this.carYear = carYear;
        }

        public Integer getBookingStatus() {
            return bookingStatus;
        }

        public void setBookingStatus(Integer bookingStatus) {
            this.bookingStatus = bookingStatus;
        }

    }

}
