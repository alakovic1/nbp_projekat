package com.nbp.model;

import java.sql.Date;

public class Users {
    private int id;
    private String aboutMe;
    private int age;
    private Date creationDate;
    private String displayName;
    private int downVotes;
    private String emailHash;
    private Date lastAccessDate;
    private String location;
    private int reputation;
    private int upVotes;
    private int views;
    private String websiteURL;
    private int accountId;

    public Users(String aboutMe, int age, Date creationDate, String displayName,
                 int downVotes, String emailHash, Date lastAccessDate, String location,
                 int reputation, int upVotes, int views, String websiteURL, int accountId) {
        this.aboutMe = aboutMe;
        this.age = age;
        this.creationDate = creationDate;
        this.displayName = displayName;
        this.downVotes = downVotes;
        this.emailHash = emailHash;
        this.lastAccessDate = lastAccessDate;
        this.location = location;
        this.reputation = reputation;
        this.upVotes = upVotes;
        this.views = views;
        this.websiteURL = websiteURL;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }

    public String getEmailHash() {
        return emailHash;
    }

    public void setEmailHash(String emailHash) {
        this.emailHash = emailHash;
    }

    public Date getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(Date lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
