package com.doransoft.np.homeservice.modules.verification.di;

import com.doransoft.np.homeservice.application.di.ApplicationComponent;
import com.doransoft.np.homeservice.modules.forgetpassword.ForgotPasswordActivity;
import com.doransoft.np.homeservice.modules.verification.VerificationActivity;

import dagger.Component;

@VerificationScope
@Component(modules = VerififactionModule.class,dependencies = ApplicationComponent.class)
public interface VerificationComponent {
    void inject(VerificationActivity activity);
}
