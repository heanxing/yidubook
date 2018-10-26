package com.yi.du.bean;

/**
 * Created by Administrator on 2018/2/26.
 */
//用户类
public class Student {
    private Long id;
    private String username;
    private String password;
    private Borrow borrow;


    public Student() {
    }

    public Student(Long id, String username, String password, Borrow borrow) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.borrow = borrow;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(String password) {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }
}