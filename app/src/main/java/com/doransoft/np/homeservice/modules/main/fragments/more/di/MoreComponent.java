package com.doransoft.np.homeservice.modules.main.fragments.more.di;


import com.doransoft.np.homeservice.application.di.ApplicationComponent;
import com.doransoft.np.homeservice.modules.main.fragments.more.MoreFragment;

import dagger.Component;

@MoreScope
@Component(modules = MoreModule.class, dependencies = ApplicationComponent.class)
public interface MoreComponent {

    void inject(MoreFragment moreFragment);

}
