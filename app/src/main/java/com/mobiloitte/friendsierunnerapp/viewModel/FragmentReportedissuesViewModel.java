package com.mobiloitte.friendsierunnerapp.viewModel;


import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.mobiloitte.friendsierunnerapp.R;
import com.mobiloitte.friendsierunnerapp.base.fragment.FragmentViewModel;
import com.mobiloitte.friendsierunnerapp.databinding.ActivityProfileBinding;
import com.mobiloitte.friendsierunnerapp.databinding.ActivityRwportedIssuesBinding;
import com.mobiloitte.friendsierunnerapp.view.FragmentEditProfile;
import com.mobiloitte.friendsierunnerapp.view.FragmentParkingHistory;
import com.mobiloitte.friendsierunnerapp.view.FragmentReportedIssues;

public class FragmentReportedissuesViewModel extends FragmentViewModel<FragmentReportedIssues, ActivityRwportedIssuesBinding> {

    private FragmentReportedIssues fragment;
    public Activity activity;
    private Button btnAddComment;

    public FragmentReportedissuesViewModel(FragmentReportedIssues fragment, ActivityRwportedIssuesBinding binding) {
        super(fragment, binding);
        this.activity = getActivity();
        this.fragment = fragment;
    fragment.getBinding().btnAddComment.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final BottomSheetDialog dialog = new BottomSheetDialog(activity);
            dialog.setContentView(R.layout.add_comment);
            dialog.show();
            Button btn =dialog.findViewById(R.id.btnCancel);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            Button send =dialog.findViewById(R.id.btnSend);
            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        }
    });
    }

    @Override
    protected void initialize(ActivityRwportedIssuesBinding binding) {



    }


/*
    ll_find_valet_customer.setOnClickListener {
        var bottomSheetBehavior = BottomSheetDialog(this)
        val view =layoutInflater.inflate(R.layout.no_location_found,null)

        bottomSheetBehavior.setContentView(view)
        bottomSheetBehavior.show()
    }*/
}
