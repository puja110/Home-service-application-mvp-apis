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
import com.doransoft.np.homeservice.model.AllServiceItems;

import java.util.ArrayList;
import java.util.List;

public class Tab1 extends Fragment {

    /*---------------featured items----------------------*/
    RecyclerView allServiceRecyclerView;
    private RecyclerView.LayoutManager asLayoutManager;
    AllServicesAdapter allServicesAdapter;
    List<AllServiceItems> allServiceItems;
    /*---------------------------------------------------*/


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.tab1, container, false);


        /*------------------Service List Items--------------------------*/
        allServiceRecyclerView = (RecyclerView) view.findViewById(R.id.serviceListingRecyclerView);

        allServiceItems = getAllServiceItem();

        allServiceRecyclerView.setHasFixedSize(true);

        asLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        allServiceRecyclerView.setLayoutManager(asLayoutManager);
        allServicesAdapter = new AllServicesAdapter(getActivity(), allServiceItems);
        allServiceRecyclerView.setAdapter(allServicesAdapter);

        /*------------------------------------------------------------*/
        return view;
    }

    private List<AllServiceItems> getAllServiceItem() {
        allServiceItems = new ArrayList<AllServiceItems>();

        allServiceItems.add(new AllServiceItems(R.drawable.repairing, "Home Deep Cleaning"));
        allServiceItems.add(new AllServiceItems(R.drawable.repair, "Home Basic Cleaning"));
        allServiceItems.add(new AllServiceItems(R.drawable.plumber2, "Tank Cleaning Service"));
        allServiceItems.add(new AllServiceItems(R.drawable.plumber, "On Demand Cleaner"));
        allServiceItems.add(new AllServiceItems(R.drawable.repair_mobile, "Home Painting"));
        allServiceItems.add(new AllServiceItems(R.drawable.plumber3, "Home Deep Cleaning"));

        allServiceItems.add(new AllServiceItems(R.drawable.repairing, "Home Deep Cleaning"));
        allServiceItems.add(new AllServiceItems(R.drawable.repair, "Home Basic Cleaning"));
        allServiceItems.add(new AllServiceItems(R.drawable.plumber2, "Tank Cleaning Service"));
        allServiceItems.add(new AllServiceItems(R.drawable.plumber, "On Demand Cleaner"));
        allServiceItems.add(new AllServiceItems(R.drawable.repair_mobile, "Home Painting"));
        allServiceItems.add(new AllServiceItems(R.drawable.plumber3, "Home Deep Cleaning"));

        allServiceItems.add(new AllServiceItems(R.drawable.repair, "Home Basic Cleaning"));
        allServiceItems.add(new AllServiceItems(R.drawable.plumber2, "Tank Cleaning Service"));
        allServiceItems.add(new AllServiceItems(R.drawable.plumber, "On Demand Cleaner"));
        allServiceItems.add(new AllServiceItems(R.drawable.repair_mobile, "Home Painting"));
        allServiceItems.add(new AllServiceItems(R.drawable.plumber3, "Home Deep Cleaning"));

        return allServiceItems;
    }

}
