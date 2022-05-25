package com.nbp.model;

import java.sql.Date;

public class Votes {
    private int id;
    private int postId;
    private int userId;
    private int bountyAmount;
    private int voteTypeId;
    private Date creationDate;

    public Votes(int id, int postId, int userId, int bountyAmount, int voteTypeId, Date creationDate) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.bountyAmount = bountyAmount;
        this.voteTypeId = voteTypeId;
        this.creationDate = creationDate;
    }

    public Votes(int postId, int userId, int bountyAmount, int voteTypeId, Date creationDate) {
        this.postId = postId;
        this.userId = userId;
        this.bountyAmount = bountyAmount;
        this.voteTypeId = voteTypeId;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBountyAmount() {
        return bountyAmount;
    }

    public void setBountyAmount(int bountyAmount) {
        this.bountyAmount = bountyAmount;
    }

    public int getVoteTypeId() {
        return voteTypeId;
    }

    public void setVoteTypeId(int voteTypeId) {
        this.voteTypeId = voteTypeId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}