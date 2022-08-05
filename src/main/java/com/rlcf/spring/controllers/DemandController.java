package com.rlcf.spring.controllers;


import java.util.List;

import com.rlcf.spring.dto.DemandDto;
import com.rlcf.spring.models.EStatus;
import com.rlcf.spring.services.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("demands/{id}")
    public ResponseEntity<HttpStatus> deleteDemand(@PathVariable("id") long id){
        return demandService.deleteDemand(id);
    }

    @PutMapping("/demands/validate/{id}")
    public ResponseEntity<Demand> validateDemand(@PathVariable("id") long id){
        return demandService.validateDemand(id);
    }

    @PutMapping("/demands/reject/{id}")
    public ResponseEntity<Demand> rejectDemand(@PathVariable("id") long id){
        return demandService.rejectDemand(id);
    }

//    @GetMapping("/demands/client")
//    public ResponseEntity<List<Demand>> getDemandClientId(@RequestBody String statut) {
//        return demandService.getDemandStatus(statut);
//    }



}