package com.customerordersystem.controller;

import com.customerordersystem.dto.CustomerRequest;


import com.customerordersystem.service.query.BaseService;
import com.customerordersystem.service.impl.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/purchase")
@RequiredArgsConstructor
public class BaseController {
    private final OrderService orderService;
    private final BaseService baseService;


    @PostMapping("/order")
    public ResponseEntity<String> saveDetails(@RequestBody CustomerRequest customerRequest){
         orderService.saveOrders(customerRequest);
         return ResponseEntity.ok("You have successfully order!!! You will deliver in no time");
    }

    @GetMapping("/orderedProducts")
    public ResponseEntity<List<Object[]>> customerWithOrderedProducts(){
        List<Object[]> orders = baseService.findCustomerWithOrderedProducts();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
