package com.belong.model;

public class User {
    private Integer id;

    private String username;

    private String password;

    private Integer pagenum;

    private byte[] pic;

    public User(Integer id, String username, String password, Integer pagenum, byte[] pic) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.pagenum = pagenum;
        this.pic = pic;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getPagenum() {
        return pagenum;
    }

    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }
}