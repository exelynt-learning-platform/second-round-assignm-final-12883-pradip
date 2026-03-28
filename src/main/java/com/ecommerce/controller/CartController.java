package com.ecommerce.controller;

import com.ecommerce.dto.CartRequest;
import com.ecommerce.entity.CartItem;
import com.ecommerce.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Add product to cart
    @PostMapping("/add")
    public CartItem addToCart(@RequestBody CartRequest request) {
        return cartService.addToCart(
            request.getUserId(),
            request.getProductId(),
            request.getQuantity()
        );
    }

    // Get all cart items for a user
    @GetMapping("/{userId}")
    public List<CartItem> getUserCart(@PathVariable Long userId) {
        return cartService.getUserCart(userId);
    }
}