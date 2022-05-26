package com.nbp.controller;

import com.nbp.db.NBPdao;
import com.nbp.model.Posts;
import com.nbp.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/posts")
public class PostsController {
    private NBPdao nbpDao = new NBPdao();

    @PostMapping("/createPost")
    private ResponseMessage createPost(@RequestBody Posts post){

        Date date = new Date();
        post.setClosedDate(new Timestamp(date.getTime()));
        post.setCommunityOwnedDate(new Timestamp(date.getTime()));
        post.setCreationDate(new Timestamp(date.getTime()));
        post.setLastActivityDate(new Timestamp(date.getTime()));
        post.setLastEditDate(new Timestamp(date.getTime()));

        try {
            nbpDao.createPost(post);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseMessage(false, HttpStatus.BAD_REQUEST, "There is an error with this request, see log!!");
        }
        return new ResponseMessage(true, HttpStatus.OK, "Post created and added successfully!!");
    }

    @GetMapping("/readPost/{id}")
    private Posts readPostById(@PathVariable int id){
        return nbpDao.readPost(id);
    }

    @PostMapping("/updatePost")
    private ResponseMessage updatePost(@RequestBody Posts post){

        Date date = new Date();
        post.setClosedDate(new Timestamp(date.getTime()));
        post.setCommunityOwnedDate(new Timestamp(date.getTime()));
        post.setCreationDate(new Timestamp(date.getTime()));
        post.setLastActivityDate(new Timestamp(date.getTime()));
        post.setLastEditDate(new Timestamp(date.getTime()));

        try {
            nbpDao.updatePost(post);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseMessage(false, HttpStatus.BAD_REQUEST, "There is an error with this request, see log!!");
        }
        return new ResponseMessage(true, HttpStatus.OK, "Post updated successfully!!");
    }

    @GetMapping("/deletePost/{id}")
    private ResponseMessage deletePostById(@PathVariable int id){
        try {
            nbpDao.deletePost(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseMessage(false, HttpStatus.BAD_REQUEST, "There is an error with this request, see log!!");
        }
        return new ResponseMessage(true, HttpStatus.OK, "Post deleted successfully!!");
    }
}
