package com.example.PriyankaBdayCard;

import com.example.PriyankaBdayCard.entities.Wish;
import com.example.PriyankaBdayCard.service.WishService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication
public class PriyankaBdayCardApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PriyankaBdayCardApplication.class, args);
		WishService service = (WishService) context.getBean("wishService");
		Wish newWish = new Wish();
		Wish newWish2 = new Wish();
		newWish.setName("Zajk");
		newWish.setMessage("Have a best day!");
		newWish2.setName("Josh");
		newWish2.setMessage("Happy Birthday!!!!");

		service.saveWish(newWish);
		service.saveWish(newWish2);

	}

}
