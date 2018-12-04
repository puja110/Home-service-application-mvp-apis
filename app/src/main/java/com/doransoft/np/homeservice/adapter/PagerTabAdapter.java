package com.doransoft.np.homeservice.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.doransoft.np.homeservice.modules.main.fragments.services.Tab1;
import com.doransoft.np.homeservice.modules.main.fragments.services.Tab2;
import com.doransoft.np.homeservice.modules.main.fragments.services.Tab3;
import com.doransoft.np.homeservice.modules.main.fragments.services.Tab4;
import com.doransoft.np.homeservice.modules.main.fragments.services.Tab5;
import com.doransoft.np.homeservice.modules.main.fragments.services.Tab6;

public class PagerTabAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public PagerTabAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //initializing tabCount variable
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Tab1 tab1 = new Tab1();
                return tab1;
            case 1:
                Tab2 tab2 = new Tab2();
                return  tab2;
            case 2:
                Tab3 tab3 = new  Tab3();
                return  tab3;
            case 3:
                Tab4 tab4 = new Tab4();
                return tab4;
            case 4:
                Tab5 tab5 = new Tab5();
                return  tab5;
            case 5:
                Tab6 tab6 = new  Tab6();
                return  tab6;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;

    }
}
