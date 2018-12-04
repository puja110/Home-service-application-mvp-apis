package com.doransoft.np.homeservice.modules.loginregister.di;

import com.doransoft.np.homeservice.application.di.ApplicationComponent;
import com.doransoft.np.homeservice.modules.loginregister.LoginRegisterActivity;

import dagger.Component;

@LoginRegisterScope
@Component(modules = LoginRegisterModule.class,dependencies = ApplicationComponent.class)
public interface LoginRegisterComponent {

    void inject(LoginRegisterActivity activity);

}
