package com.doransoft.np.homeservice.modules.main.fragments.serviceDetails.di;

import com.doransoft.np.homeservice.application.di.ApplicationComponent;
import com.doransoft.np.homeservice.modules.login.LoginActivity;
import com.doransoft.np.homeservice.modules.login.di.LoginModule;
import com.doransoft.np.homeservice.modules.login.di.LoginScope;
import com.doransoft.np.homeservice.modules.main.fragments.serviceDetails.ServiceDetailFragment;

import dagger.Component;

@ServiceDetailScope
@Component(modules = ServiceDetailModule.class,dependencies = ApplicationComponent.class)
public interface ServiceDetailsComponent {
    void inject(ServiceDetailFragment fragment);

}

