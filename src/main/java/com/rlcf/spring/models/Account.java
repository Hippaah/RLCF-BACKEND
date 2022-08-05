package com.rlcf.spring.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @NotNull
    private String login;
    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(nullable = false)
    @NotNull
    private String password;
    @ManyToOne(cascade = CascadeType.ALL)
    private Role role;

//    @Override
//    public String toString() {
//        StringBuilder student = new StringBuilder("{ login : ");
//        return student.append(this.login).append(", password : ").append(this.password).append(" }").toString();
//    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Account(@NotNull String login, @NotNull String password) {
        this.login = login;
        this.password = password;
    }

    public Account(@NotNull String login, @NotNull String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

}
