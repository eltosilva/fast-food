package dev.elto.fastfood.service;

import java.util.List;
import java.util.Queue;

import org.springframework.stereotype.Service;

import dev.elto.fastfood.domain.dto.OrderCreateDto;
import dev.elto.fastfood.domain.dto.OrderDto;
import dev.elto.fastfood.domain.model.Dish;
import dev.elto.fastfood.domain.model.Item;
import dev.elto.fastfood.domain.model.Order;
import dev.elto.fastfood.domain.repository.DishRepository;
import dev.elto.fastfood.domain.repository.OrderRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {
  private static int nextNumber = 1;

  private OrderRepository orderRepository;
  private DishRepository dishRepository;
  private Queue<Order> caroucel;

  public OrderDto create(OrderCreateDto orderCreate) {
    Order order = new Order(OrderService.nextNumber++);

    List<Dish> dishs = findByIds(orderCreate.getItems());

    for (Dish dish : dishs) {
      Item item = new Item(order, dish);
      order.getItems().add(item);
    }

    order = orderRepository.save(order);

    caroucel.add(order);
    return new OrderDto(order);
  }

  private List<Dish> findByIds(List<Integer> items) {
    List<Dish> dishs = dishRepository.findAll();

    return dishs.stream().filter(dish -> items.contains(dish.getId())).toList();
  }
}