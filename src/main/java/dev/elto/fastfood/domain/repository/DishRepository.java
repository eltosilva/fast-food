package dev.elto.fastfood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.elto.fastfood.domain.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

  List<Dish> findAllByIsInMenuIsTrue();
}
