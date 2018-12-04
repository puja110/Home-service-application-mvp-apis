package com.doransoft.np.homeservice.modules.main.fragments.serviceDetails.mvp;

import android.app.Activity;
import android.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.doransoft.np.homeservice.R;
import com.doransoft.np.homeservice.helper.SchedulerProvider;
import com.doransoft.np.homeservice.modules.forgetpassword.ForgotPasswordActivity;
import com.doransoft.np.homeservice.modules.main.fragments.more.MoreFragment;
import com.doransoft.np.homeservice.modules.main.fragments.search.SearchFragment;

import io.reactivex.disposables.CompositeDisposable;

public class ServiceDetailPresenter {

    AppCompatActivity activity;
    Activity context;

    Fragment fragment;
    SchedulerProvider schedulerProvider;
    ServiceDetailView serviceDetailView;
    ServiceDetailInteractor serviceDetailInteractor;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ServiceDetailPresenter(AppCompatActivity activity, SchedulerProvider schedulerProvider, ServiceDetailView serviceDetailView, ServiceDetailInteractor serviceDetailInteractor) {
        this.activity = activity;
        this.schedulerProvider = schedulerProvider;
        this.serviceDetailView = serviceDetailView;
        this.serviceDetailInteractor = serviceDetailInteractor;
    }


    public void onViewCreated() {

//        serviceDetailView.book_btn.setOnClickListener(v -> {
//
//            SearchFragment fragment = new SearchFragment();
//            FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.frame_container, fragment);
//            transaction.addToBackStack(null);
//            transaction.commit();
//
//        });

    }
}
