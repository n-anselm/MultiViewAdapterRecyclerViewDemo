package com.anselmdevelopment.multiviewadapterrecyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<RecycleItem> data;

    public class MainHeading extends RecyclerView.ViewHolder {
        TextView tvMainHeading;

        public MainHeading(View v) {
            super(v);
            this.tvMainHeading = (TextView) v.findViewById(R.id.tvMainHeading);
        }
    }

    public class SubHeading extends RecyclerView.ViewHolder {
        ImageView ivSubHeading;
        ProgressBar pbSubHeading;

        public SubHeading(View v) {
            super(v);
            this.ivSubHeading = (ImageView) v.findViewById(R.id.ivSubHeading);
            this.pbSubHeading = (ProgressBar) v.findViewById(R.id.pbSubHeading);
        }
    }

    public class ViewCheckBox extends RecyclerView.ViewHolder {
        TextView tvCheckBox;
        ImageView ivCheckBox;
        ProgressBar pbCheckBox;

        public ViewCheckBox(View v) {
            super(v);
            this.tvCheckBox = (TextView) v.findViewById(R.id.tvCheckBox);
            this.ivCheckBox = (ImageView) v.findViewById(R.id.ivCheckBox);
            this.pbCheckBox = (ProgressBar) v.findViewById(R.id.pbCheckBox);
        }
    }

    public RecycleDataAdapter(Context context, ArrayList<RecycleItem> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView;
        if (viewType == 1) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_1st_main_heading, parent, false);
            return new MainHeading(itemView);
        } else if (viewType == 2) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_2nd_sub_heading, parent, false);
            return new SubHeading(itemView);
        } else {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_3rd_item, parent, false);
            return new ViewCheckBox(itemView);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        RecycleItem recycleItem = data.get(position);

        // If the type is 1
        if (holder.getItemViewType() == 1) {

            ((MainHeading) holder).tvMainHeading.setText(recycleItem.getText());

            // Else if the type is 2
        } else if (holder.getItemViewType() == 2) {

            final SubHeading subHeading = (SubHeading) holder;

            subHeading.pbSubHeading.setVisibility(View.VISIBLE);
//            Glide.with(context)
//                    .load(recycleItem.getImage_url())
//                    .fitCenter()
//                    .crossFade()
//                    .listener(new RequestListener<String, GlideDrawable>() {
//                        @Override
//                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//                            if (e instanceof UnknownHostException)
//                                subHeading.second_pb.setVisibility(View.VISIBLE);
//
//                            return false;
//                        }
//
//                        @Override
//                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                            subHeading.second_pb.setVisibility(View.GONE);
//                            subHeading.second_data_iv.setVisibility(View.VISIBLE);
//                            return false;
//                        }
//                    }).into(subHeading.second_data_iv);;

            // Else if the type is 3
        } else if (holder.getItemViewType() == 3) {

            final ViewCheckBox itemHolder = (ViewCheckBox) holder;

            itemHolder.tvCheckBox.setText(recycleItem.getText());

            itemHolder.pbCheckBox.setVisibility(View.VISIBLE);

//            Glide.with(context)
//                    .load(recycleItem.getImage_url())
//                    .fitCenter()
//                    .crossFade()
//                    .listener(new RequestListener<String, GlideDrawable>() {
//                        @Override
//                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//                            if (e instanceof UnknownHostException)
//                                itemHolder.third_pb.setVisibility(View.VISIBLE);
//
//                            return false;
//                        }
//
//                        @Override
//                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                            itemHolder.third_pb.setVisibility(View.GONE);
//                            itemHolder.third_iv.setVisibility(View.VISIBLE);
//                            return false;
//                        }
//                    }).into(itemHolder.third_iv);;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.parseInt(data.get(position).getRow_type());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
