package com.nbp.controller;

import com.nbp.db.NBPdao;
import com.nbp.model.PostLinks;
import com.nbp.model.Votes;
import com.nbp.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/votes")
public class VotesController {
    private NBPdao nbpDao = new NBPdao();

    @PostMapping("/createVote")
    private ResponseMessage createVote(@RequestBody Votes vote){

        Date date = new Date();
        vote.setCreationDate(new Timestamp(date.getTime()));

        try {
            nbpDao.createVote(vote);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseMessage(true, HttpStatus.OK, "Vote created and added successfully!!");
    }

    @GetMapping("/readVote/{id}")
    private Votes readVoteById(@PathVariable int id){
        return nbpDao.readVote(id);
    }

    @PostMapping("/updateVote")
    private ResponseMessage updateVote(@RequestBody Votes vote){

        Date date = new Date();
        vote.setCreationDate(new Timestamp(date.getTime()));

        try {
            nbpDao.updateVote(vote);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseMessage(true, HttpStatus.OK, "Vote updated successfully!!");
    }

    @GetMapping("/deleteVote/{id}")
    private ResponseMessage deleteVoteById(@PathVariable int id){
        try {
            nbpDao.deleteVote(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseMessage(true, HttpStatus.OK, "Vote deleted successfully!!");
    }
}
