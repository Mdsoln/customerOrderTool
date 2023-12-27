package com.customerordersystem.dto;

import com.customerordersystem.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomerRequest {
    private String customerName;
    private String customerEmail;
    private List<Customer> mobile_numbers;
    private String orderDate;
    private String productName;
    private float productPrice;
}
