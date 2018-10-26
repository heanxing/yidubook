package com.yi.du.bean;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2018/2/26.
 */
//书类
public class Book {

    private Long id;
    private Long bookid;
    private Long sid;
    private String bookName;//书本名称
    private String author;//书本作者
    private String press;//书本出版社
    private String picUrl;//书本的图片
    private Long mount;//书本的数量
    private String location;//书本的位置
    private int version;//书本版本号
    private MultipartFile file;

    public Book() {
    }

    public Book(Long id,Long bookid, Long sid, String bookName, String author, String press, String picUrl, Long mount, String location, int version) {
        this.id = id;
        this.bookid=bookid;
        this.sid = sid;
        this.bookName = bookName;
        this.author = author;
        this.press = press;
        this.picUrl = picUrl;
        this.mount = mount;
        this.location = location;
        this.version = version;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
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

    public Long getMount() {
        return mount;
    }

    public void setMount(Long mount) {
        this.mount = mount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}