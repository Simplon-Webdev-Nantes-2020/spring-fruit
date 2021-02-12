package fr.manulep.fruit;

import java.util.Optional;

public interface FruitService {
    Optional<Fruit> findById(Long id);
}
