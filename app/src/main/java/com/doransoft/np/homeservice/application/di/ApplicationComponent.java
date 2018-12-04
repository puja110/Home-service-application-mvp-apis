package com.doransoft.np.homeservice.application.di;


import android.content.Context;

import com.doransoft.np.homeservice.application.di.modules.AppModule;
import com.doransoft.np.homeservice.application.di.modules.DataBaseModule;
import com.doransoft.np.homeservice.application.di.modules.GsonModule;
import com.doransoft.np.homeservice.application.di.modules.NetworkModule;
import com.doransoft.np.homeservice.application.network.AppNetwork;
import com.doransoft.np.homeservice.helper.PreferencesManager;
import com.doransoft.np.homeservice.helper.RequestPermissionHandler;
import com.doransoft.np.homeservice.helper.SchedulerProvider;
import com.google.gson.Gson;

import dagger.Component;

@AppScope
@Component(modules = {AppModule.class, NetworkModule.class, DataBaseModule.class, GsonModule.class})
public interface ApplicationComponent {
    Context context();
    PreferencesManager preferencesManager();
    SchedulerProvider schedulerProvider();
    RequestPermissionHandler  requestPermissionHandler();
    AppNetwork appNetwork();

}
