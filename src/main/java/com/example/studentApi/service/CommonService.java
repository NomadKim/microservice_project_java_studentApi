package com.example.studentApi.service;

import com.example.studentApi.feighnclients.FeignClients;
import com.example.studentApi.responce.AddressResponce;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommonService {

    @Autowired
    private FeignClients feignClients;

    Logger logger = LoggerFactory.getLogger(CommonService.class);
    long count = 1;


    @CircuitBreaker(name="addressService", fallbackMethod = "fallbackGetAddressid")
    public AddressResponce getAddressById(Long addressId){
        logger.info("count = " + count);
        count++;
        AddressResponce addressResponce = feignClients.getById(addressId);

        return addressResponce;
    }

    public AddressResponce fallbackGetAddressid(Long addressId, Throwable th){
        logger.error("Error Resiliance 4j");
        return new AddressResponce();
    }

}
