package com.customerordersystem.controller;

import com.customerordersystem.dto.CustomerRequest;
import com.customerordersystem.dto.SupplierRequest;
import com.customerordersystem.service.impl.CustomerService;
import com.customerordersystem.service.impl.SupplierImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/users")
@RequiredArgsConstructor
public class UserController {

    private final SupplierImpl supplier;
    private final CustomerService customerService;

    @PostMapping("/supplier")
    public ResponseEntity<String> createSupplierAccount(@RequestBody SupplierRequest request){
       supplier.saveSupplierDetails(request);
       return ResponseEntity.ok("Saved successfully");
    }

    @PostMapping("/customer")
    public ResponseEntity<String> createCustomerAccount(@RequestBody CustomerRequest customer){
        customerService.retrieveCustomer(customer);
        return ResponseEntity.ok("Saved successfully");
    }
}
