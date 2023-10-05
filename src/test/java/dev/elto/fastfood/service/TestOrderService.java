package dev.elto.fastfood.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.elto.fastfood.domain.dto.OrderCreateDto;
import dev.elto.fastfood.domain.dto.OrderDto;
import dev.elto.fastfood.domain.model.Dish;
import dev.elto.fastfood.domain.model.Item;
import dev.elto.fastfood.domain.model.Order;
import dev.elto.fastfood.domain.repository.DishRepository;
import dev.elto.fastfood.domain.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
public class TestOrderService {

  @Mock
  private OrderRepository orderRepository;

  @Mock
  private DishRepository dishRepository;

  private Queue<Order> caroucel;
  private OrderService orderService;

  @BeforeEach
  public void restart() {
    caroucel = new LinkedList<>();
    orderService = new OrderService(orderRepository, dishRepository, caroucel);

    Dish dish = new Dish();
    dish.setId(1);
    List<Dish> dishs = new ArrayList<>();
    dishs.add(dish);
    when(dishRepository.findAll()).thenReturn(dishs);

    when(orderRepository.save(any())).thenReturn(stubOrder(dish));
  }

  private Order stubOrder(Dish dish) {
    Order order = new Order();
    order.setId(1l);
    order.setDate(LocalDate.now());
    order.setNumber(1);
    order.setItems(new ArrayList<>());

    Item item = new Item(order, dish);
    order.getItems().add(item);

    return order;
  }

  @Test
  public void testCreate() {
    OrderCreateDto orderCreate = new OrderCreateDto();
    orderCreate.setItems(new ArrayList<>());

    orderCreate.getItems().add(1);

    OrderDto orderDto = orderService.create(orderCreate);

    assertEquals(LocalDate.now(), orderDto.getDate());
  }
}
