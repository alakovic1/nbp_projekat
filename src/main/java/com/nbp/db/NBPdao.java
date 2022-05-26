package com.nbp.db;

import com.nbp.model.*;

import java.sql.*;
import java.util.ArrayList;

public class NBPdao {
    public static NBPdao instance = null;
    public static Connection connection;

    private PreparedStatement createUserQuery, newUserIdQuery, readUserQuery, updateUserQuery, deleteUserQuery,
            createVoteTypesQuery, readVoteTypeQuery, newVoteTypesIdQuery, updateVoteTypeQuery, deleteVoteTypeQuery,
            newBadgeIdQuery, createBadgeQuery, readBadgeQuery, updateBadgesQuery, deleteBadgeQuery,
            newPostTypesIdQuery, createPostTypesQuery, readPostTypeQuery, updatePostTypeQuery, deletePostTypeQuery,
            newLinkTypesIdQuery, createLinkTypesQuery, readLinkTypeQuery, updateLinkTypeQuery, deleteLinkTypeQuery;

    public static void initialize() {
        instance = new NBPdao();
    }

    public static NBPdao getInstance() {
        if(instance == null) initialize();
        return instance;
    }

    public static Connection getConnection() {
        return connection;
    }

    public NBPdao() {
        String connectionUrl = "jdbc:oracle:thin:@ora-02.db.lab.etf.unsa.ba:1521:cdb1";
        connection = null;

        //connecting to database
        try {
            //oracle jdbc driver needs to be added to project
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(connectionUrl, "nbp", "etfnbp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (connection != null) {
            System.out.println("Connected to DB!");
        }

        //queries
        try {
            //USERS
            newUserIdQuery = connection.prepareStatement("SELECT MAX(id)+1 FROM USERS");
            createUserQuery = connection.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            readUserQuery = connection.prepareStatement("SELECT * FROM USERS WHERE id=?");
            updateUserQuery = connection.prepareStatement("UPDATE USERS SET aboutme=?, age=?, creationdate=?, displayname=?, downvotes=?, emailhash=?, lastaccessdate=?, location=?, reputation=?, upvotes=?, views=?, websiteurl=?, accountid=? WHERE id=?");
            deleteUserQuery = connection.prepareStatement("DELETE FROM USERS WHERE id=?");

            //VOTETYPES
            newVoteTypesIdQuery = connection.prepareStatement("SELECT MAX(id)+1 FROM VOTETYPES");
            createVoteTypesQuery = connection.prepareStatement("INSERT INTO VOTETYPES VALUES(?,?)");
            readVoteTypeQuery = connection.prepareStatement("SELECT * FROM VOTETYPES WHERE id=?");
            updateVoteTypeQuery = connection.prepareStatement("UPDATE VOTETYPES SET name=? WHERE id=?");
            deleteVoteTypeQuery = connection.prepareStatement("DELETE FROM VOTETYPES WHERE id=?");

            //BADGES
            newBadgeIdQuery = connection.prepareStatement("SELECT MAX(id)+1 FROM BADGES");
            createBadgeQuery = connection.prepareStatement("INSERT INTO BADGES VALUES(?,?,?,?)");
            readBadgeQuery = connection.prepareStatement("SELECT * FROM BADGES WHERE id=?");
            updateBadgesQuery = connection.prepareStatement("UPDATE BADGES SET name=?, userid=?, dates=? WHERE id=?");
            deleteBadgeQuery = connection.prepareStatement("DELETE FROM BADGES WHERE id=?");

            //POSTTYPES
            newPostTypesIdQuery = connection.prepareStatement("SELECT MAX(id)+1 FROM POSTTYPES");
            createPostTypesQuery = connection.prepareStatement("INSERT INTO POSTTYPES VALUES(?,?)");
            readPostTypeQuery = connection.prepareStatement("SELECT * FROM POSTTYPES WHERE id=?");
            updatePostTypeQuery = connection.prepareStatement("UPDATE POSTTYPES SET type=? WHERE id=?");
            deletePostTypeQuery = connection.prepareStatement("DELETE FROM POSTTYPES WHERE id=?");

            //LINKTYPES
            newLinkTypesIdQuery = connection.prepareStatement("SELECT MAX(id)+1 FROM LINKTYPES");
            createLinkTypesQuery = connection.prepareStatement("INSERT INTO LINKTYPES VALUES(?,?)");
            readLinkTypeQuery = connection.prepareStatement("SELECT * FROM LINKTYPES WHERE id=?");
            updateLinkTypeQuery = connection.prepareStatement("UPDATE LINKTYPES SET type=? WHERE id=?");
            deleteLinkTypeQuery = connection.prepareStatement("DELETE FROM LINKTYPES WHERE id=?");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //USERS
    public int getMaxSizeUsers(){
        try {
            ResultSet rs = newUserIdQuery.executeQuery();
            int id = 1;
            if(rs.next()) id = rs.getInt(1);
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
    public void createUser(Users user){
        try {
            createUserQuery.setInt(1,getMaxSizeUsers());
            createUserQuery.setString(2,user.getAboutMe());
            createUserQuery.setInt(3,user.getAge());
            createUserQuery.setTimestamp(4,user.getCreationDate());
            createUserQuery.setString(5,user.getDisplayName());
            createUserQuery.setInt(6,user.getDownVotes());
            createUserQuery.setString(7,user.getEmailHash());
            createUserQuery.setTimestamp(8,user.getLastAccessDate());
            createUserQuery.setString(9,user.getLocation());
            createUserQuery.setInt(10,user.getReputation());
            createUserQuery.setInt(11,user.getUpVotes());
            createUserQuery.setInt(12,user.getViews());
            createUserQuery.setString(13,user.getWebsiteURL());
            createUserQuery.setInt(14,user.getAccountId());

            createUserQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Users readUser(int id) {
        Users user = new Users();
        try {
            user.setId(id);

            readUserQuery.setInt(1, user.getId());
            ResultSet rs = readUserQuery.executeQuery();

            while(rs.next()) {
                user.setAboutMe(rs.getString(2));
                user.setAge(rs.getInt(3));
                user.setCreationDate(rs.getTimestamp(4));
                user.setDisplayName(rs.getString(5));
                user.setDownVotes(rs.getInt(6));
                user.setEmailHash(rs.getString(7));
                user.setLastAccessDate(rs.getTimestamp(8));
                user.setLocation(rs.getString(9));
                user.setReputation(rs.getInt(10));
                user.setUpVotes(rs.getInt(11));
                user.setViews(rs.getInt(12));
                user.setWebsiteURL(rs.getString(13));
                user.setAccountId(rs.getInt(14));
            }

            //u bazi mora postojati neka vrijednost (po shemi)
            if(user.getCreationDate() == null) return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(Users user){
        try {
            updateUserQuery.setInt(14, user.getId());
            updateUserQuery.setString(1,user.getAboutMe());
            updateUserQuery.setInt(2,user.getAge());
            updateUserQuery.setTimestamp(3,user.getCreationDate());
            updateUserQuery.setString(4,user.getDisplayName());
            updateUserQuery.setInt(5,user.getDownVotes());
            updateUserQuery.setString(6,user.getEmailHash());
            updateUserQuery.setTimestamp(7,user.getLastAccessDate());
            updateUserQuery.setString(8,user.getLocation());
            updateUserQuery.setInt(9,user.getReputation());
            updateUserQuery.setInt(10,user.getUpVotes());
            updateUserQuery.setInt(11,user.getViews());
            updateUserQuery.setString(12,user.getWebsiteURL());
            updateUserQuery.setInt(13,user.getAccountId());
            updateUserQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            deleteUserQuery.setInt(1, id);
            deleteUserQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //VOTETYPES
    public void createVoteType(VoteTypes vt){
        try {
            ResultSet rs = newVoteTypesIdQuery.executeQuery();
            int id = 1;
            if(rs.next()) id = rs.getInt(1);

            createVoteTypesQuery.setInt(1,id);
            createVoteTypesQuery.setString(2,vt.getName());

            createVoteTypesQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public VoteTypes readVoteType(int id) {
        VoteTypes vt = new VoteTypes("");
        try {
            vt.setId(id);

            readVoteTypeQuery.setInt(1, vt.getId());
            ResultSet rs = readVoteTypeQuery.executeQuery();

            while(rs.next()) {
                vt.setName(rs.getString(2));
            }

            //u bazi mora postojati neka vrijednost (po shemi)
            if(vt.getName().equals("")) return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vt;
    }

    public void updateVoteType(VoteTypes vt){
        try {
            updateVoteTypeQuery.setInt(2, vt.getId());
            updateVoteTypeQuery.setString(1, vt.getName());
            updateVoteTypeQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVoteType(int id) {
        try {
            deleteVoteTypeQuery.setInt(1, id);
            deleteVoteTypeQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //BADGES
    public void createBadge(Badges badge){
        try {
            ResultSet rs = newBadgeIdQuery.executeQuery();
            int id = 1;
            if(rs.next()) id = rs.getInt(1);

            createBadgeQuery.setInt(1,id);
            createBadgeQuery.setString(2,badge.getName());
            createBadgeQuery.setInt(3,badge.getUserId());
            createBadgeQuery.setTimestamp(4,badge.getDates());

            createBadgeQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Badges readBadge(int id) {
        Badges badge = new Badges();
        try {
            badge.setId(id);

            readBadgeQuery.setInt(1, badge.getId());
            ResultSet rs = readBadgeQuery.executeQuery();

            while(rs.next()) {
                badge.setName(rs.getString(2));
                badge.setUserId(rs.getInt(3));
                badge.setDates(rs.getTimestamp(4));
            }

            //u bazi mora postojati neka vrijednost (po shemi)
            if(badge.getName() == null) return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return badge;
    }

    public void updateBadge(Badges badges){
        try {
            updateBadgesQuery.setInt(4, badges.getId());
            updateBadgesQuery.setString(1, badges.getName());
            updateBadgesQuery.setInt(2, badges.getUserId());
            updateBadgesQuery.setTimestamp(3, badges.getDates());
            updateBadgesQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBadge(int id) {
        try {
            deleteBadgeQuery.setInt(1, id);
            deleteBadgeQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //POSTTYPES
    public void createPostType(PostTypes pt){
        try {
            ResultSet rs = newPostTypesIdQuery.executeQuery();
            int id = 1;
            if(rs.next()) id = rs.getInt(1);

            createPostTypesQuery.setInt(1,id);
            createPostTypesQuery.setString(2,pt.getType());

            createPostTypesQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PostTypes readPostType(int id) {
        PostTypes pt = new PostTypes("");
        try {
            pt.setId(id);

            readPostTypeQuery.setInt(1, pt.getId());
            ResultSet rs = readPostTypeQuery.executeQuery();

            while(rs.next()) {
                pt.setType(rs.getString(2));
            }

            //u bazi mora postojati neka vrijednost (po shemi)
            if(pt.getType().equals("")) return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pt;
    }

    public void updatePostType(PostTypes pt){
        try {
            updatePostTypeQuery.setInt(2, pt.getId());
            updatePostTypeQuery.setString(1, pt.getType());
            updatePostTypeQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePostType(int id) {
        try {
            deletePostTypeQuery.setInt(1, id);
            deletePostTypeQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //LINKTYPES
    public void createLinkType(LinkTypes lt){
        try {
            ResultSet rs = newLinkTypesIdQuery.executeQuery();
            int id = 1;
            if(rs.next()) id = rs.getInt(1);

            createLinkTypesQuery.setInt(1,id);
            createLinkTypesQuery.setString(2,lt.getType());

            createLinkTypesQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LinkTypes readLinkType(int id) {
        LinkTypes lt = new LinkTypes("");
        try {
            lt.setId(id);

            readLinkTypeQuery.setInt(1, lt.getId());
            ResultSet rs = readLinkTypeQuery.executeQuery();

            while(rs.next()) {
                lt.setType(rs.getString(2));
            }

            //u bazi mora postojati neka vrijednost (po shemi)
            if(lt.getType().equals("")) return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lt;
    }

    public void updateLinkType(LinkTypes lt){
        try {
            updateLinkTypeQuery.setInt(2, lt.getId());
            updateLinkTypeQuery.setString(1, lt.getType());
            updateLinkTypeQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLinkType(int id) {
        try {
            deleteLinkTypeQuery.setInt(1, id);
            deleteLinkTypeQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
