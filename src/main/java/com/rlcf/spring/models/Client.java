package com.rlcf.spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "client")
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Client {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column()
    private String idClient;

    @Column( length = 250)
    private String contact;


    @Column(length = 250)
    private String client;


    @Column(length = 120)
    private String  contact2;


    @Column(length = 80)
    private String segment;



    @Column(length = 50)
    private String mail;


    @Column( length = 50)
    private String typeClient;


    @Column
    private String tel;


    @Column(length = 100)
    private String priorite;


    @Column(length = 100)
    private String cdp;


    @Column
    private String sla;


    @Column
    private String address;


    @Column
    private String slaGtr;

    @Column
    private String ville;

    @Column
    private String tam;

    }


