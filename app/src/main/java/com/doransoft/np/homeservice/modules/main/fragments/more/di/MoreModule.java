package com.doransoft.np.homeservice.modules.main.fragments.more.di;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.doransoft.np.homeservice.modules.main.fragments.more.adapter.CategoryAdapter;
import com.doransoft.np.homeservice.application.network.AppNetwork;
import com.doransoft.np.homeservice.helper.PreferencesManager;
import com.doransoft.np.homeservice.helper.SchedulerProvider;
import com.doransoft.np.homeservice.modules.main.fragments.more.adapter.FeaturedProductsAdapter;
import com.doransoft.np.homeservice.modules.main.fragments.more.mvp.MoreModel;
import com.doransoft.np.homeservice.modules.main.fragments.more.mvp.MorePresenter;
import com.doransoft.np.homeservice.modules.main.fragments.more.mvp.MoreView;

import dagger.Module;
import dagger.Provides;

@Module
public class MoreModule {

    private final AppCompatActivity activity;

    public MoreModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @MoreScope
    @Provides
    public MoreView moreView(FeaturedProductsAdapter featuredProductsAdapter, CategoryAdapter categoryAdapter) {
        return new MoreView(activity, featuredProductsAdapter, categoryAdapter);
    }

    @MoreScope
    @Provides
    public MoreModel moreModel(AppNetwork appNetwork, PreferencesManager preferencesManager) {
        return new MoreModel(activity, appNetwork, preferencesManager);
    }


    @MoreScope
    @Provides
    public MorePresenter morePresenter(Activity activity,MoreView moreView, MoreModel moreModel, SchedulerProvider schedulerProvider) {
        return new MorePresenter(activity,moreView, moreModel,schedulerProvider);
    }

    @MoreScope
    @Provides
    public FeaturedProductsAdapter featuredProductsAdapter() {
        return new FeaturedProductsAdapter(activity);
    }

    @MoreScope
    @Provides
    public  CategoryAdapter categoryAdapter(){
        return new CategoryAdapter(activity);
    }

}
