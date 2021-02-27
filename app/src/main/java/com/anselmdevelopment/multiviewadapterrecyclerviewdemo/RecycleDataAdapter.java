package com.anselmdevelopment.multiviewadapterrecyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        TextView tvSubHeading;

        public SubHeading(View v) {
            super(v);
            this.tvSubHeading = (TextView) v.findViewById(R.id.tvSubHeading);
        }
    }

    public class Item extends RecyclerView.ViewHolder {
        TextView tvItem;

        public Item(View v) {
            super(v);
            this.tvItem = (TextView) v.findViewById(R.id.tvItem);
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
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_main_heading, parent, false);
            return new MainHeading(itemView);
        } else if (viewType == 2) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_sub_heading, parent, false);
            return new SubHeading(itemView);
        } else {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
            return new Item(itemView);
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

            subHeading.tvSubHeading.setText(recycleItem.getText());

            // Else if the type is 3
        } else if (holder.getItemViewType() == 3) {

            final Item itemHolder = (Item) holder;

            itemHolder.tvItem.setText(recycleItem.getText());
        }
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.parseInt(data.get(position).getViewType());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
