package com.nbp.model;

import java.sql.Date;

public class Posts {
    private int id;
    private int acceptedAnswerId;
    private int answerCount;
    private String body;
    private Date closedDate;
    private int commentCount;
    private Date communityOwnedDate;
    private Date creationDate;
    private int favoriteCount;
    private Date lastActivityDate;
    private Date lastEditDate;
    private String lastEditorDisplayName;
    private int lastEditorUserId;
    private int ownerUserId;
    private int parentId;
    private int postTypeId;
    private int score;
    private String tags;
    private String title;
    private int viewCount;

    public Posts(int id, int acceptedAnswerId, int answerCount, String body, Date closedDate,
                 int commentCount, Date communityOwnedDate, Date creationDate, int favoriteCount,
                 Date lastActivityDate, Date lastEditDate, String lastEditorDisplayName,
                 int lastEditorUserId, int ownerUserId, int parentId, int postTypeId, int score,
                 String tags, String title, int viewCount) {
        this.id = id;
        this.acceptedAnswerId = acceptedAnswerId;
        this.answerCount = answerCount;
        this.body = body;
        this.closedDate = closedDate;
        this.commentCount = commentCount;
        this.communityOwnedDate = communityOwnedDate;
        this.creationDate = creationDate;
        this.favoriteCount = favoriteCount;
        this.lastActivityDate = lastActivityDate;
        this.lastEditDate = lastEditDate;
        this.lastEditorDisplayName = lastEditorDisplayName;
        this.lastEditorUserId = lastEditorUserId;
        this.ownerUserId = ownerUserId;
        this.parentId = parentId;
        this.postTypeId = postTypeId;
        this.score = score;
        this.tags = tags;
        this.title = title;
        this.viewCount = viewCount;
    }

    public Posts(int acceptedAnswerId, int answerCount, String body, Date closedDate, int commentCount,
                 Date communityOwnedDate, Date creationDate, int favoriteCount, Date lastActivityDate,
                 Date lastEditDate, String lastEditorDisplayName, int lastEditorUserId, int ownerUserId,
                 int parentId, int postTypeId, int score, String tags, String title, int viewCount) {
        this.acceptedAnswerId = acceptedAnswerId;
        this.answerCount = answerCount;
        this.body = body;
        this.closedDate = closedDate;
        this.commentCount = commentCount;
        this.communityOwnedDate = communityOwnedDate;
        this.creationDate = creationDate;
        this.favoriteCount = favoriteCount;
        this.lastActivityDate = lastActivityDate;
        this.lastEditDate = lastEditDate;
        this.lastEditorDisplayName = lastEditorDisplayName;
        this.lastEditorUserId = lastEditorUserId;
        this.ownerUserId = ownerUserId;
        this.parentId = parentId;
        this.postTypeId = postTypeId;
        this.score = score;
        this.tags = tags;
        this.title = title;
        this.viewCount = viewCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(int acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public Date getCommunityOwnedDate() {
        return communityOwnedDate;
    }

    public void setCommunityOwnedDate(Date communityOwnedDate) {
        this.communityOwnedDate = communityOwnedDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Date getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public String getLastEditorDisplayName() {
        return lastEditorDisplayName;
    }

    public void setLastEditorDisplayName(String lastEditorDisplayName) {
        this.lastEditorDisplayName = lastEditorDisplayName;
    }

    public int getLastEditorUserId() {
        return lastEditorUserId;
    }

    public void setLastEditorUserId(int lastEditorUserId) {
        this.lastEditorUserId = lastEditorUserId;
    }

    public int getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(int ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(int postTypeId) {
        this.postTypeId = postTypeId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
