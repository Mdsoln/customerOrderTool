package com.customerordersystem.entity;

import com.customerordersystem.dto.constants.UserRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * This class holds customer details and interact with database
 * Before a user will need to have an account to make any order
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customer")
public class Customer {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "id",nullable = false)
      private Long customerId;

      @Column(name = "name",nullable = false)
      private String customerName;

      @Column(name = "email",nullable = false)
      private String customerEmail;

      @Column(name = "psw",nullable = false)
      private String customerPsw;

      @Enumerated(value = EnumType.STRING)
      private UserRoles roles;

      @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
      private List<Order> orders;

      @OneToOne(cascade = CascadeType.ALL,mappedBy = "customer",fetch = FetchType.EAGER)
      private Contact contact;
}
