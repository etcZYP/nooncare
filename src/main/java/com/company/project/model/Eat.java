package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

public class Eat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String org;

    private String text;

    private String img;

    private String img2;

    private Date date;

    private String date2;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return org
     */
    public String getOrg() {
        return org;
    }

    /**
     * @param org
     */
    public void setOrg(String org) {
        this.org = org;
    }

    /**
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return img2
     */
    public String getImg2() {
        return img2;
    }

    /**
     * @param img2
     */
    public void setImg2(String img2) {
        this.img2 = img2;
    }

    /**
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return date2
     */
    public String getDate2() {
        return date2;
    }

    /**
     * @param date2
     */
    public void setDate2(String date2) {
        this.date2 = date2;
    }
}