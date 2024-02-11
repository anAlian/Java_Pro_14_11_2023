package org.mycompany.glovo.controller;

import lombok.RequiredArgsConstructor;

import org.mycompany.glovo.dto.order.OrderDto;
import org.mycompany.glovo.dto.order.ProductDto;
import org.mycompany.glovo.service.order.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/test")

public class TestController {
    private final OrderService orderService;
    @GetMapping("/test")
    public OrderService testService(){



        ProductDto product1=new ProductDto(1,"table",125.0);
        ProductDto product2=new ProductDto(2,"sofa",325.0);
        ProductDto product3=new ProductDto(3,"lamp",55.0);

        OrderDto order1=new OrderDto(1, LocalDate.now(), 450.0, List.of(product1,product2));
        OrderDto order2=new OrderDto(2, LocalDate.now(), 125.0, List.of(product1));
        OrderDto order3=new OrderDto(3, LocalDate.now(), 500.0, List.of(product1,product2,product3));


        orderService.save(order1);
        orderService.save(order2);
        orderService.getOrders();
        orderService.getOrderById(2);
        orderService.updateAddProduct(2,order3);
        orderService.delete(2);
        return null;
    }
}
