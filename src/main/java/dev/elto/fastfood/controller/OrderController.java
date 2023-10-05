package dev.elto.fastfood.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.elto.fastfood.domain.dto.OrderCreateDto;
import dev.elto.fastfood.domain.dto.OrderDto;
import dev.elto.fastfood.service.OrderService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Order Taker", description = "Balcão de pedido")
@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

  private OrderService orderService;

  @PostMapping
  public ResponseEntity<OrderDto> create(@RequestBody OrderCreateDto orderCreate) {
    OrderDto order = orderService.create(orderCreate);

    return ResponseEntity.status(HttpStatus.CREATED).body(order);
  }
}
