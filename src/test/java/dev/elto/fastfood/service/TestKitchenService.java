package dev.elto.fastfood.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

import dev.elto.fastfood.domain.dto.OrderDto;
import dev.elto.fastfood.domain.model.Dish;
import dev.elto.fastfood.domain.model.Item;
import dev.elto.fastfood.domain.model.Order;
import dev.elto.fastfood.domain.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
public class TestKitchenService {

  @Mock
  private OrderRepository orderRepository;

  private List<Order> stove;
  private Queue<Order> caroucel;
  private KitchenService kitchenService;
  private Order order;

  @BeforeEach
  private void restart() {
    stove = new ArrayList<>();
    caroucel = new LinkedList<>();
    kitchenService = new KitchenService(orderRepository, caroucel, stove);

    order = stubOrder();
    when(orderRepository.save(any())).thenReturn(order);
  }

  private Order stubOrder() {
    Order order = new Order();
    order.setId(1l);
    order.setDate(LocalDate.now());
    order.setNumber(1);
    order.setItems(new ArrayList<>());

    Dish dish = new Dish();
    Item item = new Item(order, dish);
    order.getItems().add(item);

    return order;
  }

  @Test
  public void shouldDefineThePreparationStartTime() {

    caroucel.add(order);
    OrderDto orderDto = kitchenService.startPreparation();

    assertNotNull(orderDto);
  }

  @Test
  public void shouldRemoveAnOrderInTheCarousel() {

    caroucel.add(order);
    kitchenService.startPreparation();

    assertEquals(0, caroucel.size());
  }

  @Test
  public void shouldAddAnOrderOnTheStove() {

    caroucel.add(order);
    kitchenService.startPreparation();

    assertEquals(1, stove.size());
  }

  @Test
  public void shouldDefineThePreparationEndTime() {
    order.setNumber(1);

    stove.add(order);
    OrderDto orderDto = kitchenService.delivery(1);

    assertNotNull(orderDto);
  }

  @Test
  public void shouldRemoveAnOrderOnTheStove() {
    order.setNumber(1);

    stove.add(order);
    kitchenService.delivery(1);

    assertEquals(0, stove.size());
  }

}
