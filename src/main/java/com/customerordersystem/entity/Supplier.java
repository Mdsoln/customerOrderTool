package com.customerordersystem.entity;

import com.customerordersystem.dto.constants.UserRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "supplier",fetch = FetchType.EAGER)
    private Contact contacts;
}
