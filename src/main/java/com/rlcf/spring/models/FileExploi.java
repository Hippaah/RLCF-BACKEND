package com.rlcf.spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "files")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileExploi {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;


    @Column
    private String name;


    @Column
    private String path;

}
