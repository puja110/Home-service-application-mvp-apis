package com.doransoft.np.homeservice.modules.register.di;


import android.support.v7.app.AppCompatActivity;

import com.doransoft.np.homeservice.application.network.AppNetwork;
import com.doransoft.np.homeservice.helper.PreferencesManager;
import com.doransoft.np.homeservice.helper.SchedulerProvider;
import com.doransoft.np.homeservice.modules.login.mvp.LoginInteractor;
import com.doransoft.np.homeservice.modules.login.mvp.LoginPresenter;
import com.doransoft.np.homeservice.modules.login.mvp.LoginView;
import com.doransoft.np.homeservice.modules.register.mvp.RegisterInteractor;
import com.doransoft.np.homeservice.modules.register.mvp.RegisterPresenter;
import com.doransoft.np.homeservice.modules.register.mvp.RegisterView;

import dagger.Module;
import dagger.Provides;

@Module
public class RegisterModule {

    public  final AppCompatActivity  activity;

    public RegisterModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @RegisterScope
    RegisterView  provideRegisterView() {
        return new RegisterView(activity);
    }

    @Provides
    @RegisterScope
    RegisterPresenter provideRegisterPresenter(SchedulerProvider schedulerProvider, RegisterView registerView, RegisterInteractor registerInteractor){
        return  new RegisterPresenter(activity,schedulerProvider,registerView,registerInteractor);
    }

    @Provides
    @RegisterScope
    RegisterInteractor  loginInteractor(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return new RegisterInteractor(preferencesManager,appNetwork);
    }
}
