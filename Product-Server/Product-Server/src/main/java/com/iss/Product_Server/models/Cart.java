package com.iss.Product_Server.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    private List<Product> items;
    private int totalProductCount;
    private int totalQuantity;
    private double totalPrice;
}