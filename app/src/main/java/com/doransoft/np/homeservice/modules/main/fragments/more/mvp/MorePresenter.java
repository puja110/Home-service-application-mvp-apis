package com.doransoft.np.homeservice.modules.main.fragments.more.mvp;

import android.widget.ImageView;

import com.doransoft.np.homeservice.helper.SchedulerProvider;
import com.doransoft.np.homeservice.modules.main.fragments.more.moreResponse.FeaturedProducts;

import io.reactivex.disposables.CompositeDisposable;

public class MorePresenter {

    private final MoreView moreView;
    private final MoreModel moreModel;
    SchedulerProvider schedulerProvider;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MorePresenter(MoreView moreView, MoreModel moreModel, SchedulerProvider schedulerProvider) {
        this.moreView = moreView;
        this.moreModel = moreModel;
        this.schedulerProvider = schedulerProvider;
    }

    public void onCreateView() {
        apiCall();
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

    private void onerror(Throwable throwable) {


    }

    private void onsuccess(FeaturedProducts featuredProducts) {

        if (featuredProducts.getStatus() == true){

            if (featuredProducts.getMessage() != null)
            {
                moreView.setadapter(featuredProducts.getMessage());
            }
        }

    }
}

