package com.doransoft.np.homeservice.modules.main.fragments.more.di;

import android.support.v7.app.AppCompatActivity;

import com.doransoft.np.homeservice.adapter.ServiceListAdapter;
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
    public MoreView moreView(FeaturedProductsAdapter featuredProductsAdapter) {
        return new MoreView(activity, featuredProductsAdapter);
    }

    @MoreScope
    @Provides
    public MoreModel moreModel(AppNetwork appNetwork, PreferencesManager preferencesManager) {
        return new MoreModel(activity, appNetwork, preferencesManager);
    }


    @MoreScope
    @Provides
    public MorePresenter morePresenter(MoreView moreView, MoreModel moreModel, SchedulerProvider schedulerProvider) {
        return new MorePresenter(moreView, moreModel,schedulerProvider);
    }

    @MoreScope
    @Provides
    public FeaturedProductsAdapter featuredProductsAdapter() {
        return new FeaturedProductsAdapter(activity);
    }

}
