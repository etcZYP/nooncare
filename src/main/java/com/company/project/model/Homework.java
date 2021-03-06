package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String org;

    private String name;

    private String text;

    private String img;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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