package dev.elto.fastfood.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static jakarta.persistence.GenerationType.IDENTITY;

import dev.elto.fastfood.domain.dto.DishCreateDto;
import dev.elto.fastfood.domain.dto.DishUpdateDto;;

@Entity(name = "dishs")
@Getter
@Setter
@NoArgsConstructor
public class Dish {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, precision = 2, length = 4)
  private Double price;

  private String description;
  private Boolean isInMenu = Boolean.TRUE;

  public Dish(DishCreateDto dishDto) {
    name = dishDto.getName();
    description = dishDto.getDescription();
    price = dishDto.getPrice();
  }

  public void update(DishUpdateDto dishDto) {
    if (dishDto.getName() != null && !dishDto.getName().isEmpty())
      name = dishDto.getName();

    if (dishDto.getDescription() != null && !dishDto.getDescription().isEmpty())
      description = dishDto.getDescription();

    if (dishDto.getPrice() != null && dishDto.getPrice() > 0)
      price = dishDto.getPrice();

  }
}
