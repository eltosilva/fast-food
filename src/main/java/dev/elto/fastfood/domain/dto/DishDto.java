package dev.elto.fastfood.domain.dto;

import dev.elto.fastfood.domain.model.Dish;
import lombok.Getter;

@Getter
public class DishDto {
  private Integer id;
  private String name;
  private String description;
  private Double price;

  public DishDto(Dish dish) {
    id = dish.getId();
    name = dish.getName();
    description = dish.getDescription();
    price = dish.getPrice();
  }
}
