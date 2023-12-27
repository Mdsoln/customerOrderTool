package com.customerordersystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long productId;
    @Column(name = "name",nullable = false)
    private String productName;
    @Column(name = "price",nullable = false)
    private float productPrice;
    @Column(name = "quantity",nullable = false)
    private int productQuantity;
    @Column(name = "description",nullable = false)
    private String productDescription;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    private List<Order> orderList;
}
