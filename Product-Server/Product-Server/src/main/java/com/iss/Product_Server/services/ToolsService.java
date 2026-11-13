package com.iss.Product_Server.services;

import com.iss.Product_Server.models.Cart;
import com.iss.Product_Server.models.Product;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ToolsService {

    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;


    @Tool(description = "Get all available products with their prices and stock")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @Tool(description = "Find a product using product ID")
    public Product getProduct(
            @ToolParam(description = "Product ID such as P101")
            String productId) {
        return productService.getProductById(productId);
    }

    @Tool(description = "Add a product to cart with specified quantity")
    public Cart addToCart(
            @ToolParam(description = "Product ID")
            String productId,

            @ToolParam(description = "Product quantity")
            int quantity) {

        return cartService.addToCart(productId, quantity);
    }

    @Tool(description = "Get cart details including product quantities and grand total")
    public Cart getCart()
    {
        return cartService.getCart();
    }
}
