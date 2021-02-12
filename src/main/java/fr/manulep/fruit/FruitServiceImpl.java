package fr.manulep.fruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{

    @Autowired
    FruitRepository repository;

    @Override
    public Optional<Fruit> findById(Long id) {
        return repository.findById(id);
    }
}
