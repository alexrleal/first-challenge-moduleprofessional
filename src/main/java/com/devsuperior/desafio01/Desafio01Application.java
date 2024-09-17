package com.devsuperior.desafio01;

import com.devsuperior.desafio01.entities.Order;
import com.devsuperior.desafio01.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Desafio01Application implements CommandLineRunner {
    private OrderService orderService;

    public Desafio01Application(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Desafio01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o codigo do pedido: ");
        Integer code = scanner.nextInt();
        System.out.print("Valor: ");
        Double basic = scanner.nextDouble();
        System.out.print("Valor: ");
        Double discount = scanner.nextDouble();
        Order order = new Order(code, basic, discount);
        Double total = orderService.total(order);

        System.out.println("=========================");
        System.out.println("Pedido codigo: " + order.getCode());
        System.out.println("Valor total: R$ " + String.format("%.2f", total));
    }
}

