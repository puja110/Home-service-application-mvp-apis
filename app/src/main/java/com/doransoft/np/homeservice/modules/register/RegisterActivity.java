package com.doransoft.np.homeservice.modules.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.doransoft.np.homeservice.application.di.MainApplication;
import com.doransoft.np.homeservice.modules.register.di.DaggerRegisterComponent;
import com.doransoft.np.homeservice.modules.register.di.RegisterModule;
import com.doransoft.np.homeservice.modules.register.mvp.RegisterPresenter;
import com.doransoft.np.homeservice.modules.register.mvp.RegisterView;

import javax.inject.Inject;

public class RegisterActivity extends AppCompatActivity {

    @Inject
    RegisterPresenter registerPresenter;

    @Inject
    RegisterView registerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerRegisterComponent.builder().applicationComponent(MainApplication.get(this).getApplicationComponent()).registerModule(new RegisterModule(this)).build().inject(this);
        setContentView(registerView);
        registerPresenter.onViewCreated();
//
//        Button buttonRegister = (Button) findViewById(R.id.buttonRegister);
//        buttonRegister.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
//                startActivity(i);
//            }
//        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        registerPresenter.onDestroy();
    }
}
