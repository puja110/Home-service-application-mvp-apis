package com.doransoft.np.homeservice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.doransoft.np.homeservice.R;
import com.doransoft.np.homeservice.model.Service;

import java.util.List;

public class ServiceGridAdapter extends RecyclerView.Adapter<ServiceGridAdapter.MyViewHolder> {

    private Context mContext;
    private List<Service> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);
            title =(TextView) itemView.findViewById(R.id.title);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        }
    }

    public ServiceGridAdapter(Context mContext, List<Service> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_service_grid, parent, false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final ServiceGridAdapter.MyViewHolder holder, int position) {
        Service album = albumList.get(position);
        holder.title.setText(album.getName());

        //locating album cover using glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
