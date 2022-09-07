package com.example.studentApi.feighnclients;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;

import org.springframework.context.annotation.Bean;


@LoadBalancerClient(value = "address-service")
public class LoadBalancerConfig {

    @LoadBalanced
    @Bean
    public Feign.Builder feignBuilder(){
        return Feign.builder();
    }

}
