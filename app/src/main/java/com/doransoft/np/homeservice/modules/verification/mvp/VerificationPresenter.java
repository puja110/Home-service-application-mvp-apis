package com.doransoft.np.homeservice.modules.verification.mvp;

import android.support.v7.app.AppCompatActivity;

import com.doransoft.np.homeservice.helper.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public class VerificationPresenter {

    CompositeDisposable  compositeDisposable = new CompositeDisposable();
    public VerificationPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, VerificationView verificationView, VerifficationInteractor verifficationInteractor) {

    }

    public void onViewCreated() {
    }
}
