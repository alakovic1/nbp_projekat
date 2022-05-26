package com.nbp.controller;

import com.nbp.db.NBPdao;
import com.nbp.model.Badges;
import com.nbp.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping("/badges")
public class BadgesController {

    private NBPdao nbpDao = new NBPdao();

    @PostMapping("/createBadge")
    private ResponseMessage createBadge(@RequestBody Badges badge){

        Date date = new Date();
        badge.setDates(new Timestamp(date.getTime()));

        try {
            nbpDao.createBadge(badge);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseMessage(false, HttpStatus.BAD_REQUEST, "There is an error with this request, see log!!");
        }
        return new ResponseMessage(true, HttpStatus.OK, "Badge created and added successfully!!");
    }

    @GetMapping("/readBadge/{id}")
    private Badges readBadgeById(@PathVariable int id){
        return nbpDao.readBadge(id);
    }

    @PostMapping("/updateBadge")
    private ResponseMessage updateBadge(@RequestBody Badges badge){

        Date date = new Date();
        badge.setDates(new Timestamp(date.getTime()));

        try {
            nbpDao.updateBadge(badge);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseMessage(false, HttpStatus.BAD_REQUEST, "There is an error with this request, see log!!");
        }
        return new ResponseMessage(true, HttpStatus.OK, "Badge updated successfully!!");
    }

    @GetMapping("/deleteBadge/{id}")
    private ResponseMessage deleteBadgeById(@PathVariable int id){
        try {
            nbpDao.deleteBadge(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseMessage(false, HttpStatus.BAD_REQUEST, "There is an error with this request, see log!!");
        }
        return new ResponseMessage(true, HttpStatus.OK, "Badge deleted successfully!!");
    }

}
