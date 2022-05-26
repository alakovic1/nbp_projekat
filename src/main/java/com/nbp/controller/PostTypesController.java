package com.nbp.controller;

import com.nbp.db.NBPdao;
import com.nbp.model.PostTypes;
import com.nbp.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postTypes")
public class PostTypesController {
    private NBPdao nbpDao = new NBPdao();

    @PostMapping("/createPostType")
    private ResponseMessage createPostType(@RequestBody PostTypes pt){
        try {
            nbpDao.createPostType(pt);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseMessage(false, HttpStatus.BAD_REQUEST, "There is an error with this request, see log!!");
        }
        return new ResponseMessage(true, HttpStatus.OK, "PostType created and added successfully!!");
    }

    @GetMapping("/readPostType/{id}")
    private PostTypes readPostTypeById(@PathVariable int id){
        return nbpDao.readPostType(id);
    }

    @PostMapping("/updatePostType")
    private ResponseMessage updatePostType(@RequestBody PostTypes pt){
        try {
            nbpDao.updatePostType(pt);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseMessage(false, HttpStatus.BAD_REQUEST, "There is an error with this request, see log!!");
        }
        return new ResponseMessage(true, HttpStatus.OK, "PostType updated successfully!!");
    }

    @GetMapping("/deletePostType/{id}")
    private ResponseMessage deletePostTypeById(@PathVariable int id){
        try {
            nbpDao.deletePostType(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseMessage(false, HttpStatus.BAD_REQUEST, "There is an error with this request, see log!!");
        }
        return new ResponseMessage(true, HttpStatus.OK, "PostType deleted successfully!!");
    }
}
