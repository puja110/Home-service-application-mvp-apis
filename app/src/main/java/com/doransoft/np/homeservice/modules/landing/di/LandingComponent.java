package com.doransoft.np.homeservice.modules.landing.di;


import com.doransoft.np.homeservice.application.di.ApplicationComponent;
import com.doransoft.np.homeservice.modules.login.LoginActivity;
import com.doransoft.np.homeservice.modules.login.di.LoginModule;
import com.doransoft.np.homeservice.modules.login.di.LoginScope;

import dagger.Component;

@LoginScope
@Component(modules = LoginModule.class,dependencies = ApplicationComponent.class)
public interface LandingComponent {
    void inject(LoginActivity activity);
}
