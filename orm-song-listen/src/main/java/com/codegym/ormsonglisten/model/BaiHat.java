package com.codegym.ormsonglisten.model;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "baihat")
public class BaiHat{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenBaiHat;
    private String theLoai;
    private String ngheSi;
    private String fileBaiHat;
    @Transient
    private MultipartFile file;


    public BaiHat() {
    }

    public BaiHat(Long id, String tenBaiHat, String theLoai, String ngheSi, String fileBaiHat, MultipartFile file) {
        this.setId(id);
        this.setTenBaiHat(tenBaiHat);
        this.setTheLoai(theLoai);
        this.setNgheSi(ngheSi);
        this.setFileBaiHat(fileBaiHat);
        this.setFile(file);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getNgheSi() {
        return ngheSi;
    }

    public void setNgheSi(String ngheSi) {
        this.ngheSi = ngheSi;
    }

    public String getFileBaiHat() {
        return fileBaiHat;
    }

    public void setFileBaiHat(String fileBaiHat) {
        this.fileBaiHat = fileBaiHat;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
