package com.customerordersystem.service.impl;

import com.customerordersystem.dto.SupplierRequest;
import com.customerordersystem.dto.constants.ContactType;
import com.customerordersystem.dto.constants.UserRoles;
import com.customerordersystem.entity.Contact;
import com.customerordersystem.entity.Supplier;
import com.customerordersystem.exc.GlobalException;
import com.customerordersystem.repo.ContactRepo;
import com.customerordersystem.repo.SupplierRepo;
import com.customerordersystem.service.inter.SupplierInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

@Service
@RequiredArgsConstructor
public class SupplierImpl implements SupplierInterface {
     private final SupplierRepo supplierRepo;
     private final ContactRepo contactRepo;
     private final PasswordEncoder passwordEncoder;
    @Override
    public void saveSupplierDetails(SupplierRequest request) {
        if (StringUtils.isEmptyOrWhitespace(request.getName()) || StringUtils.isEmptyOrWhitespace(request.getEmail())
                || StringUtils.isEmptyOrWhitespace(request.getCompany_name()) || StringUtils.isEmptyOrWhitespace(request.getPassword())
                || StringUtils.isEmptyOrWhitespace(request.getPhone_numbers())
        ) {
            throw new GlobalException("All fields are required");
        }else {
            Supplier checkExists = supplierRepo.findBySupplierEmail(request.getEmail());
            if (checkExists !=null){
                throw new GlobalException("Already exists are with email "+request.getEmail());
            }

            Supplier supplier = new Supplier();
            supplier.setSupplierName(request.getName());
            supplier.setSupplierEmail(request.getEmail());
            supplier.setCompanyName(request.getCompany_name());
            supplier.setSupplierPsw(passwordEncoder.encode(request.getPassword()));
            if (request.getEmail().contains("supplier")){
                supplier.setRoles(UserRoles.SUPPLIER);
            }
            supplierRepo.save(supplier);

            Contact contact = new Contact();
            contact.setContacts(request.getPhone_numbers());
            contact.setContactType(ContactType.MOBILE);
            contact.setSupplier(supplier);
            contactRepo.save(contact);
        }
    }
}
