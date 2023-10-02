package dev.elto.fastfood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.elto.fastfood.domain.model.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer> {

  List<Dish> findAllByIsInMenu(Boolean isInMenu);
}
