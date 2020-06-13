package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

public class Signin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String org;

    private String name;

    private Date date;

    private String locate;

    private String mark;

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
     * @return locate
     */
    public String getLocate() {
        return locate;
    }

    /**
     * @param locate
     */
    public void setLocate(String locate) {
        this.locate = locate;
    }

    /**
     * @return mark
     */
    public String getMark() {
        return mark;
    }

    /**
     * @param mark
     */
    public void setMark(String mark) {
        this.mark = mark;
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