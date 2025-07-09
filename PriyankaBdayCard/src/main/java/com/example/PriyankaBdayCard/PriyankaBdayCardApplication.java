package com.example.PriyankaBdayCard;

import com.example.PriyankaBdayCard.entities.Wish;
import com.example.PriyankaBdayCard.service.WishService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class PriyankaBdayCardApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PriyankaBdayCardApplication.class, args);
		WishService service = (WishService) context.getBean("wishService");


		try {
			List<Wish> listOfWishes = service.jsonToWishes();
			for(Wish wish: listOfWishes){
				service.saveWish(wish);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
