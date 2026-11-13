package com.iss.Product_Server.services;

import com.iss.Product_Server.models.Cart;
import com.iss.Product_Server.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    ProductService productService;

    List<Product> cartItems = new ArrayList<>();

    public Cart addToCart(String productId, int quantity)
    {
        Product product = productService.getProductById(productId);

        Product existingProduct = null;

        for (Product p : cartItems) {
            if (p.getProductId().equalsIgnoreCase(productId)) {
                existingProduct = p;
                break;
            }
        }

        if (existingProduct != null)
        {
            existingProduct.setQuantity(existingProduct.getQuantity() + quantity);
        }
        else {
            Product cartProduct = new Product(
                    product.getProductId(),
                    product.getProductName(),
                    product.getPrice(),
                    product.getDescription(),
                    quantity
            );
            cartItems.add(cartProduct);
        }

        return getCart();
    }

    public Cart getCart()
    {
        int totalProductCount = cartItems.size();

        int totalQuantity = 0;
        double totalPrice = 0;

        for (Product p : cartItems)
        {
            totalQuantity += p.getQuantity();
            totalPrice += p.getPrice() * p.getQuantity();
        }

        return new Cart(
                new ArrayList<>(cartItems),
                totalProductCount,
                totalQuantity,
                totalPrice
        );
    }
}
