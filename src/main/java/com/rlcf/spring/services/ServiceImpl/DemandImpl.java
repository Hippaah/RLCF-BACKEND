package com.rlcf.spring.services.ServiceImpl;

import com.rlcf.spring.dto.ClientDto;
import com.rlcf.spring.dto.DemandDto;
import com.rlcf.spring.dto.ProductDto;
import com.rlcf.spring.models.*;
import com.rlcf.spring.repository.DemandRepository;
import com.rlcf.spring.repository.FileRepository;
import com.rlcf.spring.Old.services.DemandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DemandImpl implements DemandService {
    @Autowired
    private  DemandRepository demandRepository;

    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Demand> saveDemand(DemandDto demandDto) {
        Date date = new Date();
        ClientDto clientDto = demandDto.getClientDto();
        ProductDto productDto = demandDto.getProductDto();
        Client client =modelMapper.map(clientDto,Client.class);
        Product product =modelMapper.map(productDto,Product.class);
        Demand demand= new Demand(date,date, EStatus.EN_ATTENTE_VALIDATION);
        FileExploi fileExploi = fileRepository.findById(demandDto.getFileId()).orElse(null);
        demand.setClient(client);
        demand.setProduct(product);
        demand.setFile(fileExploi);
       //demandRepository.save(demand);
       Demand _demand = null;
        try {
             _demand = demandRepository
                    .save(demand);
        } catch(Exception e) {
            System.out.print(e.getMessage());
        }

       return new ResponseEntity<>(_demand, HttpStatus.CREATED);
       // return demandDto;
    }

     @Override
     public ResponseEntity<List<Demand>> getDemands() {
             List<Demand> demands = new ArrayList<Demand>();
         try {
            // if (id == null)
                 demandRepository.findAll().forEach(demands::add);
//             else
//                  demandRepository.findById(id).forEach(demands::add);
 
                 if (demands.isEmpty()) {
                     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                 }
 
             return new ResponseEntity<>(demands, HttpStatus.OK);
         } catch (Exception e) {
             System.out.print(e.getMessage());
         }
         return new ResponseEntity<>(demands, HttpStatus.OK);
     }

     @Override
     public ResponseEntity<Demand> getDemandById(@PathVariable("id") long id) {
         Optional<Demand> demandData = demandRepository.findById(id);

         if (demandData.isPresent()) {
             return new ResponseEntity<>(demandData.get(), HttpStatus.OK);
         } else {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }

     }

    @Override
    public ResponseEntity<Demand> updateDemand(@PathVariable("id") long id, DemandDto demandDto) {

        Optional<Demand> demandData = demandRepository.findById(id);
        if (demandData.isPresent()) {
            Date date = new Date();
            Demand _demand = demandData.get();
            _demand.setClient(modelMapper.map(demandDto.getClientDto(),Client.class));
            _demand.setProduct(modelMapper.map(demandDto.getProductDto(),Product.class));
            _demand.setUpdateDate(date);
            _demand.setStatut(EStatus.EN_ATTENTE_VALIDATION);
            return new ResponseEntity<>(demandRepository.save(_demand), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteDemand(@PathVariable("id") long id) {
        try {
            demandRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}



