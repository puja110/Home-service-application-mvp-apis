package com.doransoft.np.homeservice.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.doransoft.np.homeservice.R;
import com.doransoft.np.homeservice.model.SeeAllServiceItems;

import java.util.List;

public class SeeAllServicesAdapter extends RecyclerView.Adapter<SeeAllServicesAdapter.MyViewHolder> {

    private List<SeeAllServiceItems> itemList;
    Activity context;

    public SeeAllServicesAdapter(Activity context, List<SeeAllServiceItems> itemList) {
            this.itemList = itemList;
            this.context = context;
            }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView seeAllServicesTitle;
        private ImageView seeAllServicesImage;
        private TextView seeAllServicesSubtitle;
        private TextView seeAllServicesButton;

        public MyViewHolder(View view) {
            super(view);

            seeAllServicesImage = (ImageView) view.findViewById(R.id.seeAllServicesImage);
            seeAllServicesTitle = (TextView) view.findViewById(R.id.seeAllServicesTitle);
            seeAllServicesSubtitle = (TextView) view.findViewById(R.id.subtitle);
            seeAllServicesButton = (TextView) view.findViewById(R.id.seeAllServicesBtn);
        }
    }

        @Override
        public SeeAllServicesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.items_see_all_services, parent, false);
            return new SeeAllServicesAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(SeeAllServicesAdapter.MyViewHolder holder, final int position) {

            final SeeAllServiceItems items = itemList.get(position);
            holder.seeAllServicesImage.setImageResource(items.getSeeAllServicesImage());
            holder.seeAllServicesTitle.setText(items.getSeeAllServicesTitle());
            holder.seeAllServicesSubtitle.setText(items.getSeeAllServicesSubtitle());
            holder.seeAllServicesButton.setText(items.getSeeAllServicesButton());
        }

        @Override
        public int getItemCount() {
            return this.itemList.size();
        }

    }


