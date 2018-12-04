package com.doransoft.np.homeservice.modules.forgetpassword.di;


import android.support.v7.app.AppCompatActivity;

import com.doransoft.np.homeservice.application.network.AppNetwork;
import com.doransoft.np.homeservice.helper.PreferencesManager;
import com.doransoft.np.homeservice.helper.SchedulerProvider;
import com.doransoft.np.homeservice.modules.forgetpassword.mvp.ForgetPasswordInteractor;
import com.doransoft.np.homeservice.modules.forgetpassword.mvp.ForgetPasswordPresenter;
import com.doransoft.np.homeservice.modules.forgetpassword.mvp.ForgetPasswordView;

import dagger.Module;
import dagger.Provides;

@Module
public class ForgetPasswordModule {
    public  final AppCompatActivity  activity;

    public ForgetPasswordModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ForgetPassword
    ForgetPasswordView  forgetPasswordView(){
        return  new ForgetPasswordView(activity);
    }


    @Provides
    @ForgetPassword
    ForgetPasswordPresenter  forgetPasswordPresenter(SchedulerProvider schedulerProvider, ForgetPasswordView forgetPasswordView, ForgetPasswordInteractor  forgetPasswordInteractor){
        return  new ForgetPasswordPresenter(activity,schedulerProvider,forgetPasswordView,forgetPasswordInteractor);
    }


    @Provides
    @ForgetPassword
    ForgetPasswordInteractor forgetPasswordInteractor(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return  new ForgetPasswordInteractor(activity,preferencesManager,appNetwork);
    }
}
