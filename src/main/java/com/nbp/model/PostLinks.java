package com.nbp.model;

import java.sql.*;

public class PostLinks {
    private int id;
    private Timestamp creationDate;
    private int postId;
    private int relatedPostId;
    private int linkTypeId;

    public PostLinks() {
    }

    public PostLinks(int id, Timestamp creationDate, int postId, int relatedPostId, int linkTypeId) {
        this.id = id;
        this.creationDate = creationDate;
        this.postId = postId;
        this.relatedPostId = relatedPostId;
        this.linkTypeId = linkTypeId;
    }

    public PostLinks(Timestamp creationDate, int postId, int relatedPostId, int linkTypeId) {
        this.creationDate = creationDate;
        this.postId = postId;
        this.relatedPostId = relatedPostId;
        this.linkTypeId = linkTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getRelatedPostId() {
        return relatedPostId;
    }

    public void setRelatedPostId(int relatedPostId) {
        this.relatedPostId = relatedPostId;
    }

    public int getLinkTypeId() {
        return linkTypeId;
    }

    public void setLinkTypeId(int linkTypeId) {
        this.linkTypeId = linkTypeId;
    }
}
