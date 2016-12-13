package com.belong.model;

public class Review {
    private Integer vid;

    private String vamount;

    public Review(Integer vid, String vamount) {
        this.vid = vid;
        this.vamount = vamount;
    }

    public Review() {
        super();
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getVamount() {
        return vamount;
    }

    public void setVamount(String vamount) {
        this.vamount = vamount == null ? null : vamount.trim();
    }
}