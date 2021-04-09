package org.rest.services.impl;

import org.modelmapper.ModelMapper;
import org.rest.repository.FruitRepository;
import org.rest.repository.entity.Fruit;
import org.rest.services.FruitService;
import org.rest.services.model.FruitDto;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Transactional
public class FruitServiceImpl implements FruitService {

    @Inject
    FruitRepository fruitRepository;

    @Override
    public List<FruitDto> getFruits() {
       List<Fruit> fruits = fruitRepository.findAll();

        ModelMapper modelMapper = new ModelMapper();
        List<FruitDto> fruitDtos = new ArrayList<>();
        for(Fruit fruit: fruits){
            fruitDtos.add(modelMapper.map(fruit, FruitDto.class));
        }
        return fruitDtos;
    }

    @Override
    public FruitDto addFruit(FruitDto fruitDto) {
        ModelMapper modelMapper = new ModelMapper();
        Fruit fruit = modelMapper.map(fruitDto, Fruit.class);
        fruit = fruitRepository.add(fruit);
        return modelMapper.map(fruit, FruitDto.class);
    }

    @Override
    public String removeFruit(Integer id) {

        fruitRepository.fruitDelete(id);
        return "Fruit deleted";
    }
}
