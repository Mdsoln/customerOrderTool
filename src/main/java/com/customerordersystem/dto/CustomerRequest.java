package com.customerordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomerRequest {
    private String customerName;
    private String customerEmail;
    private String orderDate;
    private String productName;
    private float productPrice;
}
