package com.example.testapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.models.Sort;

import java.util.ArrayList;

public class MidChildListAdapter extends RecyclerView.Adapter<MidChildListAdapter.ViewHolder>{

    private ArrayList<Sort> sort;

    // RecyclerView recyclerView;
    public MidChildListAdapter(ArrayList<Sort> sort) {
        this.sort = sort;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_mid_child_model, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Sort myListData = sort.get(position);
        holder.id.setText(myListData.getNarration().toString());
        holder.price.setText(myListData.getAmount().toString());
    }


    @Override
    public int getItemCount() {
        return sort.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id;
        public TextView price;
        public ViewHolder(View itemView) {
            super(itemView);
            this.id = (TextView) itemView.findViewById(R.id.id);
            this.price = (TextView) itemView.findViewById(R.id.price);
        }
    }
}
