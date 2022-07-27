package com.example.testapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sort {
    @SerializedName("Mid")
    @Expose
    private Integer mid;
    @SerializedName("Tid")
    @Expose
    private Integer tid;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("narration")
    @Expose
    private Long narration;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getNarration() {
        return narration;
    }

    public void setNarration(Long narration) {
        this.narration = narration;
    }

}
