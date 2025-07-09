package com.example.PriyankaBdayCard.service;

import com.example.PriyankaBdayCard.entities.Wish;
import com.example.PriyankaBdayCard.repository.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishService {

private WishRepository wishRepository;

    public WishService (@Autowired WishRepository wishRepository) {
        this.wishRepository = wishRepository;
    }

    public Wish saveWish (Wish wish) {
        Wish newWish = wishRepository.save(wish);
        return newWish;
    }
}
