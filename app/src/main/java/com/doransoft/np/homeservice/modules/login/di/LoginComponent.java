package com.doransoft.np.homeservice.modules.login.di;


import com.doransoft.np.homeservice.application.di.ApplicationComponent;
import com.doransoft.np.homeservice.modules.login.LoginActivity;

import dagger.Component;

@LoginScope
@Component(modules = LoginModule.class,dependencies = ApplicationComponent.class)
public interface LoginComponent {
    void inject(LoginActivity activity);
}
