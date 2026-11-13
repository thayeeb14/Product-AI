package com.iss.Product_Server.services;

import com.iss.Product_Server.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = List.of(

            new Product("P101", "Travel Mug",
                    599, "500 ml stainless steel mug", 15),

            new Product("P102", "Water Bottle",
                    199, "1 litre stainless steel bottle", 10),

            new Product("P103", "Laptop",
                    55000, "HP laptop with 16GB RAM and 512GB SSD", 8),

            new Product("P104", "Wireless Mouse",
                    799, "2.4GHz wireless optical mouse", 25),

            new Product("P105", "Mechanical Keyboard",
                    2499, "RGB mechanical gaming keyboard", 12),

            new Product("P106", "Headphones",
                    1499, "Wireless Bluetooth over-ear headphones", 20),

            new Product("P107", "Smart Watch",
                    2999, "Fitness tracking smartwatch", 10),

            new Product("P108", "USB Flash Drive",
                    499, "64GB USB 3.0 flash drive", 30),

            new Product("P109", "Power Bank",
                    1299, "20000mAh fast charging power bank", 18),

            new Product("P110", "Bluetooth Speaker",
                    1799, "Portable Bluetooth speaker", 14),

            new Product("P111", "Office Chair",
                    5999, "Ergonomic adjustable office chair", 5),

            new Product("P112", "Backpack",
                    999, "Water-resistant laptop backpack", 22),

            new Product("P113", "Running Shoes",
                    1999, "Lightweight sports running shoes", 16),

            new Product("P114", "LED Desk Lamp",
                    899, "Adjustable LED study desk lamp", 13),

            new Product("P115", "Webcam",
                    2199, "Full HD 1080p USB webcam", 9)
    );

    public List<Product> getAllProducts()
    {
        return products;
    }

    public Product getProductById(String productId)
    {
        for (Product p : products)
        {
            if (p.getProductId().equalsIgnoreCase(productId))
            {
                return p;
            }
        }
        return null;
    }
}
