package com.rlcf.spring.Old.services;

import com.rlcf.spring.dto.DemandDto;
import com.rlcf.spring.models.Demand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface DemandService {

    public ResponseEntity<Demand> saveDemand(DemandDto demandDto);

    public ResponseEntity<List<Demand>> getDemands();

    public ResponseEntity<Demand> getDemandById(long id);

    public ResponseEntity<Demand> updateDemand(long id, DemandDto demandDto);

    public ResponseEntity<HttpStatus> deleteDemand(long id);
    }
