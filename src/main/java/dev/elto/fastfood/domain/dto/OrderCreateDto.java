package dev.elto.fastfood.domain.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCreateDto {

  List<Integer> items;

}
