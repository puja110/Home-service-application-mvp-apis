package com.doransoft.np.homeservice.application.di.modules;


import com.doransoft.np.homeservice.application.di.AppScope;
import com.doransoft.np.homeservice.helper.AppTypeAdapterFactory;
import com.fatboyindustrial.gsonjodatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;

@Module
public class GsonModule {

    @Provides
    @AppScope
    public Gson gson()
    {
        return Converters.registerAll(new GsonBuilder())
//                .registerTypeAdapterFactory(AppTypeAdapterFactory.create())
                .setLenient()
                .create();
    }

}
