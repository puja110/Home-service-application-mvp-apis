package com.doransoft.np.homeservice.modules.main.fragments.services;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doransoft.np.homeservice.R;
import com.doransoft.np.homeservice.adapter.ServiceGridAdapter;
import com.doransoft.np.homeservice.model.Service;

import java.util.ArrayList;
import java.util.List;

public class Tab3 extends Fragment {

    private RecyclerView recyclerViewGrid;
    private ServiceGridAdapter serviceAdapter;
    private List<Service> serviceGridList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3, container, false);

        /*-----------------------service grid -------------------------------------*/
        recyclerViewGrid = (RecyclerView) view.findViewById(R.id.tRecyclerGrid);

        serviceGridList = new ArrayList<>();
        serviceAdapter = new ServiceGridAdapter(getContext(), serviceGridList);

        RecyclerView.LayoutManager gLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerViewGrid.setLayoutManager(gLayoutManager);
        recyclerViewGrid.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(0),true));
        recyclerViewGrid.setItemAnimator(new DefaultItemAnimator());
        recyclerViewGrid.setAdapter(serviceAdapter);

        prepareServiceList();
        /*-----------------------service grid -------------------------------------*/

        return view;
    }

    /*-------------------------------Grid Service--------------------------------------*/
    private void prepareServiceList(){
        int[] serviceList = new int[]{
                R.drawable.ic_action_laundry,
                R.drawable.ic_mobile_repair,
                R.drawable.ic_action_computer,
                R.drawable.ic_action_tap,
                R.drawable.ic_action_sanitary,
                R.drawable.ic_action_electric,
                R.drawable.ic_business_idea,
                R.drawable.ic_car_rental,
                R.drawable.ic_mobile_repair,
                R.drawable.ic_action_laundry,
                R.drawable.ic_action_laundry,
                R.drawable.ic_mobile_repair,
                R.drawable.ic_action_computer,
                R.drawable.ic_action_tap,
                R.drawable.ic_action_sanitary,
                R.drawable.ic_action_electric,
        };

        Service s =new Service("Home Appliance", serviceList[1]);
        serviceGridList.add(s);
        s =new Service("Repairing", serviceList[2]);
        serviceGridList.add(s);
        s =new Service("Home Service", serviceList[3]);
        serviceGridList.add(s);
        s =new Service("Plumber", serviceList[4]);
        serviceGridList.add(s);
        s =new Service("Car Rental", serviceList[5]);
        serviceGridList.add(s);
        s =new Service("Home Renovation", serviceList[6]);
        serviceGridList.add(s);
        s =new Service("Gadgets repair", serviceList[7]);
        serviceGridList.add(s);
        s =new Service("Electric", serviceList[8]);
        serviceGridList.add(s);
        s =new Service("Sanitory", serviceList[9]);
        serviceGridList.add(s);
        s =new Service("Plumber", serviceList[10]);
        serviceGridList.add(s);
        s =new Service("Car Rental", serviceList[11]);
        serviceGridList.add(s);
        s =new Service("Home Renovation", serviceList[12]);
        serviceGridList.add(s);
        s =new Service("Gadgets repair", serviceList[13]);
        serviceGridList.add(s);
        s =new Service("Electric", serviceList[14]);
        serviceGridList.add(s);
        s =new Service("Sanitory", serviceList[15]);
        serviceGridList.add(s);

        serviceAdapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration{

        private int spanCount;
        private int spacing;
        private boolean inclidEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean inclidEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.inclidEdge = inclidEdge;
        }

        public void getItemOffsets(Rect outrect, View view, RecyclerView parent, RecyclerView.State state){
            int position = parent.getChildAdapterPosition(view); //item position
            int column = position % spanCount; //item columns

            if (inclidEdge){
                outrect.left = spacing - column * spacing / spanCount;
                outrect.right = (column + 1) * spacing / spanCount;

                if (position < spanCount){
                    outrect.top = spacing;
                }
                outrect.bottom = spacing;
            }else {
                outrect.left = column * spacing / spanCount;
                outrect.right = spacing - (column + 1) * spacing / spanCount;
                if(position>=spanCount){
                    outrect.top = spacing;
                }
            }
        }
    }

    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    /*------------------------------------------------------------------------------------------*/
}
