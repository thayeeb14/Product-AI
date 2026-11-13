package com.iss.Product_Server.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String productId;
    private String productName;
    private double price;
    private String description;
    private int quantity;

}
