package com.doransoft.np.homeservice.modules.login.mvp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.doransoft.np.homeservice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginView extends FrameLayout {
    Activity activity;

    @BindView(R.id.editText)
    public EditText mEmail;

    @BindView(R.id.password)
    public EditText mPassword;

    @BindView(R.id.buttonLogin)
    public Button mLoginbutton;

    @BindView(R.id.forgot_password)
    public TextView mForgotbutton;

    ProgressDialog mProgressDialog;


    public LoginView(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.activity_login, this);
        ButterKnife.bind(this);
    }


    public void initializeProgressDialog() {
        /*initalize progress dialog of your choice*/

    }


    public void showLoading(boolean isLoading) {
        if (isLoading) {
            if (mProgressDialog != null && !mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }
        } else {
            if (mProgressDialog != null && mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
            }
        }
    }


}
