package com.example.PriyankaBdayCard.repository;

import com.example.PriyankaBdayCard.entities.Wish;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WishRepository extends JpaRepository <Wish, Integer> {
}
