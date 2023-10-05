package dev.elto.fastfood.domain.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.elto.fastfood.domain.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

  List<Order> findAllByDate(LocalDate today);
}
