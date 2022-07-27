package com.example.testapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MidModelList {
    @SerializedName("sort")
    @Expose
    private ArrayList<Sort> sort = new ArrayList<Sort>();

    public ArrayList<Sort> getSort() {
        return sort;
    }

    public void setSort(ArrayList<Sort> sort) {
        this.sort = sort;
    }
}
