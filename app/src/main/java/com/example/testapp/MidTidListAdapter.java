package com.example.testapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.models.MidModel;
import com.example.testapp.models.MidTidModel;
import com.example.testapp.models.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MidTidListAdapter extends RecyclerView.Adapter<MidTidListAdapter.ViewHolder>{
    private ArrayList<MidTidModel> sort;

    // RecyclerView recyclerView;
    public MidTidListAdapter(ArrayList<MidTidModel> sort) {
        this.sort = sort;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_mid_header_model, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MidTidModel myListData = sort.get(position);
        holder.textView.setText("TID "+myListData.tID.toString());
        MidChildListAdapter adapter= new MidChildListAdapter(myListData.list);
        holder.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        holder.textView.setOnClickListener(view -> {
            if(holder.recyclerView.getVisibility()==View.VISIBLE){
                holder.recyclerView.setVisibility(View.GONE);
            }else{
                holder.recyclerView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sort.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public RecyclerView recyclerView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.header);
            this.recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        }
    }
}
