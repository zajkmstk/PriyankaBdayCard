package com.example.PriyankaBdayCard;

import com.example.PriyankaBdayCard.entities.Wish;
import com.example.PriyankaBdayCard.helper.ListFiles;
import com.example.PriyankaBdayCard.service.WishService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class PriyankaBdayCardApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PriyankaBdayCardApplication.class, args);
		WishService service = (WishService) context.getBean("wishService");
//		Wish newWish = new Wish();
//		Wish newWish2 = new Wish();
//		newWish.setName("Zajk");
//		newWish.setMessage("Have a best day!");
//		newWish2.setName("Josh");
//		newWish2.setMessage("Happy Birthday!!!!");
//
//		service.saveWish(newWish);
//		service.saveWish(newWish2);
//		ListFiles.listFiles();

//
//		try {
//			Wish newWish3 = service.jsonToWish();
//			service.saveWish(newWish3);
//			System.out.println("json added");
//
//		} catch (IOException e) {
//			System.out.println("exception");
//		}

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
