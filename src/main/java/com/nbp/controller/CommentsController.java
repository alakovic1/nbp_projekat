package com.nbp.controller;

import com.nbp.db.NBPdao;
import com.nbp.model.Comments;
import com.nbp.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    private NBPdao nbpDao = new NBPdao();

    @PostMapping("/createComment")
    private ResponseMessage createComment(@RequestBody Comments comment){

        Date date = new Date();
        comment.setCreationDate(new Timestamp(date.getTime()));

        try {
            nbpDao.createComment(comment);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseMessage(false, HttpStatus.BAD_REQUEST, "There is an error with this request, see log!!");
        }
        return new ResponseMessage(true, HttpStatus.OK, "Comment created and added successfully!!");
    }

    @GetMapping("/readComment/{id}")
    private Comments readCommentById(@PathVariable int id){
        return nbpDao.readComment(id);
    }

    @PostMapping("/updateComment")
    private ResponseMessage updateComment(@RequestBody Comments comment){

        Date date = new Date();
        comment.setCreationDate(new Timestamp(date.getTime()));

        try {
            nbpDao.updateComment(comment);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseMessage(false, HttpStatus.BAD_REQUEST, "There is an error with this request, see log!!");
        }
        return new ResponseMessage(true, HttpStatus.OK, "Comment updated successfully!!");
    }

    @GetMapping("/deleteComment/{id}")
    private ResponseMessage deleteCommentById(@PathVariable int id){
        try {
            nbpDao.deleteComment(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseMessage(false, HttpStatus.BAD_REQUEST, "There is an error with this request, see log!!");
        }
        return new ResponseMessage(true, HttpStatus.OK, "Comment deleted successfully!!");
    }
}
