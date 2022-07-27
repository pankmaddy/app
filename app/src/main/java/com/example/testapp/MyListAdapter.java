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

public class MyListAdapter  extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private ArrayList<MidModel> sort;

    // RecyclerView recyclerView;
    public MyListAdapter(ArrayList<MidModel> sort) {
        this.sort = sort;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_mid_model, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MidModel myListData = sort.get(position);
        holder.textView.setText("Mid "+myListData.id.toString());

        /**
         * sort the array based on the mid
         */
        HashMap<String, ArrayList<Sort>> myProgram = new HashMap<>();
        for (int i = 0; i < myListData.list.size(); i++) {
            String date = myListData.list.get(i).getTid().toString();
            ArrayList<Sort> programList = myProgram.get(date);
            if (programList == null) {
                programList = new ArrayList<Sort>();
                myProgram.put(date, programList);
            }
            programList.add(myListData.list.get(i));
        }
        /**
         * group the items based on the mid values
         */
        ArrayList<MidTidModel> models = new ArrayList<>();
        Set<String> values = myProgram.keySet();
        for (String sss : values) {
            if (myProgram.containsKey(sss)) {
                ArrayList<Sort> sorts = myProgram.get(sss);
                MidTidModel midModel = new MidTidModel();
                midModel.tID = sss;
                midModel.list = sorts;
                models.add(midModel);
            }
        }
        MidTidListAdapter adapter= new MidTidListAdapter(models);
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
