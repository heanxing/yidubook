package com.yi.du.bean;

/**
 * Created by Administrator on 2018/2/28.
 */
//借书类
public class Borrow {
    private Long id;
    private Long book_Id;//书的名字
    private Long User_id;
    private String book_name;
    private String picUrl;
    private String Br_start;//借书的开始
    private String Br_stop;//借书的结束
    private String location;
    private Integer status;  //0代表借书成功   1代表已还

    public Borrow() {
    }

    public Borrow(Long id, Long book_Id, Long user_id, String book_name, String picUrl, String br_start, String br_stop, String location, Integer status) {
        this.id = id;
        this.book_Id = book_Id;
        User_id = user_id;
        this.book_name = book_name;
        this.picUrl = picUrl;
        Br_start = br_start;
        Br_stop = br_stop;
        this.location = location;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBook_Id() {
        return book_Id;
    }

    public void setBook_Id(Long book_Id) {
        this.book_Id = book_Id;
    }

    public Long getUser_id() {
        return User_id;
    }

    public void setUser_id(Long user_id) {
        User_id = user_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getBr_start() {
        return Br_start;
    }

    public void setBr_start(String br_start) {
        Br_start = br_start;
    }

    public String getBr_stop() {
        return Br_stop;
    }

    public void setBr_stop(String br_stop) {
        Br_stop = br_stop;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}