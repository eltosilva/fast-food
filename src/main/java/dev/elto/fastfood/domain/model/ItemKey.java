package dev.elto.fastfood.domain.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ItemKey implements Serializable {
  @Column(name = "order_id")
  protected Long orderId;

  @Column(name = "dish_id")
  protected Integer dishId;
}
