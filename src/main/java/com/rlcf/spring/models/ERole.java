package com.rlcf.spring.models;

import javax.persistence.Table;

@Table(name = "erole")

public enum ERole {

    ROLE_ADMIN(0,"ROLE_ADMIN"),
    ROLE_RW(1,"ROLE_RW"),
    ROLE_RO(2,"ROLE_RO");
    private int code;
    private String value;

    private ERole(int code, String value){
        this.code = code;
        this.value = value;
    }
}
