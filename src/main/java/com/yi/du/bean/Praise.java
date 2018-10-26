package com.yi.du.bean;

public class Praise {
    private Integer praise_id;
    private Integer user_id;
    private Integer moments_id;
    private Integer praiseSum;

    public Integer getPraiseSum() {
        return praiseSum;
    }

    public void setPraiseSum(Integer praiseSum) {
        this.praiseSum = praiseSum;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getPraise_id() {
        return praise_id;
    }

    public void setPraise_id(Integer praise_id) {
        this.praise_id = praise_id;
    }

    public Integer getMoments_id() {
        return moments_id;
    }

    public void setMoments_id(Integer moments_id) {
        this.moments_id = moments_id;
    }

}
