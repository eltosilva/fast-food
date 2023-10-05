package dev.elto.fastfood.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.elto.fastfood.domain.dto.OrderDto;
import dev.elto.fastfood.service.KitchenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Kitchen", description = "Controle da fila de preparo.")
@RestController
@RequestMapping("/kitchen")
@AllArgsConstructor
public class KitchenController {

  private KitchenService kitchenService;

  @PutMapping("/start-preparation")
  public ResponseEntity<OrderDto> startPreparation() {
    OrderDto orderDto = kitchenService.startPreparation();

    return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
  }

  @PutMapping("/delivery/:numberOrder")
  public ResponseEntity<OrderDto> delivery(@PathVariable("numberOrder") Integer numberOrder) {
    OrderDto orderDto = kitchenService.delivery(numberOrder);

    return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
  }
}
