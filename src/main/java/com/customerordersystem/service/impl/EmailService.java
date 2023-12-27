package com.customerordersystem.service.impl;

import com.customerordersystem.dto.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;

    public void SendAlertToSupplierAfterOrders(CustomerRequest customerRequest){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("Customer Orders:");
        mailMessage.setTo("supplierEmail@gmail.com");
        mailMessage.setText("Customer: "+customerRequest.getCustomerName()+ " with email "+
              customerRequest.getCustomerEmail() + " has ordered product "+customerRequest.getProductName());

        javaMailSender.send(mailMessage);
    }
}
