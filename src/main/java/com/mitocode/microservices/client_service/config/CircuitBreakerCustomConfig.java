package com.mitocode.microservices.client_service.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

//@Slf4j
//@Configuration
public class CircuitBreakerCustomConfig {
//    @Bean
//    public Customizer<Resilience4JCircuitBreakerFactory> overrideDefaultConfig() {
//        return factory -> factory.configureDefault(id -> {
//            log.info("===> Creating circuit breaker instance: " + id);
//            return new Resilience4JConfigBuilder(id)
//                    .circuitBreakerConfig(CircuitBreakerConfig.custom()
//                            .slidingWindowSize(20) // default: 100 reauests
//                            .failureRateThreshold(75) // default 50%
//                            .waitDurationInOpenState(Duration.ofSeconds(30L)) // 60 segs
//                            .permittedNumberOfCallsInHalfOpenState(10) // 10
//                            .slowCallDurationThreshold(Duration.ofMillis(1500L))
//                            .slowCallRateThreshold(10)
//                            .build()
//                    )
//                    .timeLimiterConfig(TimeLimiterConfig.custom()
//                            .timeoutDuration(Duration.ofMillis(1500))
//                            .build())
//
//                    .build();
//        });
//    }
}