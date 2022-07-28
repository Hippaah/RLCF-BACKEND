package com.rlcf.spring.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.*;

@Table(name = "status")

public enum EStatus {
    EN_ATTENTE_VALIDATION(0,"EN_ATTENTE_VALIDATION"),
    VALIDER(1,"VALIDER"),
    REJETER(2,"REJETER"),
    SUPPRIMER(3,"SUPPRIMER");
    private int code;
    private String value;

    private EStatus(int code, String value){
        this.code = code;
        this.value = value;
    }

    public long getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public static List<EStatus> list() {
        List<EStatus> enums = new ArrayList<EStatus>();
        for(EStatus answer : EStatus.values()){
            enums.add(answer);
        }
        return enums;
    }
    public static EStatus valueOfValue(String value) {
        for(EStatus answer : EStatus.values()){
            if(answer.getValue().equals(value)){
                return answer;
            }
        }
        return null;
    }
    public static EStatus valueOfId(int code) {

        for(EStatus answer : EStatus.values()){
            if(answer.getCode()==code){
                return answer;
            }
        }
        return null;
    }



}