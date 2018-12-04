package com.doransoft.np.homeservice.modules.forgetpassword.mvp;

import android.support.v7.app.AppCompatActivity;

import com.doransoft.np.homeservice.helper.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public class ForgetPasswordPresenter {

    CompositeDisposable  compositeDisposable = new CompositeDisposable();
    public ForgetPasswordPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, ForgetPasswordView forgetPasswordView, ForgetPasswordInteractor forgetPasswordInteractor) {

    }

    public void onViewCreated() {
    }
}
