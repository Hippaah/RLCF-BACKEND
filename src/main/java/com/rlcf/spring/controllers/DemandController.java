package com.rlcf.spring.controllers;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.rlcf.spring.Utils.ExcelGenerator;
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

import javax.servlet.http.HttpServletResponse;


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
   public List<Demand> getDemands(){
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

    @GetMapping("/export-to-excel")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Liste des demandes" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        List < Demand > demands =   demandService.getDemands();
        ExcelGenerator generator = new ExcelGenerator(demands);
        generator.generateExcelFile(response);
    }
}