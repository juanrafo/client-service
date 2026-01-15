package com.mitocode.microservices.client_service.config;


import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;


import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;


@Configuration
@Slf4j
public class CircuitBreakerCustomConfig {
    
    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
        return factory -> factory.configureDefault(id -> {
            log.info("Circuit Breaker Config for {}", id);
            return new Resilience4JConfigBuilder(id)
                .circuitBreakerConfig(CircuitBreakerConfig.custom()
                    .slidingWindowSize(15)
                    .failureRateThreshold(30)
                    .waitDurationInOpenState(java.time.Duration.ofSeconds(10L))
                    .permittedNumberOfCallsInHalfOpenState(10)
                    .slowCallDurationThreshold(java.time.Duration.ofSeconds(1500L))
                    .slowCallRateThreshold(10)                
                    .build()
        ).build();
    });
    }
}
