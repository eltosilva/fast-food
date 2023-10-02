package dev.elto.fastfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.elto.fastfood.domain.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
