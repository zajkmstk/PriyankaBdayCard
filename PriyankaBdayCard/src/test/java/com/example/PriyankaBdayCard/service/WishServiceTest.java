package com.example.PriyankaBdayCard.service;

import com.example.PriyankaBdayCard.entities.Wish;
import com.example.PriyankaBdayCard.repository.WishRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WishServiceTest {

    @Mock
    private WishRepository wishRepository;

    @InjectMocks
    private WishService wishService;

    @Test
    @DisplayName("Should return Wish if saved to repository successfully")
    void saveWish() {
        Wish mockWish = new Wish();
        when(wishRepository.save(mockWish))
                .thenReturn(mockWish);

        Wish result = wishService.saveWish(mockWish);

        assertEquals(result, mockWish);
        assertNotEquals(result, new Wish());
    }

    @Test
    @DisplayName("Should return list of wishes if any are found in repository")
    void findAll() {
        List<Wish> mockWishes = List.of(new Wish(), new Wish());
        when(wishRepository.findAll())
                .thenReturn(mockWishes);

        List<Wish> result = wishService.findAll();

        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Should convert each JSON wish file into Wish objects and return them as a list")
    void jsonToWishes() throws IOException {
        List<Wish> wishes = wishService.jsonToWishes();
        assertEquals(13, wishes.size());
    }
}