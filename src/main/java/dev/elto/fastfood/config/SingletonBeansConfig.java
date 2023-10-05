package dev.elto.fastfood.config;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.elto.fastfood.domain.model.Order;

@Configuration
public class SingletonBeansConfig {

  @Bean
  public Queue<Order> createCaroucel() {
    return new LinkedList<>();
  }

  @Bean
  public List<Order> createStove() {
    return new ArrayList<>();
  }

}
