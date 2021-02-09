package com.mobiloitte.friendsierunnerapp.viewModel;


import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mobiloitte.friendsierunnerapp.Adapter.MyParkedCarAdapter;
import com.mobiloitte.friendsierunnerapp.api.prefs.PrefManager;
import com.mobiloitte.friendsierunnerapp.api.response.ClientInformationResponse.ClientInformationMainResponse;
import com.mobiloitte.friendsierunnerapp.view.AddClientActivity;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.api.ApiCallBack;
import com.mobiloitte.friendsierunnerapp.api.ApiManager;
import com.mobiloitte.friendsierunnerapp.api.ApiResponseListener;
import com.mobiloitte.friendsierunnerapp.api.response.AddClientResponse;
import com.mobiloitte.friendsierunnerapp.api.response.DashboardResponse.DashboardMainResponse;
import com.mobiloitte.friendsierunnerapp.api.response.DashboardResponse.DashboardParkedResponse;
import com.mobiloitte.friendsierunnerapp.base.fragment.FragmentViewModel;
import com.mobiloitte.friendsierunnerapp.databinding.FragmentDashboardBinding;
import com.mobiloitte.friendsierunnerapp.interfaces.RecyclerClickListener;
import com.mobiloitte.friendsierunnerapp.util.ActivityController;
import com.mobiloitte.friendsierunnerapp.util.AppConstant;
import com.mobiloitte.friendsierunnerapp.util.CommonUtils;
import com.mobiloitte.friendsierunnerapp.util.ProgressDialogUtils;
import com.mobiloitte.friendsierunnerapp.util.SavedPrefManager;
import com.mobiloitte.friendsierunnerapp.util.ToastUtils;
import com.mobiloitte.friendsierunnerapp.view.FragmentDashBoard;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentDashBoardViewModel extends FragmentViewModel<FragmentDashBoard, FragmentDashboardBinding> {

    private FragmentDashBoard fragment;
    public Activity activity;
    ImageView fram4;
    ImageView fram5;
    private FrameLayout open_activCar;
    private FrameLayout dadhboard_dfBlack;
    String valetService ="";
    public List<DashboardMainResponse> circleImageModels;
    private ClientInformationMainResponse.Data clientData;

    private Integer bookingStatus,lotId,carId,customerId;
    private String carLicence,userName,carModel,carColor,carYear;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FragmentDashBoardViewModel(final FragmentDashBoard fragment, FragmentDashboardBinding binding) {
        super(fragment, binding);
        this.activity = getActivity();
        this.fragment = fragment;
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /* setRecycler();*/

        DashboardApi();


       ImageView  fram4=activity.findViewById(R.id.iv_plus);
        fram4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        ActivityController.startActivity(activity,AddClientActivity.class,true);
                        //AddclientApi();

            }
        });
    }

    private void clientInfoApi(final int bookingStatusId) {
        if(CommonUtils.isOnline(activity)){
            ProgressDialogUtils.show(activity,AppConstant.PLEASE_WAIT);
            ApiManager apiManager =new ApiManager(activity);
            ApiCallBack<ClientInformationMainResponse> callBack=new ApiCallBack<>(new ApiResponseListener<ClientInformationMainResponse>() {
                @Override
                public void onApiSuccess(ClientInformationMainResponse response, String apiName) {
                    ProgressDialogUtils.dismiss();
                    ToastUtils.showToastShort(activity,response.getMessage());

                    carLicence=response.getResult().getData().getCarLicense();
                    bookingStatus=response.getResult().getData().getBookingStatus();
                    userName=response.getResult().getData().getUserName();
                    carModel=response.getResult().getData().getCarModel();
                    carColor=response.getResult().getData().getCarColor();
                    carYear=response.getResult().getData().getCarYear();
                    showBottomDialog1(bookingStatusId);
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
            jsonObject.addProperty("customer_id",customerId);
            jsonObject.addProperty("car_id",carId);
            jsonObject.addProperty("lot_id",lotId);
             apiManager.clientInformation(callBack,jsonObject);
        }
    }


    private void DashboardApi() {
        if(CommonUtils.isOnline(activity)){
            ProgressDialogUtils.show(activity, AppConstant.PLEASE_WAIT);
            ApiManager apiManager= new ApiManager(activity);
            ApiCallBack<DashboardMainResponse> callBack=new ApiCallBack<>(new ApiResponseListener<DashboardMainResponse>() {
                @Override
                public void onApiSuccess(DashboardMainResponse response, String apiName) {
                    ProgressDialogUtils.dismiss();
                    if(response!=null){
                        valetService=response.getResult().getData().getProviderName();
                        fragment.getBinding().tvMvs.setText(valetService);

                        lotId=response.getResult().getData().getLotId();

                        String phoneno=response.getResult().getData().getProviderPhoneNumber();
                        fragment.getBinding().tvDashboardPhonenumber.setText(phoneno);
                        String houstonsservice=response.getResult().getData().getLotName();
                        fragment.getBinding().tvHs.setText(houstonsservice);
                        String address=response.getResult().getData().getLotAddress();
                        fragment.getBinding().tvParkingaddress.setText(address);

                        String imagepath=response.getResult().getData().getUserImage();
                        PrefManager.getInstance(activity).savePreference(AppConstant.User_Image,imagepath);

                        Picasso.with(activity).load(imagepath).into(fragment.getBinding().ivProfile);

                        CircleImageView ivHeader=activity.findViewById(R.id.nav).findViewById(R.id.ivProfileImageHeader);
                       TextView tvNameHeader= activity.findViewById(R.id.nav).findViewById(R.id.tvNameHeader);
                        String userName=response.getResult().getData().getUserName();
                        Picasso.with(activity).load(imagepath).into(ivHeader);
                       tvNameHeader.setText(userName);

                        TextView tvName=fragment.getActivity().findViewById(R.id.toolbar).findViewById(R.id.tvtext1);
                        tvName.setText("Hi "+userName);

                        if (response.getResult().getParkedCars()!=null){
                            setRecyclerView(response.getResult().getParkedCars());
                        }
                        ToastUtils.showToastShort(activity,response.getMessage());
                    }
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
            jsonObject.addProperty("service_provider_id",SavedPrefManager.getStringPreferences(activity,AppConstant.SERVICE_PROVIDER_ID));
            apiManager.DashbordProfile(callBack,jsonObject);

            } else {

        }
    }


    private void setToolbar() {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbars);


        if (toolbar != null)
            toolbar.findViewById(R.id.toolbars).setVisibility(View.VISIBLE);

        ImageView back =(ImageView)toolbar.findViewById(R.id.ivBack);
        ImageView vel =(ImageView)toolbar.findViewById(R.id.iv_ValetPay_logo);
        TextView vext =(TextView) toolbar.findViewById(R.id.tvtext);
        TextView vext1 =(TextView) toolbar.findViewById(R.id.tvtext1);
        back.setImageResource(R.drawable.ic_forgotpass_arrowback);
        vel.setVisibility(View.INVISIBLE);
        vext1.setVisibility(View.INVISIBLE);
        vext.setVisibility(View.VISIBLE);
        vext.setText(R.string.reported_issues);
    }


    private void setToolbars() {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbars);
        if (toolbar != null)
            toolbar.findViewById(R.id.toolbars).setVisibility(View.VISIBLE);

    }

    @Override
    protected void initialize(FragmentDashboardBinding binding) {

    }


    private void setRecyclerView(final List<DashboardParkedResponse> data) {
        MyParkedCarAdapter myParkedCarAdapter = new MyParkedCarAdapter(activity, data, new RecyclerClickListener() {
            @Override
            public void onclick(View view, int position) {
                switch (view.getId()){
                    case R.id.frameLayout:
                        Integer bookingStatusId=data.get(position).getBookingStatusId();
                    if (bookingStatusId==2){
                        carId=data.get(position).getCarId();
                        customerId=data.get(position).getCustomerId();
                        clientInfoApi(bookingStatusId);
//                        showBottomDialog1();

                    }else if (bookingStatusId==1){
                        /*final BottomSheetDialog dialog = new BottomSheetDialog(activity);
                        dialog.setContentView(R.layout.open_active_ready_for_delivery);
                        dialog.show();*/
                        carId=data.get(position).getCarId();
                        customerId=data.get(position).getCustomerId();
                        clientInfoApi(bookingStatusId);
  //                      showBottomDialog1();
                    }
                    break;
                }

                }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,3,RecyclerView.VERTICAL,false);
        getBinding().gridDashboard.setLayoutManager(gridLayoutManager);
        getBinding().gridDashboard.setAdapter(myParkedCarAdapter);
        myParkedCarAdapter.notifyDataSetChanged();
    }



    private void showBottomDialog1(int bookingStatusId){
        final BottomSheetDialog dialog = new BottomSheetDialog(activity);
        dialog.setContentView(R.layout.activity_active__client__complete);
        getdialogViews(dialog,bookingStatusId);
        dialog.show();
        ImageView cross = dialog.findViewById(R.id.closecompleted);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void getdialogViews(BottomSheetDialog dialog,int bookingStatus){
        TextView number,name,shortName,carName,year,color,model,status;
        Button returnDashboard;
        LinearLayout clentReady;
               number =dialog.findViewById(R.id.tvNumber);
               name=dialog.findViewById(R.id.tvName);
               shortName=dialog.findViewById(R.id.tvShortName);
               carName=dialog.findViewById(R.id.tvCarName);
               year=dialog.findViewById(R.id.tvYear);
               color=dialog.findViewById(R.id.tvColor);
               model=dialog.findViewById(R.id.tvModelNumber);
               status=dialog.findViewById(R.id.tvStatus);
               returnDashboard=dialog.findViewById(R.id.button_returndashboard);
               clentReady=dialog.findViewById(R.id.llClientReady);

               number.setText(carLicence);
        name.setText(userName);
        carName.setText(carModel);
        year.setText(carYear);
        color.setText(carColor);
        model.setText(carModel);


        if (bookingStatus==1){   //open_active_ready_for_delivery
            status.setText("CLIENT IS READY");
            returnDashboard.setVisibility(View.GONE);
           // clentReady.setBackgroundColor(activity.getResources().getColor(R.color.orange));
        }
    }
}
