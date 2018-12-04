package com.doransoft.np.homeservice.modules.loginregister.mvp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.doransoft.np.homeservice.R;

import butterknife.ButterKnife;

public class LoginRegisterView extends FrameLayout {

    Activity activity;

    public LoginRegisterView(AppCompatActivity activity) {

        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.activity_login_register,this);
        ButterKnife.bind(this);

    }
}
