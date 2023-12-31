package com.customerordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierRequest {
    private String name;
    private String email;
    private String password;
    private String phone_numbers;
    private String company_name;
}
