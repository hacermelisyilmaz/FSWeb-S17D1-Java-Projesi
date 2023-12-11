package com.workintech.spring.animals.controllers;

import com.workintech.spring.animals.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping
    public List<Animal> getAnimals() {
        return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable int id) {
        if (animals.containsKey(id)) return animals.get(id);
        else System.out.println("An animal with this ID does not exist: " + id);
        return null;
    }

    @PostMapping
    public Animal addAnimal(@RequestBody int id, @RequestBody String name) {
        Animal animal = new Animal(id, name);
        if (animals.containsKey(id)) System.out.println("An animal with this ID already exists: " + id);
        else animals.put(id, animal);
        return animal;
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal) {
        if (animals.containsKey(id)) animals.put(animal.getId(), animal);
        return animal;
    }

    @DeleteMapping("/{id}")
    public Animal removeAnimal(@PathVariable int id) {
        if (!animals.containsKey(id)) System.out.println("An animal with this ID does not exist. Deletion not necessary.");
        return animals.remove(id);
    }
}
