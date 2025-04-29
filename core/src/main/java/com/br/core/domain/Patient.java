package com.br.core.domain;

import java.time.LocalDate;

public class Patient {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String numberPhone;
    private LocalDate dateOfBirth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Patient(Long id, String name, String cpf, String email, String numberPhone, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.numberPhone = numberPhone;
        this.dateOfBirth = dateOfBirth;
    }

    public static class PatientBuilder{
        private Long id;
        private String name;
        private String cpf;
        private String email;
        private String numberPhone;
        private LocalDate dateOfBirth;

        public PatientBuilder builder(){
            return new PatientBuilder();
        }

        public PatientBuilder id(Long id){
            this.id = id;
            return this;
        }

        public PatientBuilder name(String name){
            this.name = name;
            return this;
        }

        public PatientBuilder cpf(String cpf){
            this.cpf = cpf;
            return this;
        }

        public PatientBuilder email(String email){
            this.email = email;
            return this;
        }

        public PatientBuilder numberPhone(String numberPhone){
            this.numberPhone = numberPhone;
            return this;
        }

        public PatientBuilder dateOfBirth(LocalDate dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Patient build(){
            return new Patient(this.id,
                    this.name,
                    this.cpf,
                    this.email,
                    this.numberPhone,
                    this.dateOfBirth);
        }
    }
}
