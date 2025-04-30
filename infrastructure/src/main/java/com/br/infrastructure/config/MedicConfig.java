package com.br.infrastructure.config;

import com.br.application.gateway.MedicGateway;
import com.br.application.impl.MedicUsecasesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicConfig {

    @Bean
    public MedicUsecasesImpl medicUsecasesImpl(MedicGateway medicGateway){
        return new MedicUsecasesImpl(medicGateway);
    }
}
