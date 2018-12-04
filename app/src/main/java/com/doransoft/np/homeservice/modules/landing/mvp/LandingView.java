package com.doransoft.np.homeservice.modules.landing.mvp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.doransoft.np.homeservice.R;

import butterknife.ButterKnife;

public class LandingView extends FrameLayout{
    Activity  activity;
    public LandingView(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.activity_forgot_password,this);
        ButterKnife.bind(this);

    }
}
