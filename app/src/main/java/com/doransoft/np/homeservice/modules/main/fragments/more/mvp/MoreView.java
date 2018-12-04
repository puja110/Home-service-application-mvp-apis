package com.doransoft.np.homeservice.modules.main.fragments.more.mvp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.doransoft.np.homeservice.R;
import com.doransoft.np.homeservice.adapter.ServiceListAdapter;
import com.doransoft.np.homeservice.modules.main.fragments.more.adapter.FeaturedProductsAdapter;
import com.doransoft.np.homeservice.modules.main.fragments.more.moreResponse.Message;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoreView extends FrameLayout{

    public AppCompatActivity activity;
    FeaturedProductsAdapter featuredProductsAdapter;

    @BindView(R.id.featuredProductsRecyclerView)
    RecyclerView recyclerView;

    public MoreView(@NonNull AppCompatActivity activity, FeaturedProductsAdapter featuredProductsAdapter) {
        super(activity);
        this.activity = activity;
        this.featuredProductsAdapter = featuredProductsAdapter;

        inflate(activity, R.layout.fragment_more, this);

        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity,
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(featuredProductsAdapter);


//        fragmentListener = ((HomePageActivity)activity).getInterface();
//

//        shopCatagoryAdapter.setActionListener(catagoryData -> {
//            activity.startActivity(new Intent(activity, SubCatagoryActivity.class).putExtra(Constants.DATA, new ProductObject(Constants.MENU_CATAGORIES, catagoryData)));
//        });

    }

    public void setadapter(List<Message> message) {
        featuredProductsAdapter.showalllist(message);
    }
}
