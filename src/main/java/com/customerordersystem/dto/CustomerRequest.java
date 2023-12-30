package com.customerordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomerRequest {
    private String customerName;
    private String customerEmail;
    private String customerPsw;
    private String mobile_numbers;
    private String orderDate;
    private String productName;
    private float productPrice;
}
