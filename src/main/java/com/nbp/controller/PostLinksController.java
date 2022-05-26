package com.nbp.controller;

import com.nbp.db.NBPdao;
import com.nbp.model.Comments;
import com.nbp.model.PostLinks;
import com.nbp.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/postLinks")
public class PostLinksController {
    private NBPdao nbpDao = new NBPdao();

    @PostMapping("/createPostLink")
    private ResponseMessage createPostLink(@RequestBody PostLinks pl){

        Date date = new Date();
        pl.setCreationDate(new Timestamp(date.getTime()));

        try {
            nbpDao.createPostLink(pl);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseMessage(true, HttpStatus.OK, "PostLink created and added successfully!!");
    }

    @GetMapping("/readPostLink/{id}")
    private PostLinks readPostLinkById(@PathVariable int id){
        return nbpDao.readPostLink(id);
    }

    @PostMapping("/updatePostLink")
    private ResponseMessage updatePostLink(@RequestBody PostLinks pl){

        Date date = new Date();
        pl.setCreationDate(new Timestamp(date.getTime()));

        try {
            nbpDao.updatePostLink(pl);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseMessage(true, HttpStatus.OK, "PostLink updated successfully!!");
    }

    @GetMapping("/deletePostLink/{id}")
    private ResponseMessage deletePostLinkById(@PathVariable int id){
        try {
            nbpDao.deletePostLink(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseMessage(true, HttpStatus.OK, "PostLink deleted successfully!!");
    }
}
