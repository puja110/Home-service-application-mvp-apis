package com.doransoft.np.homeservice.modules.main.fragments.serviceDetails.mvp;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.doransoft.np.homeservice.R;
import com.doransoft.np.homeservice.modules.landing.LandingActivity;
import com.doransoft.np.homeservice.modules.loginregister.LoginRegisterActivity;
import com.doransoft.np.homeservice.modules.main.fragments.more.MoreFragment;
import com.doransoft.np.homeservice.modules.main.fragments.search.SearchFragment;
import com.flaviofaria.kenburnsview.KenBurnsView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ServiceDetailView  extends FrameLayout{

    Activity activity;
    Context context;

    private Unbinder unbinder;

    @BindView(R.id.image_background)
    public ImageView sdImage;

    @BindView(R.id.adHeading)
    public TextView sdHeading;

    @BindView(R.id.sdSubHeading)
    public TextView sdSubheading;

    @BindView(R.id.sdPrice)
    public TextView sdPrice;

    @BindView(R.id.sdArrow)
    public ImageView sdArrow;

    @BindView(R.id.book_btn)
    public Button book_btn;

    ProgressDialog mProgressDialog;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ServiceDetailView(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(activity, R.layout.fragment_service_detail, this);
        ButterKnife.bind(this);

        KenBurnsView kbv = (KenBurnsView) findViewById(R.id.image_background);
        book_btn.setOnClickListener(v -> {

            SearchFragment fragment = new SearchFragment();
            FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();

        });

//
//        book_btn.setOnClickListener(v -> {
//
//            MoreFragment fragment = new MoreFragment();
//            FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.frame_container, fragment);
//            transaction.commit();
//
//        });

//        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
//        ((AppCompatActivity)getContext()).setSupportActionBar(toolbar);
//
//        if (((AppCompatActivity)getContext()).getSupportActionBar()!= null)
//            ((AppCompatActivity)getContext()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        toolbar.setTitleTextColor(Color.WHITE);

    }

    public void initializeProgressDialog() {
        /*initalize progress dialog of your choice*/

    }

    public void showLoading(boolean isLoading) {
        if (isLoading) {
            if (mProgressDialog != null && !mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }
        } else {
            if (mProgressDialog != null && mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
            }
        }
    }
}
