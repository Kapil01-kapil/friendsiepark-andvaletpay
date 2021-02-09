package com.mobiloitte.friendsierunnerapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.api.response.ParkingHistory.ParkingHistoryDateResponce;
import com.mobiloitte.friendsierunnerapp.databinding.ItemParkingHistoryParentBinding;

import java.util.List;

public class ParkingHistoryParentAdapter extends RecyclerView.Adapter<ParkingHistoryParentAdapter.MyViewHolder>{
    private Context mContext;
    private List<ParkingHistoryDateResponce> dateResponces;

    public ParkingHistoryParentAdapter(Context mContext, List<ParkingHistoryDateResponce> dateResponces) {
        this.mContext = mContext;
        this.dateResponces = dateResponces;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.item_parking_history_parent,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ParkingHistoryDateResponce data=dateResponces.get(position);

        for (int i=0;i<data.getParkingDetails().size();i++){
            holder.binding.tvDate.setText(data.getDate());

            ParkingHistoryChildAdapter adapter=new ParkingHistoryChildAdapter(mContext,data.getParkingDetails());
            GridLayoutManager gridLayoutManager=new GridLayoutManager(mContext,3,RecyclerView.VERTICAL,false);
            holder.binding.rvParkingHistoryParent.setLayoutManager(gridLayoutManager);
            holder.binding.rvParkingHistoryParent.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return dateResponces.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemParkingHistoryParentBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=ItemParkingHistoryParentBinding.bind(itemView);
        }
    }
}
