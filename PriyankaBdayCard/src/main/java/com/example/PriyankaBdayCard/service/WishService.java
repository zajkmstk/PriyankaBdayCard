package com.example.PriyankaBdayCard.service;

import com.example.PriyankaBdayCard.entities.Wish;
import com.example.PriyankaBdayCard.repository.WishRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishService {

private WishRepository wishRepository;

    public WishService (@Autowired WishRepository wishRepository) throws IOException {
        this.wishRepository = wishRepository;
    }

    public Wish saveWish (Wish wish) {
        Wish newWish = wishRepository.save(wish);
        return newWish;
    }

    public List<Wish> findAll(){
        return this.wishRepository.findAll();
    }


    public List<Wish> jsonToWishes() throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:/static/*.json");
        List<Wish> listOfWishes = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for(Resource resource : resources){
            System.out.println(resource);
            Wish tempWish = objectMapper.readValue(resource.getInputStream(), Wish.class);
            listOfWishes.add(tempWish);
        }
        return listOfWishes;
    }

}
