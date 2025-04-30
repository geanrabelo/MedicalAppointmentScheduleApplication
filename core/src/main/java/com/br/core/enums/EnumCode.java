package com.br.core.enums;

public enum EnumCode {
    MED0000("Medic find by id not found"),
    MED0001("Medic find by crm not found"),
    MED0002("Already exists medic with crm");

    private String message;


    EnumCode(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
