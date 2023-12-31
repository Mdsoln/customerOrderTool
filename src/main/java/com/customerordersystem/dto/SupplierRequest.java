package com.customerordersystem.dto;

import com.customerordersystem.entity.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private List<Contact> phone_numbers;
    private String company_name;
}
