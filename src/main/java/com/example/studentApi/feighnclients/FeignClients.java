package com.example.studentApi.feighnclients;

import com.example.studentApi.responce.AddressResponce;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "api-gateaway-service", path = "/address-service/api/address/api")
public interface FeignClients {

    @GetMapping("/getById/{id}")
    AddressResponce getById(@PathVariable Long id);


}
