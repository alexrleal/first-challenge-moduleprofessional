package com.devsuperior.desafio01.services;

import com.devsuperior.desafio01.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    public double shipment(Order order) {
        int freight;
        if (order.getBasic() < 100) {
            freight = 20;
        } else if (order.getBasic() < 200) {
            freight = 12;
        } else {
            freight = 0;
        }
        return freight;
    }
}
