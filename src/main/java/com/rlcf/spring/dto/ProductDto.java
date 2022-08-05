package com.rlcf.spring.dto;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class ProductDto {
  
   private String idConnexion;
      private String acces;
      private String ligneProduit;
      private String bsSecSWPort;
      private String typeService;
      private String vlanVoix;
      private String typeLien;
      private String ipVoix;
      private String debit;
      private String topologie;
      private String numCanaux;
      private String popSTraitant;
      private String numSDA;
      private String comment;
      private String designationSDA;
      private String msisdn;
      private String etat;
      private String icc;
      private Date dateService;
      private String numSerie;
      private String dateRealisation;
      private String imei;
      private String urlGlobus;
}
