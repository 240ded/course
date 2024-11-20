package com.example.course.controller;

import com.example.course.entity.Cat;
import com.example.course.repository.CatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MainControllerTest {

    @Mock
    private CatRepository catRepository;

    @InjectMocks
    private MainController mainController;

    @Test
    void changeCatFailedTest() {
        int id = 1;
        Cat cat = new Cat();
        cat.setId(id);

        when(catRepository.existsById(id)).thenReturn(false);

        String expected = "No such row";

        assertEquals(expected, mainController.changeCat(cat));
    }

    @Test
    void changeCatSuccessTest() {
        int id = 1;

        Cat cat = new Cat();
        cat.setId(1);
        cat.setName("Barsik");

        when(catRepository.existsById(id)).thenReturn(true);
        when(catRepository.save(cat)).thenReturn(cat);

        assertEquals(cat.toString(), mainController.changeCat(cat));
    }
}