package com.br.infrastructure.config;

import com.br.infrastructure.dto.patient.PatientRedis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory(){
        return new LettuceConnectionFactory("localhost", 6379);
    }

    @Bean
    public RedisTemplate<String, PatientRedis> patientRedisTemplate(){
        RedisTemplate<String, PatientRedis> template = new RedisTemplate<>();
        template.setConnectionFactory(lettuceConnectionFactory());

        template.setKeySerializer(new StringRedisSerializer());

        Jackson2JsonRedisSerializer<PatientRedis> jacksonSerializer = new Jackson2JsonRedisSerializer<>(PatientRedis.class);

        template.setValueSerializer(jacksonSerializer);

        return template;
    }
}
