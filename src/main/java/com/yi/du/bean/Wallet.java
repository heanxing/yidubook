package com.yi.du.bean;

/**
 * Created by Administrator on 2018/3/19.
 */
public class Wallet {
    private Long id;//'用户钱包主键
    private String user_open_id;//户中心的用户唯一编号
    private String user_amount;//
    private String  create_time;//
    private String update_time;//
    private String pay_password;//
    private int is_open;//'0:代表未开启支付密码，1:代表开发支付密码',
    private String check_key;//'平台进行用户余额更改时，首先效验key值，否则无法进行用户余额更改操作
    private int  version;//于mysql乐观锁，解决并发访问'

    public Wallet() {
    }

    public Wallet(Long id, String user_open_id, String user_amount, String create_time, String update_time,
                  String pay_password, int is_open, String check_key, int version) {
        this.id = id;
        this.user_open_id = user_open_id;
        this.user_amount = user_amount;
        this.create_time = create_time;
        this.update_time = update_time;
        this.pay_password = pay_password;
        this.is_open = is_open;
        this.check_key = check_key;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_open_id() {
        return user_open_id;
    }

    public void setUser_open_id(String user_open_id) {
        this.user_open_id = user_open_id;
    }

    public String getUser_amount() {
        return user_amount;
    }

    public void setUser_amount(String user_amount) {
        this.user_amount = user_amount;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getPay_password() {
        return pay_password;
    }

    public void setPay_password(String pay_password) {
        this.pay_password = pay_password;
    }

    public int getIs_open() {
        return is_open;
    }

    public void setIs_open(int is_open) {
        this.is_open = is_open;
    }

    public String getCheck_key() {
        return check_key;
    }

    public void setCheck_key(String check_key) {
        this.check_key = check_key;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
