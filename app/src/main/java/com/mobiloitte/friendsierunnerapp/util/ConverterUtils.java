package com.mobiloitte.friendsierunnerapp.util;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ConverterUtils {


    private static String TAG = ConverterUtils.class.getSimpleName();


   /* public static List<VehiclesModel> getVehicleList(Object o){
        Gson gson = new Gson();
        LoginType type = new TypeToken<List<VehiclesModel>>() {}.getType();
        List<VehiclesModel> mList = gson.fromJson(gson.toJson(o), type);
        LogUtils.errorLog(TAG, "prefManager mList @@"+new Gson().toJsonTree(mList));
        return mList;
    }*/

    public static RequestBody parseString(String str) {
        return RequestBody.create(MediaType.parse("text/plain"), str);
    }

    public static MultipartBody.Part getMultipartFromFile(String partName, File imagefile) {

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), imagefile);
        // MultipartBody.Part is used to send also the actual file name
        return MultipartBody.Part.createFormData(partName, imagefile.getName(), requestFile);
    }

    /*public static VehiclesModel getVehicles(Object data) {
        Gson gson=new Gson();
        return gson.fromJson(gson.toJson(data),VehiclesModel.class);
    }*/

    public static boolean getStatus(String valueFromXml) {
        if (valueFromXml.equalsIgnoreCase("N/A")) {
            return false;
        }
        return true;
    }


    public static String getLink(Object data) {
        String link = "";
        Gson gson = new Gson();
        String gsonString = gson.toJson(data);
        try {
            JSONObject jsonObject = new JSONObject(gsonString);
            link = jsonObject.getString("url");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return link;
    }



}
