package com.belong.model;

import java.math.BigDecimal;
import java.sql.Date;

public class MoviesWithBLOBs extends Movies {
    private String vinfo;

    private byte[] vpic;

    private String vsrc;

    public MoviesWithBLOBs(Integer vid, String vname, Date vdate, Integer id, BigDecimal views, String vinfo, byte[] vpic, String vsrc) {
        super(vid, vname, vdate, id, views);
        this.vinfo = vinfo;
        this.vpic = vpic;
        this.vsrc = vsrc;
    }

    public MoviesWithBLOBs() {
        super();
    }

    public String getVinfo() {
        return vinfo;
    }

    public void setVinfo(String vinfo) {
        this.vinfo = vinfo == null ? null : vinfo.trim();
    }

    public byte[] getVpic() {
        return vpic;
    }

    public void setVpic(byte[] vpic) {
        this.vpic = vpic;
    }

    public String getVsrc() {
        return vsrc;
    }

    public void setVsrc(String vsrc) {
        this.vsrc = vsrc == null ? null : vsrc.trim();
    }
}
