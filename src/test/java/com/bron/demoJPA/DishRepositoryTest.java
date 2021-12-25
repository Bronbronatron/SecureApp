package com.bron.demoJPA;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bron.demoJPA.appuser.AppUser;
import com.bron.demoJPA.appuser.Dish;
import com.bron.demoJPA.repository.DishRepository;



//Only have to test methods user created i.e. not methods that come with repository
@DataJpaTest
public class DishRepositoryTest {
	
	
	@AfterEach
	void tearDown() {
	underTest.deleteAll();
	}
	
	
	@Autowired
	private DishRepository underTest;


	

	@Test
	public void saveDishById(){
		AppUser u = AppUser.builder()
				.id(1)
				.restaurantName("OldeCastle")
				.email("Castle@ggmail.com")
				.password("666")
				.build();
		
		Dish d = Dish.builder()	
		.dname("Bacon and Cabbage")
		.price(10.50)
		.description("Traditional")
		.eggFree(false)
		.glutenFree(true)
		.vegan(false)
		.app(u)
		.build();
		
		underTest.getDishByRestaurantID(u.getId());
	}
	

}


