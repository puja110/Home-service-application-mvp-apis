package com.doransoft.np.homeservice.modules.loginregister.mvp;

import android.support.v7.app.AppCompatActivity;

import com.doransoft.np.homeservice.helper.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public class LoginRegisterPresenter {

    CompositeDisposable compositeDisposable = new CompositeDisposable();
    public LoginRegisterPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, LoginRegisterView loginRegisterView, LoginRegisterInteractor loginRegisterInteractor) {

    }

    public void onViewCreated() {
    }

}
