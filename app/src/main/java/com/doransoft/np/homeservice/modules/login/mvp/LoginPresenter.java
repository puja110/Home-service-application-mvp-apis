package com.doransoft.np.homeservice.modules.login.mvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.doransoft.np.homeservice.helper.Constants;
import com.doransoft.np.homeservice.helper.SchedulerProvider;
import com.doransoft.np.homeservice.modules.forgetpassword.ForgotPasswordActivity;
import com.doransoft.np.homeservice.modules.login.pojo.LoginResponse;
import com.doransoft.np.homeservice.modules.main.MainActivity;
import com.doransoft.np.homeservice.util.GeneralUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.SocketTimeoutException;

import io.reactivex.disposables.CompositeDisposable;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class LoginPresenter {
    AppCompatActivity activity;
    SchedulerProvider schedulerProvider;
    LoginView loginView;
    LoginInteractor loginInteractor;
    CompositeDisposable  compositeDisposable = new CompositeDisposable();

    public LoginPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, LoginView loginView, LoginInteractor loginInteractor) {
        this.activity = activity;
        this.schedulerProvider = schedulerProvider;
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    public void onViewCreated() {
        loginView.mLoginbutton.setOnClickListener(view -> {
            if(TextUtils.isEmpty(loginView.mEmail.getText().toString())){
                /*POPUOP ERROR MESSAGE HERE*/
            } else  if(TextUtils.isEmpty(loginView.mPassword.getText().toString())){
                /*POPUOP ERROR MESSAGE HERE*/
            }else {
                requestLogin(loginView.mEmail.getText().toString(),loginView.mPassword.getText().toString());
            }
        });

        loginView.mForgotbutton.setOnClickListener(v -> {
            activity.startActivity(new Intent(activity, ForgotPasswordActivity.class));
        });
    }

    private void requestLogin(String email, String password) {
        activity.startActivity(new Intent(activity, MainActivity.class));
//        loginView.showLoading(true);
//        compositeDisposable.add(loginInteractor.getLoginData(email,password)
//        .subscribeOn(schedulerProvider.io())
//        .observeOn(schedulerProvider.ui())
//        .subscribe(this::showSuccess,this::showError));
    }

    private void showError(Throwable error) {
        loginView.showLoading(false);
        if (error instanceof HttpException) {
            ResponseBody responseBody = ((HttpException) error).response().errorBody();
            Log.e("general", new Gson().toJson(responseBody));
            GeneralUtils.showMessage(loginView.activity, GeneralUtils.getErrorMessage(responseBody));

        } else if (error instanceof SocketTimeoutException) {
            GeneralUtils.showMessage(loginView.activity, "Time out error");
        } else if (error instanceof IOException) {
            GeneralUtils.showMessage(loginView.activity, "Please check your network connection");

        } else {
            GeneralUtils.showMessage(loginView.activity, error.getMessage());
        }
    }

    private void showSuccess(LoginResponse loginResponse) {
        loginView.showLoading(false);
        if(loginResponse.getStatus().equalsIgnoreCase("Success")){
            /*handle success stuff here*/
        }else {
            /*error handle here */
        }

    }

    public void onDestroy() {
        compositeDisposable.clear();
    }
}
