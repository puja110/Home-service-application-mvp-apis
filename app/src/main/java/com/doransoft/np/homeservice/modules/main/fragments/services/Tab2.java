package com.doransoft.np.homeservice.modules.main.fragments.services;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doransoft.np.homeservice.R;
import com.doransoft.np.homeservice.adapter.AllServicesAdapter;
import com.doransoft.np.homeservice.adapter.SeeAllServicesAdapter;
import com.doransoft.np.homeservice.model.AllServiceItems;
import com.doransoft.np.homeservice.model.SeeAllServiceItems;

import java.util.ArrayList;
import java.util.List;

public class Tab2 extends Fragment {

    /*---------------see all services----------------------*/
    RecyclerView seeAllServiceRecyclerView;
    private RecyclerView.LayoutManager seeAllLayoutManager;
    SeeAllServicesAdapter seeAllServicesAdapter;
    List<SeeAllServiceItems> seeAllServiceItems;
    /*---------------------------------------------------*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2, container, false);

        /*------------------see all service List --------------------------*/
        seeAllServiceRecyclerView = (RecyclerView) view.findViewById(R.id.seeAllRecyclerView);

        seeAllServiceItems = getSeeAllServiceItem();

        seeAllServiceRecyclerView.setHasFixedSize(true);

        seeAllLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        seeAllServiceRecyclerView.setLayoutManager(seeAllLayoutManager);
        seeAllServicesAdapter = new SeeAllServicesAdapter(getActivity(), seeAllServiceItems);
        seeAllServiceRecyclerView.setAdapter(seeAllServicesAdapter);

        /*------------------------------------------------------------*/
        return view;
    }

    private List<SeeAllServiceItems> getSeeAllServiceItem() {
        seeAllServiceItems = new ArrayList<SeeAllServiceItems>();

        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.repairing, "AC Check Up","Ac Service and Repair","ADD"));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.repair_mobile, "Mobile Check Up","Mobile Repair","ADD"));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber, "Plumbing","Plumbing service","ADD"));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber3, "Home Appliance","Home Service and Repair","ADD"));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.repair, "Car Rental","Car Rental","ADD"));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber, "AC Check Up","Ac Service and Repair","ADD"));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber1, "AC Check Up","Ac Service and Repair","ADD"));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.repairing, "AC Check Up","Ac Service and Repair","ADD"));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber2, "AC Check Up","Ac Service and Repair","ADD"));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.repair_mobile, "AC Check Up","Ac Service and Repair","ADD"));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber1, "AC Check Up","Ac Service and Repair","ADD"));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber, "AC Check Up","Ac Service and Repair","ADD"));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.repair_mobile, "AC Check Up","Ac Service and Repair","ADD"));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.repairing, "AC Check Up","Ac Service and Repair","ADD"));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber3, "AC Check Up","Ac Service and Repair","ADD"));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.plumber2, "AC Check Up","Ac Service and Repair","ADD"));
        seeAllServiceItems.add(new SeeAllServiceItems(R.drawable.repair_mobile, "AC Check Up","Ac Service and Repair","ADD"));


        return seeAllServiceItems;
    }
}
