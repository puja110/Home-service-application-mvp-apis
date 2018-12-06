package com.doransoft.np.homeservice.modules.main.fragments.more.mvp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.doransoft.np.homeservice.R;
import com.doransoft.np.homeservice.modules.main.fragments.more.adapter.CategoryAdapter;
import com.doransoft.np.homeservice.modules.main.fragments.more.adapter.FeaturedProductsAdapter;
import com.doransoft.np.homeservice.modules.main.fragments.more.moreResponse.Message;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoreView extends FrameLayout{

    public AppCompatActivity activity;
    FeaturedProductsAdapter featuredProductsAdapter;
    CategoryAdapter categoryAdapter;

    @BindView(R.id.categoryRecycler)
    RecyclerView categoryRecyclerView;

    @BindView(R.id.featuredProductsRecyclerView)
    RecyclerView recyclerView;

    public MoreView(@NonNull AppCompatActivity activity, FeaturedProductsAdapter featuredProductsAdapter, CategoryAdapter categoryAdapter) {
        super(activity);
        this.activity = activity;
        this.featuredProductsAdapter = featuredProductsAdapter;
        this.categoryAdapter = categoryAdapter;

        inflate(activity, R.layout.fragment_more, this);

        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity,
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(featuredProductsAdapter);


        categoryRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager cLayoutManager = new LinearLayoutManager(activity,
                LinearLayoutManager.HORIZONTAL,
                false);
        categoryRecyclerView.setLayoutManager(cLayoutManager);
        categoryRecyclerView.setItemAnimator(new DefaultItemAnimator());

        categoryRecyclerView.setAdapter(categoryAdapter);

//        fragmentListener = ((HomePageActivity)activity).getInterface();
//

//        shopCatagoryAdapter.setActionListener(catagoryData -> {
//            activity.startActivity(new Intent(activity, SubCatagoryActivity.class).putExtra(Constants.DATA, new ProductObject(Constants.MENU_CATAGORIES, catagoryData)));
//        });

    }

    public void setadapter(List<Message> message) {
        featuredProductsAdapter.showalllist(message);
    }

    public void setCategoryAdapter(List<com.doransoft.np.homeservice.application.network.ProductCategoriesDAO.Message> message) {

        categoryAdapter.showCategoryList(message);

    }
}
