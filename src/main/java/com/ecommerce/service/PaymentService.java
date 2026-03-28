package com.ecommerce.service;

import com.ecommerce.entity.Order;
import com.ecommerce.entity.User;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Autowired
    public PaymentService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    // Mock payment method
    public Order pay(Long userId, double amount) {
        // Find the user or throw exception
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Create new order
        Order order = new Order();
        order.setUser(user);          // ✅ Works
        order.setTotalAmount(amount);  // ✅ Works
     // ✅ Mock payment logic
        order.setStatus("PAID");

        // ✅ Fake payment ID (like Stripe)
        order.setPaymentId("PAY_" + System.currentTimeMillis());
        return orderRepository.save(order);
    }
}