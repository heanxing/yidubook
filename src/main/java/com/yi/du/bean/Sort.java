package com.yi.du.bean;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2018/2/28.
 */
//书分类
public class Sort {
    private Long id;
    private String sname;
    private String image;
    private MultipartFile file;

    public Sort() {
    }

    public Sort(Long id, String sname, String image) {
        this.id = id;
        this.sname = sname;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}