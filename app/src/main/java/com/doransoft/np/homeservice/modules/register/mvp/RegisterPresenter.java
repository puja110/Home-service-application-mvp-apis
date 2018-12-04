package com.doransoft.np.homeservice.modules.register.mvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import com.doransoft.np.homeservice.helper.SchedulerProvider;
import com.doransoft.np.homeservice.modules.forgetpassword.ForgotPasswordActivity;
import com.doransoft.np.homeservice.modules.main.MainActivity;
import com.doransoft.np.homeservice.modules.register.pojo.RegisterResponse;
import com.doransoft.np.homeservice.util.GeneralUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.SocketTimeoutException;

import io.reactivex.disposables.CompositeDisposable;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class RegisterPresenter {
    AppCompatActivity activity;
    SchedulerProvider schedulerProvider;
    RegisterView registerView;
    RegisterInteractor registerInteractor;
    CompositeDisposable  compositeDisposable = new CompositeDisposable();

    public RegisterPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, RegisterView registerView, RegisterInteractor registerInteractor) {
        this.activity = activity;
        this.schedulerProvider = schedulerProvider;
        this.registerView = registerView;
        this.registerInteractor = registerInteractor;
    }

    public void onViewCreated() {
//        registerView.mLoginbutton.setOnClickListener(view -> {
//            if(TextUtils.isEmpty(registerView.mEmail.getText().toString())){
//                /*POPUOP ERROR MESSAGE HERE*/
//            } else  if(TextUtils.isEmpty(registerView.mPassword.getText().toString())){
//                /*POPUOP ERROR MESSAGE HERE*/
//            }else {
//                requestLogin(registerView.mEmail.getText().toString(), registerView.mPassword.getText().toString());
//            }
//        });

        registerView.buttonRegister.setOnClickListener(v -> {
            activity.startActivity(new Intent(activity, MainActivity.class));
        });
    }

//    private void requestRegister(String email, String password) {
//        activity.startActivity(new Intent(activity, MainActivity.class));
////        loginView.showLoading(true);
////        compositeDisposable.add(loginInteractor.getLoginData(email,password)
////        .subscribeOn(schedulerProvider.io())
////        .observeOn(schedulerProvider.ui())
////        .subscribe(this::showSuccess,this::showError));
//    }

    private void showError(Throwable error) {
        registerView.showLoading(false);
        if (error instanceof HttpException) {
            ResponseBody responseBody = ((HttpException) error).response().errorBody();
            Log.e("general", new Gson().toJson(responseBody));
            GeneralUtils.showMessage(registerView.activity, GeneralUtils.getErrorMessage(responseBody));

        } else if (error instanceof SocketTimeoutException) {
            GeneralUtils.showMessage(registerView.activity, "Time out error");
        } else if (error instanceof IOException) {
            GeneralUtils.showMessage(registerView.activity, "Please check your network connection");

        } else {
            GeneralUtils.showMessage(registerView.activity, error.getMessage());
        }
    }

    private void showSuccess(RegisterResponse registerResponse) {
        registerView.showLoading(false);
        if(registerResponse.getStatus().equalsIgnoreCase("Success")){
            /*handle success stuff here*/
        }else {
            /*error handle here */
        }

    }

    public void onDestroy() {
        compositeDisposable.clear();
    }
}
