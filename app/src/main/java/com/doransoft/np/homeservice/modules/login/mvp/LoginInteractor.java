package com.doransoft.np.homeservice.modules.login.mvp;

import com.doransoft.np.homeservice.application.network.AppNetwork;
import com.doransoft.np.homeservice.helper.PreferencesManager;
import com.doransoft.np.homeservice.modules.login.pojo.LoginResponse;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class LoginInteractor {
    PreferencesManager preferencesManager;
    AppNetwork appNetwork;

    public LoginInteractor(PreferencesManager preferencesManager, AppNetwork appNetwork) {
        this.preferencesManager = preferencesManager;
        this.appNetwork = appNetwork;
    }


    public Observable<LoginResponse> getLoginData(String email, String password) {
        return appNetwork.requestLoginToServer(email,password,"get secret key from preference manager");
    }
}
