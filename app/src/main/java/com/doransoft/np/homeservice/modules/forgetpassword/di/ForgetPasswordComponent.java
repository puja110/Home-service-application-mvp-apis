package com.doransoft.np.homeservice.modules.forgetpassword.di;

import com.doransoft.np.homeservice.application.di.ApplicationComponent;
import com.doransoft.np.homeservice.modules.forgetpassword.ForgotPasswordActivity;

import dagger.Component;

@ForgetPassword
@Component(modules = ForgetPasswordModule.class,dependencies = ApplicationComponent.class)
public interface ForgetPasswordComponent {
    void inject(ForgotPasswordActivity activity);
}
