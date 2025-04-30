package com.br.core.enums;

public enum EnumCode {
    MED0000("Medic find by id not found");

    private String message;


    EnumCode(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
