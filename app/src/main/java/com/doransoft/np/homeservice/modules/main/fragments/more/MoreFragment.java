package com.doransoft.np.homeservice.modules.main.fragments.more;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doransoft.np.homeservice.MainApplication;
import com.doransoft.np.homeservice.application.di.ApplicationComponent;
import com.doransoft.np.homeservice.modules.main.fragments.more.di.DaggerMoreComponent;
import com.doransoft.np.homeservice.modules.main.fragments.more.di.MoreModule;
import com.doransoft.np.homeservice.modules.main.fragments.more.mvp.MorePresenter;
import com.doransoft.np.homeservice.modules.main.fragments.more.mvp.MoreView;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {

    private ApplicationComponent appComponent;

    @Inject
    MorePresenter morePresenter;

    @Inject
    MoreView moreView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DaggerMoreComponent.builder()
                .applicationComponent(MainApplication.get(getActivity()).getApplicationComponent())
                .moreModule(new MoreModule((AppCompatActivity) getActivity()))
                .build()
                .inject(this);


        morePresenter.onCreateView();

        return moreView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        morePresenter.onDestroyView();
    }


    @Override
    public void onResume() {
        super.onResume();
    }


//    /*---------------featured items----------------------*/
//    RecyclerView serviceListRecyclerView;
//    private RecyclerView.LayoutManager sLayoutManager;
//    ServiceListAdapter serviceListAdapter;
//    List<ServiceListItems> serviceListItems;
//    /*---------------------------------------------------*/

//    public MoreFragment() {
//        // Required empty public constructor
//    }

//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_more, container, false);

//        /*------------------Service List Items--------------------------*/
//        serviceListRecyclerView = (RecyclerView) view.findViewById(R.id.serviceListRecyclerView);
//
//        serviceListItems = getserviceListItem();
//
//        serviceListRecyclerView.setHasFixedSize(true);
//
//        sLayoutManager = new LinearLayoutManager(
//                getContext(),
//                LinearLayoutManager.VERTICAL,
//                false
//        );
//        serviceListRecyclerView.setLayoutManager(sLayoutManager);
//        serviceListAdapter = new ServiceListAdapter(getActivity(), serviceListItems);
//        serviceListRecyclerView.setAdapter(serviceListAdapter);
//
//        /*------------------------------------------------------------*/

//        return view;
//    }
//    private List<ServiceListItems> getserviceListItem() {
//        serviceListItems = new ArrayList<ServiceListItems>();
//
//        serviceListItems.add(new ServiceListItems(R.drawable.plumber, "Home Deep Cleaning"));
//        serviceListItems.add(new ServiceListItems(R.drawable.repair_mobile, "Home Basic Cleaning"));
//        serviceListItems.add(new ServiceListItems(R.drawable.plumber1, "Tank Cleaning Service"));
//        serviceListItems.add(new ServiceListItems(R.drawable.repair, "Pest Control Service"));
//        serviceListItems.add(new ServiceListItems(R.drawable.plumber2, "On Demand Cleaner"));
//        serviceListItems.add(new ServiceListItems(R.drawable.repairing, "Home Painting"));
//
//        return serviceListItems;
//    }
}
