package com.mobiloitte.friendsierunnerapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.api.response.ParkingHistory.ParkingHistoryDetailResponce;
import com.mobiloitte.friendsierunnerapp.databinding.ItemParkingHistoryChildBinding;

import java.util.List;

public class ParkingHistoryChildAdapter extends RecyclerView.Adapter<ParkingHistoryChildAdapter.MyViewHolder>{
    private Context mContext;
    private List<ParkingHistoryDetailResponce> responceList;

    public ParkingHistoryChildAdapter(Context mContext, List<ParkingHistoryDetailResponce> responceList) {
        this.mContext = mContext;
        this.responceList = responceList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_parking_history_child,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ParkingHistoryDetailResponce responce=responceList.get(position);

        if (responce!=null){
            responce.getBookingStatus();

            holder.binding.tvnumber.setText(responce.getCarLicense());
            holder.binding.tvtimmer.setText(responce.getRemainingTime());
            Integer bookingStatusId=responce.getBookingStatus();
            if (bookingStatusId==1){
                holder.binding.frameLayout.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.bg_orange_circle));
                holder.binding.ivCompleted.setVisibility(View.GONE);
            }else if (bookingStatusId==2){
                holder.binding.frameLayout.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.mg_drawable));
                holder.binding.ivCompleted.setVisibility(View.VISIBLE);
            }else if (bookingStatusId==3){
                holder.binding.frameLayout.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.mg_drawable));
                holder.binding.ivCompleted.setVisibility(View.GONE);
                return;
            }else if (bookingStatusId==4){
                holder.binding.frameLayout.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.mg_drawable));
                holder.binding.ivCompleted.setVisibility(View.GONE);
                return;
            }else if (bookingStatusId==6){
                holder.binding.frameLayout.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.mg_drawable));
                holder.binding.tvtimmer.setVisibility(View.VISIBLE);
                holder.binding.ivCompleted.setVisibility(View.GONE);
            }
        }

    }

    @Override
    public int getItemCount() {
        return responceList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemParkingHistoryChildBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=ItemParkingHistoryChildBinding.bind(itemView);
        }
    }


}
