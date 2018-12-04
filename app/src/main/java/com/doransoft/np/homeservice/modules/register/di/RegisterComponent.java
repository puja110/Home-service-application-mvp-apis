package com.doransoft.np.homeservice.modules.register.di;


import com.doransoft.np.homeservice.application.di.ApplicationComponent;
import com.doransoft.np.homeservice.modules.login.LoginActivity;
import com.doransoft.np.homeservice.modules.register.RegisterActivity;

import dagger.Component;

@RegisterScope
@Component(modules = RegisterModule.class,dependencies = ApplicationComponent.class)
public interface RegisterComponent {
    void inject(RegisterActivity activity);
}
