package com.nbp.model;

import java.sql.*;

public class Badges {
    private int id;
    private String name;
    private int userId;
    private Timestamp dates;

    public Badges() {
    }

    public Badges(int id, String name, int userId, Timestamp dates) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.dates = dates;
    }

    public Badges(String name, int userId, Timestamp dates) {
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

    public Timestamp getDates() {
        return dates;
    }

    public void setDates(Timestamp dates) {
        this.dates = dates;
    }
}
