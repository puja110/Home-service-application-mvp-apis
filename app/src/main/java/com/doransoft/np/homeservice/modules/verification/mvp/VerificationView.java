package com.doransoft.np.homeservice.modules.verification.mvp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.doransoft.np.homeservice.R;

import butterknife.ButterKnife;

public class VerificationView extends FrameLayout{
    Activity  activity;
    public VerificationView(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.activity_forgot_password,this);
        ButterKnife.bind(this);

    }
}
