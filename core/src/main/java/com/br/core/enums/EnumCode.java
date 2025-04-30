package com.br.core.enums;

public enum EnumCode {
    MED0000("Medic find by id not found"),
    MED0001("Medic find by crm not found"),
    MED0002("Already exists medic with crm"),
    MED0003("Medic not available in this hour"),
    PAT0000("Patient find by id not found"),
    PAT0001("Patient find by cpf not found"),
    PAT0002("Already exists patient with cpf");

    private String message;


    EnumCode(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
