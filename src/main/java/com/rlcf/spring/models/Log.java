package com.rlcf.spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Log {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Date dateOperation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_demande")
    private Demand demand;

    @Column
    private String login;

    @Column(name="statut_avant")
    @Enumerated(EnumType.STRING)
    private EStatus statutAvant;

    @Column(name="statut_apres")
    @Enumerated(EnumType.STRING)
    private EStatus statutApres;

    @Column
    private String commentaire;

    public Log(Date dateOperation){
        this.dateOperation = dateOperation;
    };
}
