package dev.elto.fastfood.service;

import org.springframework.stereotype.Service;

import dev.elto.fastfood.domain.repository.OrderRepository;

@Service
public class OrderService {

  private OrderRepository orderRepository;

  public OrderService(OrderRepository order) {
    orderRepository = order;
  }
}
