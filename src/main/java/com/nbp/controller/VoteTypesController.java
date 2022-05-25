package com.nbp.controller;

import com.nbp.db.NBPdao;
import com.nbp.model.VoteTypes;
import com.nbp.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voteTypes")
public class VoteTypesController {
    private NBPdao nbpDao = new NBPdao();

    @PostMapping("/addVoteType")
    private ResponseMessage addUser(@RequestBody VoteTypes vt){
        try {
            nbpDao.addVoteType(vt);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseMessage(true, HttpStatus.OK, "VoteType added successfully!!");
    }

    @GetMapping("/deleteVoteType/{id}")
    private ResponseMessage deleteVoteTypeById(@PathVariable int id){
        try {
            nbpDao.deleteVoteType(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseMessage(true, HttpStatus.OK, "VoteType deleted successfully!!");
    }



}
