package dev.elto.fastfood.domain.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.Setter;
import static jakarta.persistence.CascadeType.ALL;

import jakarta.persistence.Column;;

@Entity(name = "items")
@Getter
@Setter
public class Item {

  @EmbeddedId
  private ItemKey id;

  @ManyToOne(cascade = ALL)
  @MapsId("dishId")
  @JoinColumn(name = "dish_id")
  private Dish dish;

  @ManyToOne(cascade = ALL)
  @MapsId("orderId")
  @JoinColumn(name = "order_id")
  private Order order;

  @Column(nullable = false)
  private Double price;

  @Column(nullable = false)
  private Integer account;

  public Item(Order order, Dish dish) {
    this.order = order;
    this.dish = dish;
  }
}
