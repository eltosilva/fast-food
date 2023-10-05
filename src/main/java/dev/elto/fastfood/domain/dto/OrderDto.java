package dev.elto.fastfood.domain.dto;

import java.time.LocalDate;
import java.util.List;

import dev.elto.fastfood.domain.model.Order;
import lombok.Getter;

@Getter
public class OrderDto {

  private Integer number;
  private LocalDate date;
  private List<ItemDto> itens;

  public OrderDto(Order orderEntity) {
    number = orderEntity.getNumber();
    date = orderEntity.getDate();
    itens = orderEntity.getItems()
        .stream()
        .map(itemEntity -> new ItemDto(itemEntity))
        .toList();
  }

}
