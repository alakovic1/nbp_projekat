package com.nbp.model;

public class PostTypes {
    private int id;
    private String type;

    public PostTypes() {
    }

    public PostTypes(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public PostTypes(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
