package dev.elto.fastfood.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Queue;

import org.springframework.stereotype.Service;

import dev.elto.fastfood.domain.dto.OrderDto;
import dev.elto.fastfood.domain.model.Order;
import dev.elto.fastfood.domain.repository.OrderRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KitchenService {
  private OrderRepository orderRepository;
  private Queue<Order> caroucel;
  private List<Order> stove;

  public OrderDto startPreparation() {
    Order order = caroucel.remove();
    order.setKitchenTime(LocalTime.now());

    stove.add(order);

    order = orderRepository.save(order);
    return new OrderDto(order);
  }

  public OrderDto delivery(Integer number) {
    Order order = stove.stream()
        .filter(item -> number.equals(item.getNumber()))
        .findFirst()
        .orElseThrow();

    stove.remove(order);
    order.setCounterTime(LocalTime.now());

    order = orderRepository.save(order);
    return new OrderDto(order);
  }
}
