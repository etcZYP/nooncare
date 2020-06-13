package com.company.project.model;

import javax.persistence.*;

public class Org {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String locate;

    private Double distance;

    private String image;

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
     * @return distance
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * @param distance
     */
    public void setDistance(Double distance) {
        this.distance = distance;
    }

    /**
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }
}