package com.br.infrastructure.config;

import com.br.application.gateway.PatientGateway;
import com.br.application.impl.PatientUsecasesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatientConfig {

    @Bean
    public PatientUsecasesImpl patientUsecasesImpl(PatientGateway patientGateway){
        return new PatientUsecasesImpl(patientGateway);
    }
}
