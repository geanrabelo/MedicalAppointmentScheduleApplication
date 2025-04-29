package com.br.core.domain;

import com.br.core.enums.Status;

import java.time.LocalDateTime;

public class Consultation {

    private String id;
    private Patient patient;
    private Medic medic;
    private LocalDateTime hour;
    private Status status;
    private String reasonCancellation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public LocalDateTime getHour() {
        return hour;
    }

    public void setHour(LocalDateTime hour) {
        this.hour = hour;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getReasonCancellation() {
        return reasonCancellation;
    }

    public void setReasonCancellation(String reasonCancellation) {
        this.reasonCancellation = reasonCancellation;
    }

    public Consultation(String id, Patient patient, Medic medic, LocalDateTime hour, Status status, String reasonCancellation) {
        this.id = id;
        this.patient = patient;
        this.medic = medic;
        this.hour = hour;
        this.status = status;
        this.reasonCancellation = reasonCancellation;
    }

    public static class ConsultationBuilder{
        private String id;
        private Patient patient;
        private Medic medic;
        private LocalDateTime hour;
        private Status status;
        private String reasonCancellation;

        public ConsultationBuilder builder(){
            return new ConsultationBuilder();
        }

        public ConsultationBuilder id(String id){
            this.id = id;
            return this;
        }

        public ConsultationBuilder patient(Patient patient){
            this.patient = patient;
            return this;
        }

        public ConsultationBuilder medic(Medic medic){
            this.medic = medic;
            return this;
        }

        public ConsultationBuilder hour(LocalDateTime hour){
            this.hour = hour;
            return this;
        }

        public ConsultationBuilder status(Status status){
            this.status = status;
            return this;
        }

        public ConsultationBuilder reasonCancellation(String reasonCancellation){
            this.reasonCancellation = reasonCancellation;
            return this;
        }

        public Consultation build(){
            return new Consultation(this.id,
                    this.patient,
                    this.medic, this.hour,
                    this.status,
                    this.reasonCancellation);
        }

    }
}
