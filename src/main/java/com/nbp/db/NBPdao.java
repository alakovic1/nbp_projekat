package com.nbp.db;

import com.nbp.model.Users;
import com.nbp.model.VoteTypes;

import java.sql.*;
import java.util.ArrayList;

public class NBPdao {
    public static NBPdao instance = null;
    public static Connection connection;

    private PreparedStatement addUserQuery, newUserIdQuery, deleteUserQuery,
            addVoteTypesQuery, newVoteTypesIdQuery, deleteVoteTypeQuery;

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
            addUserQuery = connection.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            deleteUserQuery = connection.prepareStatement("DELETE FROM USERS WHERE id=?");
            //--fali update


            //VOTETYPES
            newVoteTypesIdQuery = connection.prepareStatement("SELECT MAX(id)+1 FROM VOTETYPES");
            addVoteTypesQuery = connection.prepareStatement("INSERT INTO VOTETYPES VALUES(?,?)");
            deleteVoteTypeQuery = connection.prepareStatement("DELETE FROM VOTETYPES WHERE id=?");
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
    public void addUser(Users user){
        try {
            addUserQuery.setInt(1,getMaxSizeUsers());
            addUserQuery.setString(2,user.getAboutMe());
            addUserQuery.setInt(3,user.getAge());
            addUserQuery.setTimestamp(4,user.getCreationDate());
            addUserQuery.setString(5,user.getDisplayName());
            addUserQuery.setInt(6,user.getDownVotes());
            addUserQuery.setString(7,user.getEmailHash());
            addUserQuery.setTimestamp(8,user.getLastAccessDate());
            addUserQuery.setString(9,user.getLocation());
            addUserQuery.setInt(10,user.getReputation());
            addUserQuery.setInt(11,user.getUpVotes());
            addUserQuery.setInt(12,user.getViews());
            addUserQuery.setString(13,user.getWebsiteURL());
            addUserQuery.setInt(14,user.getAccountId());

            addUserQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(Users user) {
        try {
            deleteUserQuery.setInt(1, user.getId());
            deleteUserQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //VOTETYPES
    public void addVoteType(VoteTypes vt){
        try {
            ResultSet rs = newVoteTypesIdQuery.executeQuery();
            int id = 1;
            if(rs.next()) id = rs.getInt(1);

            addVoteTypesQuery.setInt(1,id);
            addVoteTypesQuery.setString(2,vt.getName());

            addVoteTypesQuery.executeUpdate();
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
}
