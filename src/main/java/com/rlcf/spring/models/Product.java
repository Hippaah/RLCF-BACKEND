package com.rlcf.spring.models;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter


public class Product {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column
    private String idConnexion;


     @Column
     private String acces;
 
     @Column
     private String ligneProduit;
 
     @Column
     private String bsSecSWPort;
 
     @Column
     private String typeService;
 
     @Column
     private String vlanVoix;
 
     @Column
     private String typeLien;
 
     @Column
     private String ipVoix;
 
     @Column
     private String debit;
 
     @Column
     private String topologie;
 
     @Column
     private String numCanaux;
 
     @Column
     private String popSTraitant;
 
     @Column
     private String numSDA;
 
     @Column
     private String comment;
 
     @Column
     private String designationSDA;
 
     @Column
     private String msisdn;
 
     @Column
     private String etat;
 
     @Column
     private String icc;
 
     @Column
     private String dateService;
 
     @Column
     private String numSerie;
 
     @Column
     private String dateRealisation;
 
     @Column
     private String imei;

}
