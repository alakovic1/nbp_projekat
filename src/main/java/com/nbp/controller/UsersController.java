package com.nbp.controller;

import com.nbp.db.NBPdao;
import com.nbp.model.Users;
import com.nbp.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("/users")
public class UsersController {
    private NBPdao nbpDao;

    @PostMapping("/addUser")
    private ResponseMessage addUser(@RequestBody Users user){
        nbpDao = new NBPdao();
        try {
            nbpDao.addUser(user);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseMessage(true, HttpStatus.OK, "User added successfully!!");
    }
}
