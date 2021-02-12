package fr.manulep.fruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/potager")

public class FruitController {

    @Autowired
    FruitService service;
    @GetMapping("/fruit/{id}")
    public ResponseEntity<Fruit> findById(@PathVariable(value = "id") long id){
        Optional<Fruit> fruitList;
        try {
            fruitList = service.findById(id);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
        return fruitList.map(fruit -> ResponseEntity.ok().body(fruit)).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
