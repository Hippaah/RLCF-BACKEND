package com.rlcf.spring.services;

import com.rlcf.spring.dto.DemandDto;
import com.rlcf.spring.models.Demand;
import com.rlcf.spring.models.EStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface DemandService {

    public ResponseEntity<Demand> saveDemand(DemandDto demandDto);

    public List<Demand> getDemands();

    public ResponseEntity<Demand> getDemandById(long id);

    public ResponseEntity<Demand> updateDemand(long id, DemandDto demandDto);

    public ResponseEntity<HttpStatus> deleteDemand(long id);

    public ResponseEntity<Demand> validateDemand(long id);

    public ResponseEntity<Demand> rejectDemand(long id);

    }
