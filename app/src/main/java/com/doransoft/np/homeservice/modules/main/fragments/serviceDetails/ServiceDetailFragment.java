package com.doransoft.np.homeservice.modules.main.fragments.serviceDetails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doransoft.np.homeservice.application.di.MainApplication;
import com.doransoft.np.homeservice.modules.main.fragments.serviceDetails.di.DaggerServiceDetailsComponent;
import com.doransoft.np.homeservice.modules.main.fragments.serviceDetails.di.ServiceDetailModule;
import com.doransoft.np.homeservice.modules.main.fragments.serviceDetails.mvp.ServiceDetailPresenter;
import com.doransoft.np.homeservice.modules.main.fragments.serviceDetails.mvp.ServiceDetailView;

import javax.inject.Inject;

public class ServiceDetailFragment extends Fragment {

    @Inject
    ServiceDetailView  serviceDetailView;

    @Inject
    ServiceDetailPresenter serviceDetailPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        DaggerServiceDetailsComponent.builder().applicationComponent(MainApplication.get(getActivity()).getApplicationComponent()).serviceDetailModule(new ServiceDetailModule((AppCompatActivity) getActivity())).build().inject(this);

        serviceDetailPresenter.onViewCreated();

        return serviceDetailView;
    }
}
