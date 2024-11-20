package com.example.course.controller;

import com.example.course.dto.CatDTO;
import com.example.course.entity.Cat;
import com.example.course.repository.CatRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "main_methods")
@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {
    private final CatRepository catRepository;

    @Operation(
            summary = "кладет нового котика в базу",
            description = "Получает DTO кота и билдером собирает и сохраняет сущность в базу"
    )
    @PostMapping("/api/add")
    public void addCat(@RequestBody CatDTO catDTO) {
        log.info(
                "New row: " + catRepository.save(
                        Cat.builder()
                        .name(catDTO.getName())
                        .age(catDTO.getAge())
                        .weight(catDTO.getWeight())
                        .build())
        );
    }

    @SneakyThrows
    @GetMapping("/api/all")
    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    @GetMapping("/api/{id}")
    public Cat getCatById(@PathVariable Integer id) {
        return catRepository.findById(id).orElseThrow(null);
    }

    @DeleteMapping("/api/{id}")
    public void deleteCatById(@PathVariable Integer id) {
        catRepository.deleteById(id);
    }

    @PutMapping("/api/{id}")
    public void updateCat(@RequestBody Cat cat) {
        catRepository.save(cat);
    }
}
