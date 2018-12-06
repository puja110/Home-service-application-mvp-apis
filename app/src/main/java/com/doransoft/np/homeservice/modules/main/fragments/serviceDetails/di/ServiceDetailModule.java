package com.doransoft.np.homeservice.modules.main.fragments.serviceDetails.di;

import android.support.v7.app.AppCompatActivity;

import com.doransoft.np.homeservice.application.network.AppNetwork;
import com.doransoft.np.homeservice.helper.PreferencesManager;
import com.doransoft.np.homeservice.helper.SchedulerProvider;

import com.doransoft.np.homeservice.modules.main.fragments.service.di.ServiceScope;
import com.doransoft.np.homeservice.modules.main.fragments.serviceDetails.mvp.ServiceDetailInteractor;
import com.doransoft.np.homeservice.modules.main.fragments.serviceDetails.mvp.ServiceDetailPresenter;
import com.doransoft.np.homeservice.modules.main.fragments.serviceDetails.mvp.ServiceDetailView;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceDetailModule {

    public  final AppCompatActivity activity;

    public ServiceDetailModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @ServiceDetailScope
    @Provides
    ServiceDetailView provideServiceDetailView() {
        return new ServiceDetailView(activity);
    }

    @Provides
    @ServiceDetailScope
    ServiceDetailPresenter  provideServiceDetailPresenter(SchedulerProvider schedulerProvider, ServiceDetailView serviceDetailView, ServiceDetailInteractor serviceDetailInteractor){
        return  new ServiceDetailPresenter(activity,schedulerProvider,serviceDetailView,serviceDetailInteractor);
    }

    @Provides
    @ServiceDetailScope
    ServiceDetailInteractor provideServiceDetailInteractor(PreferencesManager preferencesManager, AppNetwork appNetwork){
        return new ServiceDetailInteractor(preferencesManager,appNetwork);
    }
}
