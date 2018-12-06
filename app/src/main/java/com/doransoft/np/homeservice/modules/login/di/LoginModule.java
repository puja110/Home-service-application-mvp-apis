package com.doransoft.np.homeservice.modules.login.di;

import android.support.v7.app.AppCompatActivity;

import com.doransoft.np.homeservice.application.network.AppNetwork;
import com.doransoft.np.homeservice.helper.PreferencesManager;
import com.doransoft.np.homeservice.helper.SchedulerProvider;
import com.doransoft.np.homeservice.modules.login.mvp.LoginInteractor;
import com.doransoft.np.homeservice.modules.login.mvp.LoginPresenter;
import com.doransoft.np.homeservice.modules.login.mvp.LoginView;

import dagger.Module;
import dagger.Provides;
import retrofit2.http.Path;

@Module
public class LoginModule {

    public  final AppCompatActivity  activity;

    public LoginModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @LoginScope
    LoginView  provideLoginView() {
        return new LoginView(activity);
    }

    @Provides
    @LoginScope
    LoginPresenter  provieLoginPresenter(SchedulerProvider schedulerProvider, LoginView loginView, LoginInteractor loginInteractor){
        return  new LoginPresenter(activity,schedulerProvider,loginView,loginInteractor);
    }

    @Provides
    @LoginScope
    LoginInteractor  loginInteractor(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return new LoginInteractor(preferencesManager,appNetwork);
    }
}
