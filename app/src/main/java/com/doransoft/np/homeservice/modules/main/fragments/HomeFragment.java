package com.doransoft.np.homeservice.modules.main.fragments;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.doransoft.np.homeservice.R;
import com.doransoft.np.homeservice.adapter.FeaturedServiceAdapter;
import com.doransoft.np.homeservice.adapter.PopularServiceAdapter;
import com.doransoft.np.homeservice.adapter.ServiceAdapter;
import com.doransoft.np.homeservice.adapter.ServiceGridAdapter;
import com.doransoft.np.homeservice.adapter.TrendingServiceAdapter;
import com.doransoft.np.homeservice.model.FeaturedServiceItems;
import com.doransoft.np.homeservice.model.PopularServiceItems;
import com.doransoft.np.homeservice.model.Service;
import com.doransoft.np.homeservice.model.ServiceItems;
import com.doransoft.np.homeservice.model.TrendingServiceItems;
import com.doransoft.np.homeservice.modules.main.fragments.services.Tab3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment {

    Unbinder unbinder;

    @BindView(R.id.search)
    EditText search;

    @BindView(R.id.textview_service)
    TextView textview_service;

    @BindView(R.id.textview_trending)
    TextView textview_trending;

    @BindView(R.id.see_all_one)
    TextView see_all_one;

    @BindView(R.id.see_all_two)
    TextView see_all_two;

    //slider
    private SliderLayout mDemoSlider;
    private LinearLayout mLinearLayout;

    /*---------------service items----------------------*/

    private RecyclerView recyclerViewGrid;
    private ServiceGridAdapter serviceAdapter;
    private List<Service> serviceGridList;
    /*--------------- service items----------------------*/

    /*---------------circle service items----------------------*/
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    ServiceAdapter adapter;
    List<ServiceItems> allItems;
    /*---------------------------------------------------*/

    /*---------------Trending items----------------------*/
    RecyclerView trendingRecyclerView;
    private RecyclerView.LayoutManager tLayoutManager;
    TrendingServiceAdapter trendingAdapter;
    List<TrendingServiceItems> trendingItems;
    /*---------------------------------------------------*/

    /*---------------Popular items----------------------*/
    RecyclerView popularRecyclerView;
    private RecyclerView.LayoutManager pLayoutManager;
    PopularServiceAdapter popularAdapter;
    List<PopularServiceItems> popularItems;
    /*---------------------------------------------------*/

    /*---------------featured items----------------------*/
    RecyclerView featuredRecyclerView;
    private RecyclerView.LayoutManager fLayoutManager;
    FeaturedServiceAdapter featuredAdapter;
    List<FeaturedServiceItems> featuredItems;
    /*---------------------------------------------------*/

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // bind view using butter knife
        unbinder = ButterKnife.bind(this, view);

        //hide the soft keyboard from inside a fragment
        getActivity().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //slider
        mDemoSlider = (SliderLayout)view.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.pagesContainer);
        setupSlider();


        /*-----------------------service grid -------------------------------------*/
        recyclerViewGrid = (RecyclerView) view.findViewById(R.id.recyclerGrid);

        serviceGridList = new ArrayList<>();
        serviceAdapter = new ServiceGridAdapter(getContext(), serviceGridList);

        RecyclerView.LayoutManager gLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerViewGrid.setLayoutManager(gLayoutManager);
        recyclerViewGrid.addItemDecoration(new HomeFragment.GridSpacingItemDecoration(3, dpToPx(0),true));
        recyclerViewGrid.setItemAnimator(new DefaultItemAnimator());
        recyclerViewGrid.setAdapter(serviceAdapter);

        prepareServiceList();
        /*-----------------------service grid -------------------------------------*/

        /*-----------------------Circle image-------------------------------------*/
        recyclerView = (RecyclerView) view.findViewById(R.id.serviceRecyclerView);

        allItems = getAllItemList();

        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        adapter = new ServiceAdapter(getActivity(), allItems);
        recyclerView.setAdapter(adapter);
        /*------------------------------------------------------------*/

        /*------------------Trending Items--------------------------*/
        trendingRecyclerView = (RecyclerView) view.findViewById(R.id.trendingServiceRecyclerView);

        trendingItems = getTrendingServiceItem();

        trendingRecyclerView.setHasFixedSize(true);

        tLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        trendingRecyclerView.setLayoutManager(tLayoutManager);
        trendingAdapter = new TrendingServiceAdapter(getActivity(), trendingItems);
        trendingRecyclerView.setAdapter(trendingAdapter);

        /*------------------------------------------------------------*/

        /*------------------Popular Items--------------------------*/
       popularRecyclerView = (RecyclerView) view.findViewById(R.id.popularRecyclerView);

        popularItems = getPopularServiceItem();

        popularRecyclerView.setHasFixedSize(true);

        pLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        popularRecyclerView.setLayoutManager(pLayoutManager);
        popularAdapter = new PopularServiceAdapter(getActivity(), popularItems);
        popularRecyclerView.setAdapter(popularAdapter);

        /*------------------------------------------------------------*/

        /*------------------Featured Items--------------------------*/
        featuredRecyclerView = (RecyclerView) view.findViewById(R.id.featuredServiceRecyclerView);

        featuredItems = getFeaturedServiceItem();

        featuredRecyclerView.setHasFixedSize(true);

        fLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        featuredRecyclerView.setLayoutManager(fLayoutManager);
        featuredAdapter = new FeaturedServiceAdapter(getActivity(), featuredItems);
        featuredRecyclerView.setAdapter(featuredAdapter);

        /*------------------------------------------------------------*/

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

    private List<ServiceItems> getAllItemList() {
        allItems = new ArrayList<ServiceItems>();


        allItems.add(new ServiceItems(R.drawable.group138, "Plumber"));
        allItems.add(new ServiceItems(R.drawable.group136, "Washing"));
        allItems.add(new ServiceItems(R.drawable.group137, "Repair"));
        allItems.add(new ServiceItems(R.drawable.group135, "Plumber"));

        allItems.add(new ServiceItems(R.drawable.group137, "Repair"));
        allItems.add(new ServiceItems(R.drawable.group135, "Plumber"));

        allItems.add(new ServiceItems(R.drawable.group138, "Washing"));
        allItems.add(new ServiceItems(R.drawable.group135, "Repair"));
        allItems.add(new ServiceItems(R.drawable.group137, "Repair"));
        allItems.add(new ServiceItems(R.drawable.group135, "Plumber"));

        return allItems;
    }

    public List<TrendingServiceItems> getTrendingServiceItem(){
        trendingItems = new ArrayList<TrendingServiceItems>();

        trendingItems.add(new TrendingServiceItems(R.drawable.plumber2, "Home Wall Cleaning", "Starting from", "Rs 1000"));
        trendingItems.add(new TrendingServiceItems(R.drawable.repairing, "Home Wall Cleaning", "Starting from", "Rs 1000"));
        trendingItems.add(new TrendingServiceItems(R.drawable.plumber3, "Home Wall Cleaning", "Starting from", "Rs 1000"));
        trendingItems.add(new TrendingServiceItems(R.drawable.repair, "Home Wall Cleaning", "Starting from", "Rs 1000"));

        return trendingItems;
    }

    public List<PopularServiceItems>  getPopularServiceItem(){
        popularItems = new ArrayList<PopularServiceItems>();

        popularItems.add(new PopularServiceItems(R.drawable.plumber));
        popularItems.add(new PopularServiceItems(R.drawable.repair_mobile));
        popularItems.add(new PopularServiceItems(R.drawable.plumber1));
        popularItems.add(new PopularServiceItems(R.drawable.repairing));

        return popularItems;
    }

    private List<FeaturedServiceItems> getFeaturedServiceItem() {
        featuredItems = new ArrayList<FeaturedServiceItems>();

        featuredItems.add(new FeaturedServiceItems(R.drawable.plumber1, "Home Wall Cleaning"));
        featuredItems.add(new FeaturedServiceItems(R.drawable.repair_mobile, "Home Electrician"));
        featuredItems.add(new FeaturedServiceItems(R.drawable.repairing, "Dining Table Setup"));
        featuredItems.add(new FeaturedServiceItems(R.drawable.repair, "Repairing"));
        featuredItems.add(new FeaturedServiceItems(R.drawable.plumber, "Washing"));
        featuredItems.add(new FeaturedServiceItems(R.drawable.plumber3, "Home Painting"));

        return featuredItems;
    }

    //slider
    private void setupSlider() {
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Cleaning",R.drawable.repair_mobile);
        file_maps.put("Repair",R.drawable.plumber3);
        file_maps.put("Washing",R.drawable.repairing);
        file_maps.put("Plumber", R.drawable.plumber1);
        file_maps.put("Repair", R.drawable.plumber);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Top);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(1000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // unbind the view to free some memory
        unbinder.unbind();
    }
}
