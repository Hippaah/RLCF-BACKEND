package com.rlcf.spring.dto;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Version;
import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor
@Setter
@Getter
public class ClientDto {
    private String idClient;
    private String contact;
    private String client;
    private String  contact2;
       private String segment;
       private String mail;
       private String typeClient;
       private String tel;
       private String priorite;
       private String  cdp;
       private String sla;
       private String address;
       private String slaGtr;
       private String ville;
       private String tam;


}
