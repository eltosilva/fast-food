package dev.elto.fastfood.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.elto.fastfood.domain.dto.DishCreateDto;
import dev.elto.fastfood.domain.dto.DishDto;
import dev.elto.fastfood.domain.model.Dish;
import dev.elto.fastfood.domain.repository.DishRepository;
import jakarta.el.MethodNotFoundException;

@ExtendWith(MockitoExtension.class)
public class TestDishService {

  @Mock
  private DishRepository dishRepository;

  @InjectMocks
  private DishService dishService;

  @Test
  public void testCreateNewDish() {

    DishCreateDto dishCreate = createDishCreateDtoStub();
    when(dishRepository.save(any()))
        .thenReturn(createDishEntityStub());

    DishDto dishDto = this.dishService.create(dishCreate);

    assertEquals(1, dishDto.getId());
  }

  @Test
  public void testFingAllDish() {

    List<Dish> dishsEntity = new ArrayList<Dish>(0) {
      {
        add(createDishEntityStub());
      }
    };

    when(dishRepository.findAllByIsInMenu(true))
        .thenReturn(dishsEntity);
    List<DishDto> dishsDto = dishService.getAll();

    assertEquals(1, dishsDto.size());
  }

  @Test
  public void shouldCallTheDishRepositorysSave() {

    when(dishRepository.findById(1))
      .thenReturn(Optional.of(createDishEntityStub()));

    when(dishRepository.save(any()))
      .thenThrow(new MethodNotFoundException());

    assertThrows(MethodNotFoundException.class, () -> dishService.delete(1));
  }

  private Dish createDishEntityStub() {
    Dish dish = new Dish();

    dish.setId(1);
    dish.setName("X-tudo");
    dish.setDescription("pão, ovo...");
    dish.setPrice(15.30);

    return dish;
  }

  private DishCreateDto createDishCreateDtoStub() {
    DishCreateDto dish = new DishCreateDto();
    dish.setName("X-tudo");
    dish.setDescription("pão, ovo...");
    dish.setPrice(15.30);

    return dish;
  }
}
