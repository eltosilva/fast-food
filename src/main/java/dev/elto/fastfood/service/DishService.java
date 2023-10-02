package dev.elto.fastfood.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.elto.fastfood.domain.dto.DishCreateDto;
import dev.elto.fastfood.domain.dto.DishDto;
import dev.elto.fastfood.domain.dto.DishUpdateDto;
import dev.elto.fastfood.domain.model.Dish;
import dev.elto.fastfood.domain.repository.DishRepository;

@Service
public class DishService {

  private DishRepository dishRepository;

  public DishService(DishRepository dish) {
    dishRepository = dish;
  }

  public DishDto create(DishCreateDto dishDto) {

    Dish dishEntity = new Dish(dishDto);

    return new DishDto(dishRepository.save(dishEntity));
  }

  public List<DishDto> getAll() {
    List<Dish> dishs = dishRepository.findAllByIsInMenu(Boolean.TRUE);

    return dishs.stream()
        .map(dish -> new DishDto(dish))
        .collect(Collectors.toList());
  }

  public DishDto update(Integer id, DishUpdateDto dishDto) {
    Dish dishEntity = dishRepository.findById(id).orElseThrow();

    dishEntity.update(dishDto);

    return new DishDto(dishRepository.save(dishEntity));
  }

  public void delete(Integer id) {
    Dish dishEntity = dishRepository.findById(id).orElseThrow();

    dishEntity.setIsInMenu(Boolean.FALSE);
    dishRepository.save(dishEntity);
  }

}
