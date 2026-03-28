package com.ecommerce.controller;

import com.ecommerce.dto.PaymentRequest;
import com.ecommerce.entity.Order;
import com.ecommerce.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Mock payment for order
    @PostMapping("/pay")
    public Order pay(@RequestBody PaymentRequest request) {
        return paymentService.pay(request.getUserId(), request.getAmount());
    }
}