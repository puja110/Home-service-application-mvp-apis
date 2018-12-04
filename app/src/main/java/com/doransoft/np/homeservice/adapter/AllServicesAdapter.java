package com.doransoft.np.homeservice.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.doransoft.np.homeservice.R;
import com.doransoft.np.homeservice.model.AllServiceItems;

import java.util.List;

public class AllServicesAdapter extends RecyclerView.Adapter<AllServicesAdapter.MyViewHolder> {

    private List<AllServiceItems> itemList;
    Activity context;

    public AllServicesAdapter(Activity context, List<AllServiceItems> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView allServicesTitle;
        private ImageView allServicesImage;

        public MyViewHolder(View view) {
            super(view);

            allServicesImage = (ImageView) view.findViewById(R.id.allServicesImage);
            allServicesTitle = (TextView) view.findViewById(R.id.allServicesTitle);
        }
    }

    @Override
    public AllServicesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_all_services, parent, false);
        return new AllServicesAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AllServicesAdapter.MyViewHolder holder, final int position) {

        final AllServiceItems items = itemList.get(position);
        holder.allServicesImage.setImageResource(items.getAllServicesImage());
        holder.allServicesTitle.setText(items.getAllServicesTitle());

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                transport("card");
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

}

