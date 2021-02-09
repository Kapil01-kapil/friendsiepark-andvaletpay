package com.mobiloitte.friendsierunnerapp.api;

import com.mobiloitte.friendsierunnerapp.BuildConfig;

public class AppUrl {


        public static String BASE_URL = null;

        static {
            if (BuildConfig.DEBUG) {
               // BASE_URL = "http://ec2-13-126-72-205.ap-south-1.compute.amazonaws.com/PROJECTS/NewFriendsieParkPanel/public/api/valet/";
                BASE_URL = "http://ec2-13-126-72-205.ap-south-1.compute.amazonaws.com/PROJECTS/NewFriendsieParkPanel/public/api/valet/";


            }
        }

}
