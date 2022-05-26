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

    @PostMapping("/createVoteType")
    private ResponseMessage createVoteType(@RequestBody VoteTypes vt){
        try {
            nbpDao.createVoteType(vt);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseMessage(true, HttpStatus.OK, "VoteType created and added successfully!!");
    }

    @GetMapping("/readVoteType/{id}")
    private VoteTypes readVoteTypeById(@PathVariable int id){
        return nbpDao.readVoteType(id);
    }

    @PostMapping("/updateVoteType")
    private ResponseMessage updateVoteType(@RequestBody VoteTypes vt){
        try {
            nbpDao.updateVoteType(vt);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseMessage(true, HttpStatus.OK, "VoteType updated successfully!!");
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
