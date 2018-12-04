package com.doransoft.np.homeservice.modules.register.mvp;

import com.doransoft.np.homeservice.application.network.AppNetwork;
import com.doransoft.np.homeservice.helper.PreferencesManager;
import com.doransoft.np.homeservice.modules.login.pojo.LoginResponse;
import com.doransoft.np.homeservice.modules.register.pojo.RegisterResponse;

import io.reactivex.Observable;

public class RegisterInteractor {
    PreferencesManager preferencesManager;
    AppNetwork appNetwork;

    public RegisterInteractor(PreferencesManager preferencesManager, AppNetwork appNetwork) {
        this.preferencesManager = preferencesManager;
        this.appNetwork = appNetwork;
    }

    public Observable<RegisterResponse> getRegisterData(String email, String password) {
        return appNetwork.requestRegisterToServer(email,password,"get secret key from preference manager");
    }
}
