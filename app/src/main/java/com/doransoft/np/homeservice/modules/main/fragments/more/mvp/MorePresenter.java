package com.doransoft.np.homeservice.modules.main.fragments.more.mvp;

import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.doransoft.np.homeservice.application.network.ProductCategoriesDAO.ProductCategories;
import com.doransoft.np.homeservice.helper.SchedulerProvider;
import com.doransoft.np.homeservice.modules.main.fragments.more.moreResponse.FeaturedProducts;
import com.google.gson.Gson;

import io.reactivex.disposables.CompositeDisposable;

public class MorePresenter {

    private final MoreView moreView;
    private final MoreModel moreModel;
    SchedulerProvider schedulerProvider;
    Activity activity;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MorePresenter(Activity activity,MoreView moreView, MoreModel moreModel, SchedulerProvider schedulerProvider) {
        this.activity = activity;
        this.moreView = moreView;
        this.moreModel = moreModel;
        this.schedulerProvider = schedulerProvider;
    }

    public void onCreateView() {
        apiCall();
        apiProductCategoryCall();
    }

    public void onDestroyView() {
        compositeDisposable.clear();
    }

    public void apiCall(){

        compositeDisposable.add(moreModel.getFeaturedList()
        .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
        .subscribe(this::onsuccess,this::onerror));
    }

    private void apiProductCategoryCall(){

        compositeDisposable.add(moreModel.getCategoryList()
        .subscribeOn(schedulerProvider.io())
        .observeOn(schedulerProvider.ui())
        .subscribe(this::onSuccessCategory, this::onerror));
    }

    private void onerror(Throwable throwable) {

//        Toast.makeText(moreView.activity, "Errorrrrrrrrrrrrrr", Toast.LENGTH_SHORT).show();
    }

    private void onsuccess(FeaturedProducts featuredProducts) {

        if (featuredProducts.getStatus() == true){

            if (featuredProducts.getMessage() != null)
            {
                moreView.setadapter(featuredProducts.getMessage());
            }
        }
    }

    private  void onSuccessCategory(ProductCategories productCategories){

        Log.e("success",new Gson().toJson(productCategories));

        if (productCategories.getStatus() == true){

            if (productCategories.getMessage() != null)
            {
                moreView.setCategoryAdapter(productCategories.getMessage());
            }
        }
    }
}

