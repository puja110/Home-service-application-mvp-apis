package com.doransoft.np.homeservice.modules.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.doransoft.np.homeservice.application.di.MainApplication;
import com.doransoft.np.homeservice.modules.login.di.DaggerLoginComponent;
import com.doransoft.np.homeservice.modules.login.di.LoginModule;
import com.doransoft.np.homeservice.modules.login.mvp.LoginPresenter;
import com.doransoft.np.homeservice.modules.login.mvp.LoginView;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {

    @Inject
    LoginPresenter  loginPresenter;

    @Inject
    LoginView loginView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerLoginComponent.builder().applicationComponent(MainApplication.get(this).getApplicationComponent()).loginModule(new LoginModule(this)).build().inject(this);
        setContentView(loginView);
        loginPresenter.onViewCreated();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }
}
