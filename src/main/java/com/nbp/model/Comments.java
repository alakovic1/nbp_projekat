package com.nbp.model;


import java.sql.Date;

public class Comments {
    private int id;
    private Date creationDate;
    private int postId;
    private int score;
    private String text;
    private int userId;

    public Comments(int id, Date creationDate, int postId, int score, String text, int userId) {
        this.id = id;
        this.creationDate = creationDate;
        this.postId = postId;
        this.score = score;
        this.text = text;
        this.userId = userId;
    }

    public Comments(Date creationDate, int postId, int score, String text, int userId) {
        this.creationDate = creationDate;
        this.postId = postId;
        this.score = score;
        this.text = text;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
