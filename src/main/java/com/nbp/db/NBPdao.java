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
            newLinkTypesIdQuery, createLinkTypesQuery, readLinkTypeQuery, updateLinkTypeQuery, deleteLinkTypeQuery,
            newCommentIdQuery, createCommentsQuery, readCommentQuery, updateCommentQuery, deleteCommentQuery,
            newPostLinkIdQuery, createPostLinkQuery, readPostLinkQuery, updatePostLinkQuery, deletePostLinkQuery,
            newVoteIdQuery, createVoteQuery, readVoteQuery, updateVoteQuery, deleteVoteQuery,
            newPostIdQuery, createPostQuery, readPostQuery, updatePostQuery, deletePostQuery;

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

            //COMMENTS
            newCommentIdQuery = connection.prepareStatement("SELECT MAX(id)+1 FROM COMMENTS");
            createCommentsQuery = connection.prepareStatement("INSERT INTO COMMENTS VALUES(?,?,?,?,?,?)");
            readCommentQuery = connection.prepareStatement("SELECT * FROM COMMENTS WHERE id=?");
            updateCommentQuery = connection.prepareStatement("UPDATE COMMENTS SET creationdate=?, postid=?, score=?, text=?, userid=? WHERE id=?");
            deleteCommentQuery = connection.prepareStatement("DELETE FROM COMMENTS WHERE id=?");

            //POSTLINKS
            newPostLinkIdQuery = connection.prepareStatement("SELECT MAX(id)+1 FROM POSTLINKS");
            createPostLinkQuery = connection.prepareStatement("INSERT INTO POSTLINKS VALUES(?,?,?,?,?)");
            readPostLinkQuery = connection.prepareStatement("SELECT * FROM POSTLINKS WHERE id=?");
            updatePostLinkQuery = connection.prepareStatement("UPDATE POSTLINKS SET creationdate=?, postid=?, relatedpostid=?, linktypeid=? WHERE id=?");
            deletePostLinkQuery = connection.prepareStatement("DELETE FROM POSTLINKS WHERE id=?");

            //VOTES
            newVoteIdQuery = connection.prepareStatement("SELECT MAX(id)+1 FROM VOTES");
            createVoteQuery = connection.prepareStatement("INSERT INTO VOTES VALUES(?,?,?,?,?,?)");
            readVoteQuery = connection.prepareStatement("SELECT * FROM VOTES WHERE id=?");
            updateVoteQuery = connection.prepareStatement("UPDATE VOTES SET postid=?, userid=?, bountyamount=?, votetypeid=?, creationdate=? WHERE id=?");
            deleteVoteQuery = connection.prepareStatement("DELETE FROM VOTES WHERE id=?");

            //POSTS
            newPostIdQuery = connection.prepareStatement("SELECT MAX(id)+1 FROM POSTS");
            createPostQuery = connection.prepareStatement("INSERT INTO POSTS VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            readPostQuery = connection.prepareStatement("SELECT * FROM POSTS WHERE id=?");
            updatePostQuery = connection.prepareStatement("UPDATE POSTS SET acceptedanswerid=?, answercount=?, body=?, closeddate=?, commentcount=?, communityowneddate=?, creationdate=?, favoritecount=?, lastactivitydate=?, lasteditdate=?, lasteditordisplayname=?, lasteditoruserid=?, owneruserid=?, parentid=?, posttypeid=?, score=?, tags=?, title=?, viewcount=? WHERE id=?");
            deletePostQuery = connection.prepareStatement("DELETE FROM POSTS WHERE id=?");
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

    //COMMENTS
    public void createComment(Comments comments){
        try {
            ResultSet rs = newCommentIdQuery.executeQuery();
            int id = 1;
            if(rs.next()) id = rs.getInt(1);

            createCommentsQuery.setInt(1,id);
            createCommentsQuery.setTimestamp(2,comments.getCreationDate());
            createCommentsQuery.setInt(3,comments.getPostId());
            createCommentsQuery.setInt(4,comments.getScore());
            createCommentsQuery.setString(5,comments.getText());
            createCommentsQuery.setInt(6,comments.getUserId());

            createCommentsQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Comments readComment(int id) {
        Comments comment = new Comments();
        try {
            comment.setId(id);

            readCommentQuery.setInt(1, comment.getId());
            ResultSet rs = readCommentQuery.executeQuery();

            while(rs.next()) {
                comment.setCreationDate(rs.getTimestamp(2));
                comment.setPostId(rs.getInt(3));
                comment.setScore(rs.getInt(4));
                comment.setText(rs.getString(5));
                comment.setUserId(rs.getInt(6));
            }

            //u bazi mora postojati neka vrijednost (po shemi)
            if(comment.getCreationDate() == null) return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;
    }

    public void updateComment(Comments comment){
        try {
            updateCommentQuery.setInt(6, comment.getId());
            updateCommentQuery.setTimestamp(1,comment.getCreationDate());
            updateCommentQuery.setInt(2,comment.getPostId());
            updateCommentQuery.setInt(3,comment.getScore());
            updateCommentQuery.setString(4,comment.getText());
            updateCommentQuery.setInt(5,comment.getUserId());
            updateCommentQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteComment(int id) {
        try {
            deleteCommentQuery.setInt(1, id);
            deleteCommentQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //POSTLINKS
    public void createPostLink(PostLinks pl){
        try {
            ResultSet rs = newPostLinkIdQuery.executeQuery();
            int id = 1;
            if(rs.next()) id = rs.getInt(1);

            createPostLinkQuery.setInt(1,id);
            createPostLinkQuery.setTimestamp(2,pl.getCreationDate());
            createPostLinkQuery.setInt(3,pl.getPostId());
            createPostLinkQuery.setInt(4,pl.getRelatedPostId());
            createPostLinkQuery.setInt(5,pl.getLinkTypeId());

            createPostLinkQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PostLinks readPostLink(int id) {
        PostLinks pl = new PostLinks();
        try {
            pl.setId(id);

            readPostLinkQuery.setInt(1, pl.getId());
            ResultSet rs = readPostLinkQuery.executeQuery();

            while(rs.next()) {
                pl.setCreationDate(rs.getTimestamp(2));
                pl.setPostId(rs.getInt(3));
                pl.setRelatedPostId(rs.getInt(4));
                pl.setLinkTypeId(rs.getInt(5));
            }

            //u bazi mora postojati neka vrijednost (po shemi)
            if(pl.getCreationDate() == null) return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pl;
    }

    public void updatePostLink(PostLinks pl){
        try {
            updatePostLinkQuery.setInt(5, pl.getId());
            updatePostLinkQuery.setTimestamp(1,pl.getCreationDate());
            updatePostLinkQuery.setInt(2,pl.getPostId());
            updatePostLinkQuery.setInt(3,pl.getRelatedPostId());
            updatePostLinkQuery.setInt(4,pl.getLinkTypeId());
            updatePostLinkQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePostLink(int id) {
        try {
            deletePostLinkQuery.setInt(1, id);
            deletePostLinkQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //VOTES
    public void createVote(Votes vote){
        try {
            ResultSet rs = newVoteIdQuery.executeQuery();
            int id = 1;
            if(rs.next()) id = rs.getInt(1);

            createVoteQuery.setInt(1,id);
            createVoteQuery.setInt(2,vote.getPostId());
            createVoteQuery.setInt(3,vote.getUserId());
            createVoteQuery.setInt(4,vote.getBountyAmount());
            createVoteQuery.setInt(5,vote.getVoteTypeId());
            createVoteQuery.setTimestamp(6,vote.getCreationDate());

            createVoteQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Votes readVote(int id) {
        Votes vote = new Votes();
        try {
            vote.setId(id);

            readVoteQuery.setInt(1, vote.getId());
            ResultSet rs = readVoteQuery.executeQuery();

            while(rs.next()) {
                vote.setPostId(rs.getInt(2));
                vote.setUserId(rs.getInt(3));
                vote.setBountyAmount(rs.getInt(4));
                vote.setVoteTypeId(rs.getInt(5));
                vote.setCreationDate(rs.getTimestamp(6));
            }

            //u bazi mora postojati neka vrijednost (po shemi)
            if(vote.getCreationDate() == null) return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vote;
    }

    public void updateVote(Votes vote){
        try {
            updateVoteQuery.setInt(6, vote.getId());
            updateVoteQuery.setInt(1,vote.getPostId());
            updateVoteQuery.setInt(2,vote.getUserId());
            updateVoteQuery.setInt(3,vote.getBountyAmount());
            updateVoteQuery.setInt(4,vote.getVoteTypeId());
            updateVoteQuery.setTimestamp(5,vote.getCreationDate());
            updateVoteQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVote(int id) {
        try {
            deleteVoteQuery.setInt(1, id);
            deleteVoteQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //POSTS
    public void createPost(Posts post){
        try {
            ResultSet rs = newPostIdQuery.executeQuery();
            int id = 1;
            if(rs.next()) id = rs.getInt(1);

            createPostQuery.setInt(1,id);
            createPostQuery.setInt(2,post.getAcceptedAnswerId());
            createPostQuery.setInt(3,post.getAnswerCount());
            createPostQuery.setString(4,post.getBody());
            createPostQuery.setTimestamp(5,post.getClosedDate());
            createPostQuery.setInt(6,post.getCommentCount());
            createPostQuery.setTimestamp(7,post.getCommunityOwnedDate());
            createPostQuery.setTimestamp(8,post.getCreationDate());
            createPostQuery.setInt(9,post.getFavoriteCount());
            createPostQuery.setTimestamp(10,post.getLastActivityDate());
            createPostQuery.setTimestamp(11,post.getLastEditDate());
            createPostQuery.setString(12,post.getLastEditorDisplayName());
            createPostQuery.setInt(13,post.getLastEditorUserId());
            createPostQuery.setInt(14,post.getOwnerUserId());
            createPostQuery.setInt(15,post.getParentId());
            createPostQuery.setInt(16,post.getPostTypeId());
            createPostQuery.setInt(17,post.getScore());
            createPostQuery.setString(18,post.getTags());
            createPostQuery.setString(19,post.getTitle());
            createPostQuery.setInt(20,post.getViewCount());

            createPostQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Posts readPost(int id) {
        Posts post = new Posts();
        try {
            post.setId(id);

            readPostQuery.setInt(1, post.getId());
            ResultSet rs = readPostQuery.executeQuery();

            while(rs.next()) {
                post.setAcceptedAnswerId(rs.getInt(2));
                post.setAnswerCount(rs.getInt(3));
                post.setBody(rs.getString(4));
                post.setClosedDate(rs.getTimestamp(5));
                post.setCommentCount(rs.getInt(6));
                post.setCommunityOwnedDate(rs.getTimestamp(7));
                post.setCreationDate(rs.getTimestamp(8));
                post.setFavoriteCount(rs.getInt(9));
                post.setLastActivityDate(rs.getTimestamp(10));
                post.setLastEditDate(rs.getTimestamp(11));
                post.setLastEditorDisplayName(rs.getString(12));
                post.setLastEditorUserId(rs.getInt(13));
                post.setOwnerUserId(rs.getInt(14));
                post.setParentId(rs.getInt(15));
                post.setPostTypeId(rs.getInt(16));
                post.setScore(rs.getInt(17));
                post.setTags(rs.getString(18));
                post.setTitle(rs.getString(19));
                post.setViewCount(rs.getInt(20));
            }

            //u bazi mora postojati neka vrijednost (po shemi)
            if(post.getCreationDate() == null) return null;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    public void updatePost(Posts post){
        try {
            updatePostQuery.setInt(20, post.getId());
            updatePostQuery.setInt(1,post.getAcceptedAnswerId());
            updatePostQuery.setInt(2,post.getAnswerCount());
            updatePostQuery.setString(3,post.getBody());
            updatePostQuery.setTimestamp(4,post.getClosedDate());
            updatePostQuery.setInt(5,post.getCommentCount());
            updatePostQuery.setTimestamp(6,post.getCommunityOwnedDate());
            updatePostQuery.setTimestamp(7,post.getCreationDate());
            updatePostQuery.setInt(8,post.getFavoriteCount());
            updatePostQuery.setTimestamp(9,post.getLastActivityDate());
            updatePostQuery.setTimestamp(10,post.getLastEditDate());
            updatePostQuery.setString(11,post.getLastEditorDisplayName());
            updatePostQuery.setInt(12,post.getLastEditorUserId());
            updatePostQuery.setInt(13,post.getOwnerUserId());
            updatePostQuery.setInt(14,post.getParentId());
            updatePostQuery.setInt(15,post.getPostTypeId());
            updatePostQuery.setInt(16,post.getScore());
            updatePostQuery.setString(17,post.getTags());
            updatePostQuery.setString(18,post.getTitle());
            updatePostQuery.setInt(19,post.getViewCount());
            updatePostQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePost(int id) {
        try {
            deletePostQuery.setInt(1, id);
            deletePostQuery.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
