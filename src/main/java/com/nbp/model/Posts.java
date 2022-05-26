package com.nbp.model;

import java.sql.*;

public class Posts {
    private int id;
    private int acceptedAnswerId;
    private int answerCount;
    private String body;
    private Timestamp closedDate;
    private int commentCount;
    private Timestamp communityOwnedDate;
    private Timestamp creationDate;
    private int favoriteCount;
    private Timestamp lastActivityDate;
    private Timestamp lastEditDate;
    private String lastEditorDisplayName;
    private int lastEditorUserId;
    private int ownerUserId;
    private int parentId;
    private int postTypeId;
    private int score;
    private String tags;
    private String title;
    private int viewCount;

    public Posts() {
    }

    public Posts(int id, int acceptedAnswerId, int answerCount, String body, Timestamp closedDate,
                 int commentCount, Timestamp communityOwnedDate, Timestamp creationDate, int favoriteCount,
                 Timestamp lastActivityDate, Timestamp lastEditDate, String lastEditorDisplayName,
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

    public Posts(int acceptedAnswerId, int answerCount, String body, Timestamp closedDate, int commentCount,
                 Timestamp communityOwnedDate, Timestamp creationDate, int favoriteCount, Timestamp lastActivityDate,
                 Timestamp lastEditDate, String lastEditorDisplayName, int lastEditorUserId, int ownerUserId,
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

    public Timestamp getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Timestamp closedDate) {
        this.closedDate = closedDate;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public Timestamp getCommunityOwnedDate() {
        return communityOwnedDate;
    }

    public void setCommunityOwnedDate(Timestamp communityOwnedDate) {
        this.communityOwnedDate = communityOwnedDate;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public Timestamp getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Timestamp lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Timestamp getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Timestamp lastEditDate) {
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
