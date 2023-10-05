package dev.elto.fastfood.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import dev.elto.fastfood.FastFoodApplication;
import dev.elto.fastfood.domain.dto.OrderCreateDto;
import dev.elto.fastfood.domain.dto.OrderDto;

@SpringBootTest(classes = FastFoodApplication.class)
public class TestOrderService {

  @Autowired
  private OrderService orderService;

  @Test
  public void testCreate() {
    OrderCreateDto orderCreate = new OrderCreateDto();
    orderCreate.setItems(new ArrayList<>());

    orderCreate.getItems().add(1);

    OrderDto orderDto = orderService.create(orderCreate);

    assertEquals(LocalDate.now(), orderDto.getDate());
  }
}
