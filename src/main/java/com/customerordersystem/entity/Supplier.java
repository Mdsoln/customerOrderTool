package com.customerordersystem.entity;

import com.customerordersystem.dto.roles.UserRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "supplier")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long supplierId;

    @Column(name = "name",nullable = false)
    private String supplierName;

    @Column(name = "company",nullable = false)
    private String companyName;

    @Column(name = "email",nullable = false)
    private String supplierEmail;

    @Column(name = "psw",nullable = false)
    private String supplierPsw;

    @Enumerated(value = EnumType.STRING)
    private UserRoles roles;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer",fetch = FetchType.EAGER)
    private List<Contact> contacts;
}
