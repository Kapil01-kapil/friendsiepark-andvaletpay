package com.mobiloitte.friendsierunnerapp.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.api.response.DashboardResponse.DashboardDataResponse;
import com.mobiloitte.friendsierunnerapp.api.response.DashboardResponse.DashboardParkedResponse;
import com.mobiloitte.friendsierunnerapp.databinding.DashboardMyparkedcarLayoutBinding;
import com.mobiloitte.friendsierunnerapp.interfaces.RecyclerClickListener;
import com.mobiloitte.friendsierunnerapp.view.DashboardActivity;

import java.util.List;

public class MyParkedCarAdapter extends RecyclerView.Adapter<MyParkedCarAdapter.MyViewHolder> {
    private RecyclerClickListener itemClickListener;
    private Context context;
    private List<DashboardParkedResponse> circleImageModelList;

    public MyParkedCarAdapter(Context context, List<DashboardParkedResponse> circleImageModelList, RecyclerClickListener itemClickListener) {
        this.context=context;
        this.itemClickListener= itemClickListener;
        this.circleImageModelList=circleImageModelList;
    }


    @NonNull
    @Override
    public MyParkedCarAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.dashboard_myparkedcar_layout, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyParkedCarAdapter.MyViewHolder holder, final int position) {

        if (circleImageModelList!=null){

            DashboardParkedResponse model=circleImageModelList.get(position);
           // holder.binding.ivCompleted.setVisibility(View.VISIBLE);
            holder.binding.tvDF.setText(model.getUserName());
            holder.binding.tvnumber.setText(model.getCarLicense());
            Integer bookingStatusId=model.getBookingStatusId();
            if (bookingStatusId==1){
                holder.binding.frameLayout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.bg_orange_circle));
                holder.binding.ivCompleted.setVisibility(View.GONE);
                holder.binding.tvtimmer.setVisibility(View.VISIBLE);

            }else if (bookingStatusId==2){
                holder.binding.frameLayout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.mg_drawable));
                holder.binding.ivCompleted.setVisibility(View.VISIBLE);
                holder.binding.tvtimmer.setVisibility(View.GONE);
            }else if (bookingStatusId==3){
                holder.binding.frameLayout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.mg_drawable));
                holder.binding.ivCompleted.setVisibility(View.GONE);
                holder.binding.tvtimmer.setVisibility(View.GONE);
                return;
            }else if (bookingStatusId==4){
                holder.binding.frameLayout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.mg_drawable));
                holder.binding.ivCompleted.setVisibility(View.GONE);
                holder.binding.tvtimmer.setVisibility(View.GONE);
                return;
            }else if (bookingStatusId==6){
                holder.binding.frameLayout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.mg_drawable));
                holder.binding.tvtimmer.setVisibility(View.VISIBLE);
                holder.binding.ivCompleted.setVisibility(View.GONE);
                holder.binding.tvtimmer.setVisibility(View.GONE);
            }

        //    holder.binding.tvtimmer.setText(model.getRemainingTime());
            holder.binding.frameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.onclick(view,position);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return circleImageModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        DashboardMyparkedcarLayoutBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=DashboardMyparkedcarLayoutBinding.bind(itemView);

        }

    }
}