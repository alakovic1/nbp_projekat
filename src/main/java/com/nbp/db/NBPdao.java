package com.nbp.db;

import com.nbp.model.Users;
import com.nbp.model.VoteTypes;

import java.sql.*;
import java.util.ArrayList;

public class NBPdao {
    public static NBPdao instance = null;
    public static Connection connection;

    private PreparedStatement createUserQuery, newUserIdQuery, deleteUserQuery,
            createVoteTypesQuery, readVoteTypeQuery, newVoteTypesIdQuery, updateVoteTypeQuery, deleteVoteTypeQuery;

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
            deleteUserQuery = connection.prepareStatement("DELETE FROM USERS WHERE id=?");
            //--fali update


            //VOTETYPES
            newVoteTypesIdQuery = connection.prepareStatement("SELECT MAX(id)+1 FROM VOTETYPES");
            createVoteTypesQuery = connection.prepareStatement("INSERT INTO VOTETYPES VALUES(?,?)");
            readVoteTypeQuery = connection.prepareStatement("SELECT * FROM VOTETYPES WHERE id=?");
            updateVoteTypeQuery = connection.prepareStatement("UPDATE VOTETYPES SET name=? WHERE id=?");
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

    public void deleteUser(Users user) {
        try {
            deleteUserQuery.setInt(1, user.getId());
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
}
