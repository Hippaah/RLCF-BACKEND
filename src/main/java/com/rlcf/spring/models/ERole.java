package com.rlcf.spring.models;

import javax.persistence.Table;

@Table(name = "erole")
public enum ERole {
    ROLE_ADMIN,
    ROLE_RW,
    ROLE_RO
}
