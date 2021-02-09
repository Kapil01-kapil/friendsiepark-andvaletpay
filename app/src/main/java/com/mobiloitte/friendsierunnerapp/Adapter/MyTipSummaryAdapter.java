package com.mobiloitte.friendsierunnerapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.api.response.RunnerTipResponse;
import com.mobiloitte.friendsierunnerapp.databinding.ItemMytipsummaryBinding;

import java.util.List;

public class MyTipSummaryAdapter extends RecyclerView.Adapter<MyTipSummaryAdapter.MyViewHolder>{
    private Context mContext;
    private List<RunnerTipResponse.Datum> datumList;

    public MyTipSummaryAdapter(Context mContext, List<RunnerTipResponse.Datum> datumList) {
        this.mContext = mContext;
        this.datumList = datumList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_mytipsummary,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RunnerTipResponse.Datum datum=datumList.get(position);
       holder.binding.tvDAte.setText( datum.getDate());
        holder.binding.tvAmount.setText(""+datum.getPrice());
        holder.binding.tvName.setText(datum.getProviderName());
    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemMytipsummaryBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=ItemMytipsummaryBinding.bind(itemView);
        }
    }
}
