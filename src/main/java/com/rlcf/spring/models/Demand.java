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

//    @Column()
//    private int demandNum;

    @Column(nullable = false)
    private Date creationDate;

    @Column(nullable = false)
    private Date updateDate;

    @Column()
    private Date validationDate;

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
    @Enumerated(EnumType.STRING)
    private EStatus statut;

    public Demand(Date creationDate, Date updateDate, EStatus statut){
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.statut = statut;
    };

    public Demand(Date updateDate, EStatus statut){
        this.updateDate = updateDate;
        this.statut = statut;
    };

}
