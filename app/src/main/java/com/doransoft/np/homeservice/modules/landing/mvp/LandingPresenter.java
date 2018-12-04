package com.doransoft.np.homeservice.modules.landing.mvp;

import android.support.v7.app.AppCompatActivity;

import com.doransoft.np.homeservice.helper.SchedulerProvider;
import com.doransoft.np.homeservice.modules.forgetpassword.mvp.ForgetPasswordInteractor;
import com.doransoft.np.homeservice.modules.forgetpassword.mvp.ForgetPasswordView;

import io.reactivex.disposables.CompositeDisposable;

public class LandingPresenter {

    CompositeDisposable  compositeDisposable = new CompositeDisposable();
    public LandingPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, ForgetPasswordView forgetPasswordView, ForgetPasswordInteractor forgetPasswordInteractor) {

    }

    public void onViewCreated() {
    }
}
