package com.doransoft.np.homeservice.modules.forgetpassword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.doransoft.np.homeservice.application.di.MainApplication;
import com.doransoft.np.homeservice.modules.forgetpassword.di.DaggerForgetPasswordComponent;
import com.doransoft.np.homeservice.modules.forgetpassword.di.ForgetPasswordModule;
import com.doransoft.np.homeservice.modules.forgetpassword.mvp.ForgetPasswordPresenter;
import com.doransoft.np.homeservice.modules.forgetpassword.mvp.ForgetPasswordView;

import javax.inject.Inject;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Inject
    ForgetPasswordPresenter  forgetPasswordPresenter;

    @Inject
    ForgetPasswordView  forgetPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerForgetPasswordComponent.builder().applicationComponent(MainApplication.get(this).getApplicationComponent()).forgetPasswordModule(new ForgetPasswordModule(this)).build().inject(this);
        setContentView(forgetPasswordView);
        forgetPasswordPresenter.onViewCreated();
    }
}
