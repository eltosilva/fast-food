package dev.elto.fastfood.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.elto.fastfood.domain.dto.DishCreateDto;
import dev.elto.fastfood.domain.dto.DishDto;
import dev.elto.fastfood.service.DishService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Menu", description = "Lanches, sobremesas e bebidas")
@RestController
@RequestMapping("/menu")
public class DishController {

  private DishService dishService;

  public DishController(DishService dishService) {
    this.dishService = dishService;
  }

  @GetMapping
  public ResponseEntity<List<DishDto>> getAll() {

    return ResponseEntity
        .ok(dishService.getAll());
  }

  @PostMapping
  public ResponseEntity<DishDto> create(@RequestBody DishCreateDto dishCreate) {

    return ResponseEntity
        .ok(dishService.create(dishCreate));
  }

  @DeleteMapping(path = "/:id")
  public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
    dishService.delete(id);

    return ResponseEntity.noContent().build();
  }
}
