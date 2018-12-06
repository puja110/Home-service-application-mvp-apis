package com.doransoft.np.homeservice.application.di.modules;

import android.app.Application;
import android.content.Context;

import com.doransoft.np.homeservice.application.di.AppScope;
import com.doransoft.np.homeservice.helper.PreferencesManager;
import com.doransoft.np.homeservice.helper.RequestPermissionHandler;
import com.doransoft.np.homeservice.helper.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Context context;

    public AppModule(Application application) {
        this.context = application.getApplicationContext();
    }

    @Provides
    @AppScope
    public Context context()
    {
        return context;
    }

    @Provides
    @AppScope
    public SchedulerProvider schedulerProvider() {
        return SchedulerProvider.getInstance();
    }

    @Provides
    @AppScope
    RequestPermissionHandler requestPermissionHandler(){
        return  new RequestPermissionHandler();
    }
}
