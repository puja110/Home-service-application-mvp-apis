package com.doransoft.np.homeservice.modules.loginregister.di;

import android.support.v7.app.AppCompatActivity;

import com.doransoft.np.homeservice.application.network.AppNetwork;
import com.doransoft.np.homeservice.helper.PreferencesManager;
import com.doransoft.np.homeservice.helper.SchedulerProvider;
import com.doransoft.np.homeservice.modules.login.di.LoginScope;
import com.doransoft.np.homeservice.modules.login.mvp.LoginInteractor;
import com.doransoft.np.homeservice.modules.login.mvp.LoginPresenter;
import com.doransoft.np.homeservice.modules.login.mvp.LoginView;
import com.doransoft.np.homeservice.modules.loginregister.mvp.LoginRegisterInteractor;
import com.doransoft.np.homeservice.modules.loginregister.mvp.LoginRegisterPresenter;
import com.doransoft.np.homeservice.modules.loginregister.mvp.LoginRegisterView;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginRegisterModule {

    public  final AppCompatActivity activity;

    public LoginRegisterModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @LoginScope
    LoginRegisterView provideLoginRegisterView() {
        return new LoginRegisterView(activity);
    }

    @Provides
    @LoginScope
    LoginRegisterPresenter provieLoginRegisterPresenter(SchedulerProvider schedulerProvider, LoginRegisterView loginRegisterView, LoginRegisterInteractor loginRegisterInteractor){
        return  new LoginRegisterPresenter(activity,schedulerProvider,loginRegisterView,loginRegisterInteractor);
    }

    @Provides
    @LoginScope
    LoginInteractor  loginRegisterInteractor(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return new LoginInteractor(preferencesManager,appNetwork);
    }
}
