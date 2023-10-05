package dev.elto.fastfood.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DishCreateDto {
  @NotBlank
  private String name;
  @NotNull
  @Positive
  private Double price;

  private String description;
}
