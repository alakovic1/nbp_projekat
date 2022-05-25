package com.nbp.model;

import java.sql.Date;

public class Badges {
    private int id;
    private String name;
    private int userId;
    private Date dates;

    public Badges(int id, String name, int userId, Date dates) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.dates = dates;
    }

    public Badges(String name, int userId, Date dates) {
        this.name = name;
        this.userId = userId;
        this.dates = dates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
}
