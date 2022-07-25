package com.rlcf.spring.controllers;


import java.util.List;

import com.rlcf.spring.dto.DemandDto;
import com.rlcf.spring.Old.services.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rlcf.spring.models.Demand;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")

public class DemandController {

    @Autowired
    DemandService demandService ;

    @PostMapping("/demands")
    // add the authority
    public ResponseEntity<Demand> saveDemand(@RequestBody DemandDto demandDto) {
        return  demandService.saveDemand(demandDto);
    }


   @GetMapping("/demands")
   public ResponseEntity<List<Demand>> getDemands(){
        return demandService.getDemands();
   }


   @GetMapping("/demands/{id}")
    public ResponseEntity<Demand> getDemandById(@PathVariable("id") long id) {
        return demandService.getDemandById(id);
    }


    @PutMapping("/demands/{id}")
    public ResponseEntity<Demand> updateDemand(@PathVariable("id") long id, @RequestBody DemandDto demandDto){
        return demandService.updateDemand(id,demandDto);
    }

    @DeleteMapping("demands/{id}")
    public ResponseEntity<HttpStatus> deleteDemand(@PathVariable("id") long id){
        System.err.println("this is the var"+id);
        return demandService.deleteDemand(id);
    }

}