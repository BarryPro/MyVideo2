package com.belong.model;

import java.util.Date;

public class Article {
    private Integer aid;

    private Integer uid;

    private Integer arootid;

    private Date adate;

    private Integer vid;

    private String acontent;

    public Article(Integer aid, Integer uid, Integer arootid, Date adate, Integer vid, String acontent) {
        this.aid = aid;
        this.uid = uid;
        this.arootid = arootid;
        this.adate = adate;
        this.vid = vid;
        this.acontent = acontent;
    }

    public Article() {
        super();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getArootid() {
        return arootid;
    }

    public void setArootid(Integer arootid) {
        this.arootid = arootid;
    }

    public Date getAdate() {
        return adate;
    }

    public void setAdate(Date adate) {
        this.adate = adate;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getAcontent() {
        return acontent;
    }

    public void setAcontent(String acontent) {
        this.acontent = acontent == null ? null : acontent.trim();
    }
}