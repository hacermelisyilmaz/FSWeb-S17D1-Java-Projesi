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
}
