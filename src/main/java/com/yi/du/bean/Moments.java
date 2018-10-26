package com.yi.du.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/4/4.
 */
//发表朋友圈
public class Moments {
    private Integer moments_id;
    private Integer user_id;//用户名id
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDateTime;//发表时间
    private String content;//发表的内容
    private String username;
    private String imagePath;
    private Integer praise;
    private Praise praises;

    public Praise getPraises() {
        return praises;
    }

    public void setPraises(Praise praises) {
        this.praises = praises;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public Integer getMoments_id() {
        return moments_id;
    }

    public void setMoments_id(Integer moments_id) {
        this.moments_id = moments_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}