package com.nbp.controller;

import com.nbp.db.NBPdao;
import com.nbp.model.Users;
import com.nbp.model.VoteTypes;
import com.nbp.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/users")
public class UsersController {
    private NBPdao nbpDao = new NBPdao();

    @PostMapping("/createUser")
    private ResponseMessage createUser(@RequestBody Users user){

        Date date = new Date();
        user.setCreationDate(new Timestamp(date.getTime()));
        user.setLastAccessDate(new Timestamp(date.getTime()));

        try {
            nbpDao.createUser(user);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseMessage(true, HttpStatus.OK, "User created and added successfully!!");
    }

    @GetMapping("/readUser/{id}")
    private Users readUserById(@PathVariable int id){
        return nbpDao.readUser(id);
    }

    @PostMapping("/updateUser")
    private ResponseMessage updateUser(@RequestBody Users user){

        Date date = new Date();
        user.setCreationDate(new Timestamp(date.getTime()));
        user.setLastAccessDate(new Timestamp(date.getTime()));

        try {
            nbpDao.updateUser(user);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseMessage(true, HttpStatus.OK, "User updated successfully!!");
    }

    @GetMapping("/deleteUser/{id}")
    private ResponseMessage deleteUserById(@PathVariable int id){
        try {
            nbpDao.deleteUser(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseMessage(true, HttpStatus.OK, "User deleted successfully!!");
    }
}
