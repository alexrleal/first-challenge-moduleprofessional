package com.devsuperior.desafio01.services;

import com.devsuperior.desafio01.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {
        Double discount = order.getDiscount() / 100.00 * order.getBasic();
        return order.getBasic()
                - discount
                + shippingService.shipment(order);
    }
}
