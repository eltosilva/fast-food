package dev.elto.fastfood.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import static jakarta.persistence.GenerationType.IDENTITY;;

@Entity(name = "orders")
@Getter
@Setter
public class Order {

  public Order() {
    date = LocalDate.now();
    orderTime = LocalTime.now();
  }

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  private Integer number;
  private LocalDate date;
  private LocalTime orderTime;
  private LocalTime kitchenTime;
  private LocalTime counterTime;

  @OneToMany(mappedBy = "order")
  private List<Item> items;
}
