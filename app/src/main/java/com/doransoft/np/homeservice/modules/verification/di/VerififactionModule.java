package com.doransoft.np.homeservice.modules.verification.di;


import android.support.v7.app.AppCompatActivity;

import com.doransoft.np.homeservice.application.network.AppNetwork;
import com.doransoft.np.homeservice.helper.PreferencesManager;
import com.doransoft.np.homeservice.helper.SchedulerProvider;
import com.doransoft.np.homeservice.modules.verification.mvp.VerifficationInteractor;
import com.doransoft.np.homeservice.modules.verification.mvp.VerificationPresenter;
import com.doransoft.np.homeservice.modules.verification.mvp.VerificationView;

import dagger.Module;
import dagger.Provides;

@Module
public class VerififactionModule {
    public  final AppCompatActivity  activity;

    public VerififactionModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @VerificationScope
    VerificationView forgetPasswordView(){
        return  new VerificationView(activity);
    }


    @Provides
    @VerificationScope
    VerificationPresenter forgetPasswordPresenter(SchedulerProvider schedulerProvider, VerificationView verificationView, VerifficationInteractor verifficationInteractor){
        return  new VerificationPresenter(activity,schedulerProvider, verificationView, verifficationInteractor);
    }


    @Provides
    @VerificationScope
    VerifficationInteractor forgetPasswordInteractor(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return  new VerifficationInteractor(activity,preferencesManager,appNetwork);
    }
}
