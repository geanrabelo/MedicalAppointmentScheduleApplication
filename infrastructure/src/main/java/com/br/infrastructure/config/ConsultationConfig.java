package com.br.infrastructure.config;

import com.br.application.gateway.ConsultationGateway;
import com.br.application.impl.ConsultationUsecasesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsultationConfig {

    @Bean
    public ConsultationUsecasesImpl consultationUsecasesImpl(ConsultationGateway consultationGateway){
        return new ConsultationUsecasesImpl(consultationGateway);
    }
}
