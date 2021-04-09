package org.rest.services;

import org.rest.repository.entity.Fruit;
import org.rest.services.model.FruitDto;

import java.util.List;

public interface FruitService {
    List<FruitDto> getFruits();
    FruitDto addFruit(FruitDto fruitDto);
    String removeFruit(Integer id);

}
