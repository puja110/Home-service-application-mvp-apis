package com.doransoft.np.homeservice.modules.main.fragments.serviceDetails.mvp;

import com.doransoft.np.homeservice.application.network.AppNetwork;
import com.doransoft.np.homeservice.helper.PreferencesManager;

public class ServiceDetailInteractor {

    PreferencesManager preferencesManager;
    AppNetwork appNetwork;

    public ServiceDetailInteractor(PreferencesManager preferencesManager, AppNetwork appNetwork) {
        this.preferencesManager = preferencesManager;
        this.appNetwork = appNetwork;
    }
}
