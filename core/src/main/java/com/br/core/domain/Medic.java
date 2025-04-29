package com.br.core.domain;

import com.br.core.enums.Specialty;

import java.time.LocalDateTime;
import java.util.List;

public class Medic {

    private Long id;
    private String name;
    private String crm;
    private Specialty specialty;
    private List<LocalDateTime> openingHours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<LocalDateTime> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(List<LocalDateTime> openingHours) {
        this.openingHours = openingHours;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Medic(Long id, String name, String crm, Specialty specialty, List<LocalDateTime> openingHours) {
        this.id = id;
        this.name = name;
        this.crm = crm;
        this.specialty = specialty;
        this.openingHours = openingHours;
    }

    public static class MedicBuilder{
        private Long id;
        private String name;
        private String crm;
        private Specialty specialty;
        private List<LocalDateTime> openingHours;

        public MedicBuilder builder(){
            return new MedicBuilder();
        }

        public MedicBuilder id(Long id){
            this.id = id;
            return this;
        }

        public MedicBuilder name(String name){
            this.name = name;
            return this;
        }

        public MedicBuilder crm(String crm){
            this.crm = crm;
            return this;
        }

        public MedicBuilder speciality(Specialty specialty){
            this.specialty = specialty;
            return this;
        }

        public MedicBuilder openingHours(List<LocalDateTime> openingHours){
            this.openingHours = openingHours;
            return this;
        }

        public Medic build(){
            return new Medic(this.id, this.name, this.crm, this.specialty, this.openingHours);
        }
    }
}
