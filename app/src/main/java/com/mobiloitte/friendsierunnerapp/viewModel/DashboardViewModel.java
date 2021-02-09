package com.mobiloitte.friendsierunnerapp.viewModel;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.google.gson.JsonObject;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.api.ApiCallBack;
import com.mobiloitte.friendsierunnerapp.api.ApiManager;
import com.mobiloitte.friendsierunnerapp.api.ApiResponseListener;
import com.mobiloitte.friendsierunnerapp.api.response.LogoutResponse;
import com.mobiloitte.friendsierunnerapp.base.activity.ActivityViewModel;
import com.mobiloitte.friendsierunnerapp.util.ActivityController;
import com.mobiloitte.friendsierunnerapp.util.AppConstant;
import com.mobiloitte.friendsierunnerapp.util.CommonUtils;
import com.mobiloitte.friendsierunnerapp.util.ProgressDialogUtils;
import com.mobiloitte.friendsierunnerapp.util.SavedPrefManager;
import com.mobiloitte.friendsierunnerapp.util.ToastUtils;
import com.mobiloitte.friendsierunnerapp.view.ActivityLandingPage;
import com.mobiloitte.friendsierunnerapp.view.DashboardActivity;
import com.mobiloitte.friendsierunnerapp.view.FragmentDashBoard;
import com.mobiloitte.friendsierunnerapp.view.FragmentEditProfile;
import com.mobiloitte.friendsierunnerapp.view.FragmentParkingHistory;
import com.mobiloitte.friendsierunnerapp.view.FragmentPrivacy;
import com.mobiloitte.friendsierunnerapp.view.FragmentReportedIssues;
import com.mobiloitte.friendsierunnerapp.view.FragmentTipSummery;
import com.orhanobut.hawk.Hawk;

public class DashboardViewModel  extends ActivityViewModel<DashboardActivity>  implements View.OnClickListener{

    private DashboardActivity activity;


    public DashboardViewModel(DashboardActivity activity) {
        super(activity);
        this.activity=activity;
        ActivityController.setFragment(new FragmentDashBoard(), false, activity, R.id.container);
        activity.getBinding().toolbar.ivBack.setOnClickListener(this);
        activity.getBinding().toolbar.ivBack.setVisibility(View.VISIBLE);
        activity.getBinding().tvProfile.setOnClickListener(this);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activity.getBinding().tvIssues.setOnClickListener(this);
        // activity.getBinding().tvTipStatements.setOnClickListener(this);
        activity.getBinding().tvparkingHistory.setOnClickListener(this);
        activity.getBinding().tvPrivcyPolicy.setOnClickListener(this);

        activity.getBinding().textView3.setOnClickListener(this);

        activity.getBinding().btnLogout.setOnClickListener(this);
        activity.getBinding().nav.close.setOnClickListener(this);
        activity.getBinding().llTipStatement.setOnClickListener(this);


        SavedPrefManager.saveStringPreferences(activity,AppConstant.DEVICE_ID,"2");
        SavedPrefManager.saveStringPreferences(activity,AppConstant.DEVICE_TYPE,"1");
      //  SavedPrefManager.saveString(AppConstant.DEVICE_ID,"2");
       // SavedPrefManager.saveString(AppConstant.DEVICE_TYPE,"1");

    }
    @Override
    public void onBackPressed() {
        finish();
    }

    @SuppressLint({"WrongConstant", "ResourceAsColor"})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivBack:
                activity.getBinding().dlDrawer.openDrawer(Gravity.START);

                break;
            case R.id.close:
                activity.getBinding().dlDrawer.closeDrawer(Gravity.START);
                break;


            case R.id.textView3:
                ActivityController.startActivity(activity, DashboardActivity.class, true, true);
                break;
            case R.id.tvProfile:
                activity.getBinding().toolbar.ivValetPayLogo.setVisibility(View.INVISIBLE);
                activity.getBinding().dlDrawer.closeDrawer(Gravity.START);
                activity.getBinding().toolbar.ivBack.setImageResource(R.drawable.ic_forgotpass_arrowback);
                activity.getBinding().toolbar.tvtext.setVisibility(View.VISIBLE);

                activity.getBinding().toolbar.toolbars.setBackground(getActivity().getResources().getDrawable(R.drawable.bg_toolbar_all));

                activity.getBinding().toolbar.llMain.setBackground(getActivity().getResources().getDrawable(R.drawable.bg_toolbar_all));

                activity.getBinding().toolbar.tvtext1.setVisibility(View.INVISIBLE);
                activity.getBinding().toolbar.tvtext.setText(R.string.my_profile);


                ActivityController.setFragment(new FragmentEditProfile(), true, activity, R.id.container);

                break;
            case R.id.tvIssues:
                activity.getBinding().toolbar.ivValetPayLogo.setVisibility(View.INVISIBLE);
                activity.getBinding().dlDrawer.closeDrawer(Gravity.START);
                activity.getBinding().toolbar.ivBack.setImageResource(R.drawable.ic_forgotpass_arrowback);
                activity.getBinding().toolbar.tvtext.setVisibility(View.VISIBLE);

                activity.getBinding().toolbar.toolbars.setBackground(getActivity().getResources().getDrawable(R.drawable.bg_toolbar_all));

                activity.getBinding().toolbar.llMain.setBackground(getActivity().getResources().getDrawable(R.drawable.bg_toolbar_all));

                activity.getBinding().toolbar.tvtext1.setVisibility(View.INVISIBLE);
                activity.getBinding().toolbar.tvtext.setText(R.string.reported_issues);


                ActivityController.setFragment(new FragmentReportedIssues(), true, activity, R.id.container);

                break;

//            case R.id.tvTipStatements:
//                activity.getBinding().toolbar.ivValetPayLogo.setVisibility(View.INVISIBLE);
//                activity.getBinding().dlDrawer.closeDrawer(Gravity.START);
//                activity.getBinding().toolbar.ivBack.setImageResource(R.drawable.ic_forgotpass_arrowback);
//                activity.getBinding().toolbar.tvtext.setVisibility(View.VISIBLE);
//                activity.getBinding().toolbar.tvtext1.setVisibility(View.INVISIBLE);
//                activity.getBinding().toolbar.tvtext.setText(R.string.payment_method);
//                ToastUtils.showToastShort(activity,"Coming");
//
//              //  ActivityController.setFragment(new FragmentPayment(), true, activity, R.id.container);
//                break;


            case R.id.tvparkingHistory:
                activity.getBinding().toolbar.ivValetPayLogo.setVisibility(View.INVISIBLE);
                activity.getBinding().dlDrawer.closeDrawer(Gravity.START);

                activity.getBinding().toolbar.toolbars.setBackground(getActivity().getResources().getDrawable(R.drawable.bg_toolbar_all));

                activity.getBinding().toolbar.llMain.setBackground(getActivity().getResources().getDrawable(R.drawable.bg_toolbar_all));

                activity.getBinding().toolbar.ivBack.setImageResource(R.drawable.ic_forgotpass_arrowback);
                activity.getBinding().toolbar.tvtext.setVisibility(View.VISIBLE);
                activity.getBinding().toolbar.tvtext1.setVisibility(View.INVISIBLE);
                activity.getBinding().toolbar.tvtext.setText(R.string.parking_history);

                ActivityController.setFragment(new FragmentParkingHistory(), true, activity, R.id.container);

                break;
            case R.id.tvPrivcyPolicy:
                activity.getBinding().toolbar.ivValetPayLogo.setVisibility(View.INVISIBLE);
                activity.getBinding().dlDrawer.closeDrawer(Gravity.START);

                activity.getBinding().toolbar.toolbars.setBackground(getActivity().getResources().getDrawable(R.drawable.bg_toolbar_all));

                activity.getBinding().toolbar.llMain.setBackground(getActivity().getResources().getDrawable(R.drawable.bg_toolbar_all));

                activity.getBinding().toolbar.ivBack.setImageResource(R.drawable.ic_forgotpass_arrowback);
                activity.getBinding().toolbar.tvtext.setVisibility(View.VISIBLE);
                activity.getBinding().toolbar.tvtext1.setVisibility(View.INVISIBLE);
                activity.getBinding().toolbar.tvtext.setText("Privacy Policy");

                ActivityController.setFragment(new FragmentPrivacy(), true, activity, R.id.container);

                break;
            case R.id.btnLogout:
                LogoutApi();
                //ActivityController.startActivity(activity, ActivityLandingPage.class, true);
                break;



            case R.id.llTipStatement:
                activity.getBinding().dlDrawer.closeDrawer(Gravity.START);


                ActivityController.setFragment(new FragmentTipSummery(), true, activity, R.id.container);

                break;


        }


    }

    private void LogoutApi() {
   if(CommonUtils.isOnline(activity)){
    ProgressDialogUtils.show(activity, AppConstant.PLEASE_WAIT);
    ApiManager apiManager =new ApiManager(activity);
    ApiCallBack<LogoutResponse> callBack =new ApiCallBack<>(new ApiResponseListener<LogoutResponse>() {
        @Override
        public void onApiSuccess(LogoutResponse response, String apiName) {
            ProgressDialogUtils.dismiss();
            ToastUtils.showToastShort(activity,response.getMessage());
            SavedPrefManager.savePreferenceBoolean(activity,AppConstant.IS_LOGIN,false);
            ActivityController.startActivity(activity, ActivityLandingPage.class, true);
        }

        @Override
        public void onApiError(String responses, String apiName) {
            ProgressDialogUtils.dismiss();
            ToastUtils.showToastShort(activity,responses);

        }

        @Override
        public void onApiFailure(String failureMessage, String apiName) {
            ProgressDialogUtils.dismiss();
            ToastUtils.showToastShort(activity,failureMessage);

        }
    },AppConstant.USER_ID,activity);
    JsonObject jsonObject=new JsonObject();
    jsonObject.addProperty("user_id", SavedPrefManager.getStringPreferences(activity,AppConstant.USER_ID));
    jsonObject.addProperty("device_id",SavedPrefManager.getStringPreferences(activity,AppConstant.DEVICE_ID));
    jsonObject.addProperty("device_type",SavedPrefManager.getStringPreferences(activity,AppConstant.DEVICE_TYPE));
    apiManager.logout(callBack,jsonObject);


}
    }

}
