package com.belong.model;

public class Type {
    private Integer vid;

    private String tid;

    public Type(Integer vid, String tid) {
        this.vid = vid;
        this.tid = tid;
    }

    public Type() {
        super();
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }
}