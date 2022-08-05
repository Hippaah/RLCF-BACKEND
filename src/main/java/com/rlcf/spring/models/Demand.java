package com.rlcf.spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "demands")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Demand {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String creationDate;

    @Column(nullable = false)
    private String updateDate;

    @Column()
    private String validationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_product")
    public Product product;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client")
    private Client client;

    @OneToOne()
    @JoinColumn(name = "id_file")
    private FileExploi file;

    @Column
    private String statut;

    public Demand(String creationDate, String updateDate, String statut){
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.statut = statut;
    };

    public Demand(String updateDate, String statut){
        this.updateDate = updateDate;
        this.statut = statut;
    };

}
