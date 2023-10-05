package dev.elto.fastfood.domain.dto;

import dev.elto.fastfood.domain.model.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemDto {

  private Integer dishId;
  private String dishName;
  private Integer account;
  private Double price;

  public ItemDto(Item itemEntity) {
    dishId = itemEntity.getDish().getId();
    dishName = itemEntity.getDish().getName();
    account = itemEntity.getAccount();
    price = itemEntity.getPrice();
  }

}
