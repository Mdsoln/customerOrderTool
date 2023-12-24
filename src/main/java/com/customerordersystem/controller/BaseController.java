package com.customerordersystem.controller;

import com.customerordersystem.dto.CustomerRequest;


import com.customerordersystem.service.impl.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/customer")
@RequiredArgsConstructor
public class BaseController {
    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<String> saveDetails(@RequestBody CustomerRequest customerRequest){
         orderService.saveOrders(customerRequest);
         return ResponseEntity.ok("You have successfully order!!! You will deliver in no time");
    }
}
