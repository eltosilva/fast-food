package dev.elto.fastfood.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishUpdateDto {
  private String name;
  private String description;
  private Double price;
}
