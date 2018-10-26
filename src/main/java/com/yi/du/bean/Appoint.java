package com.yi.du.bean;

/**
 * Created by Administrator on 2018/3/28.
 */
public class Appoint {


    //预约书本的实体类
    private Long id;
    private Long User_id;
    private Long B_id;
    private String bookName;//书本名称
    private String author;//书本作者
    private String press;//书本出版社
    private String picUrl;//书本的图片
    private String location;//书本的位置
    private String Stime;//预约时间
    private String Htime;//拿书时间
    private Integer status;//0代表预约成功 1代表取消预约

    public Appoint() {
    }

    public Appoint(Long id, Long user_id, Long b_id, String bookName, String author, String press, String picUrl, String location, String stime, String htime, Integer status) {
        this.id = id;
        User_id = user_id;
        B_id = b_id;
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.picUrl = picUrl;
        this.location = location;
        Stime = stime;
        Htime = htime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return User_id;
    }

    public void setUser_id(Long user_id) {
        User_id = user_id;
    }

    public Long getB_id() {
        return B_id;
    }

    public void setB_id(Long b_id) {
        B_id = b_id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStime() {
        return Stime;
    }

    public void setStime(String stime) {
        Stime = stime;
    }

    public String getHtime() {
        return Htime;
    }

    public void setHtime(String htime) {
        Htime = htime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}