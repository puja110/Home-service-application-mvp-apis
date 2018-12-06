package com.doransoft.np.homeservice.modules.main.fragments.more.mvp;

import android.support.v7.app.AppCompatActivity;

import com.doransoft.np.homeservice.R;
import com.doransoft.np.homeservice.application.network.AppNetwork;
import com.doransoft.np.homeservice.application.network.ProductCategoriesDAO.ProductCategories;
import com.doransoft.np.homeservice.helper.PreferencesManager;
import com.doransoft.np.homeservice.modules.main.fragments.more.moreResponse.FeaturedProducts;

import io.reactivex.Observable;

public class MoreModel {

    private final AppNetwork appNetwork;
    private AppCompatActivity activity;
    private final PreferencesManager preferencesManager;

    public MoreModel(AppCompatActivity activity, AppNetwork appNetwork, PreferencesManager preferencesManager) {
        this.appNetwork =  appNetwork;
        this.activity = activity;
        this.preferencesManager = preferencesManager;
    }

    /*get the features list */
    public Observable<FeaturedProducts> getFeaturedList() {
        return appNetwork.getFeaturedList(activity.getResources().getString(R.string.securitykey));
    }

    /*get the features list */
    public Observable<ProductCategories> getCategoryList() {
        return appNetwork.getProductCategoryList(activity.getResources().getString(R.string.securitykey));
    }

}
