package com.nbp.controller;

import com.nbp.db.NBPdao;
import com.nbp.model.LinkTypes;
import com.nbp.model.PostTypes;
import com.nbp.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/linkTypes")
public class LinkTypesController {

    private NBPdao nbpDao = new NBPdao();

    @PostMapping("/createLinkType")
    private ResponseMessage createLinkType(@RequestBody LinkTypes lt){
        try {
            nbpDao.createLinkType(lt);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseMessage(true, HttpStatus.OK, "LinkType created and added successfully!!");
    }

    @GetMapping("/readLinkType/{id}")
    private LinkTypes readLinkTypeById(@PathVariable int id){
        return nbpDao.readLinkType(id);
    }

    @PostMapping("/updateLinkType")
    private ResponseMessage updateLinkType(@RequestBody LinkTypes lt){
        try {
            nbpDao.updateLinkType(lt);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseMessage(true, HttpStatus.OK, "LinkType updated successfully!!");
    }

    @GetMapping("/deleteLinkType/{id}")
    private ResponseMessage deleteLinkTypeById(@PathVariable int id){
        try {
            nbpDao.deleteLinkType(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseMessage(true, HttpStatus.OK, "LinkType deleted successfully!!");
    }

}
