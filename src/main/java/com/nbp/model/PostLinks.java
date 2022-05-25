package com.nbp.model;

import java.sql.Date;

public class PostLinks {
    private int id;
    private Date creationDate;
    private int postId;
    private int relatedPostId;
    private int linkTypeId;

    public PostLinks(int id, Date creationDate, int postId, int relatedPostId, int linkTypeId) {
        this.id = id;
        this.creationDate = creationDate;
        this.postId = postId;
        this.relatedPostId = relatedPostId;
        this.linkTypeId = linkTypeId;
    }

    public PostLinks(Date creationDate, int postId, int relatedPostId, int linkTypeId) {
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
