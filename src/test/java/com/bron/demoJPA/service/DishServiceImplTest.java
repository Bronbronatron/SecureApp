package com.bron.demoJPA.service;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

import com.bron.demoJPA.appuser.AppUser;
import com.bron.demoJPA.appuser.Dish;
import com.bron.demoJPA.repository.DishRepository;

@SuppressWarnings("unused")
@ExtendWith(MockitoExtension.class)
class DishServiceImplTest {
	//dish repository already tested so we can mock using Mockito- Speeds up unit test
	@Mock
	private DishRepository dishRepository;
	private DishServiceImpl underTest;
	
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		//if we have more that one mock initialise all mocks in this test class
		// initialise mock 
		
		 underTest = new DishServiceImpl(dishRepository);
	}



	@Test
	void testGetAllDish() {
	//when
		underTest.getAllDish();
		//then
		//verify that dish repository was invoked using method 'find all' 
		verify(dishRepository).findAll();
	}
	
	
	@Test
	void testSaveDish() {
		
		//given
		Dish d = Dish.builder()	
		.dname("Bacon and Cabbage")
		.price(10.50)
		.description("Traditional")
		.eggFree(false)
		.glutenFree(true)
		.vegan(false)
		.build();
		
		//when
		underTest.saveDish(d);
		
		//then
		ArgumentCaptor<Dish> dishArgumentCaptor = 
		ArgumentCaptor.forClass(Dish.class);
		//capture actual dish that was passed inside save method
		verify(dishRepository).save(dishArgumentCaptor.capture());
		Dish captoredDish = dishArgumentCaptor.getValue();
		Assert.assertEquals(captoredDish, d);
	}
	
	@Disabled
	@Test
	void testGetDishByDishId() {
		Dish d = Dish.builder()	
		.dishId((long) 1)
		.dname("Bacon and Cabbage")
		.price(10.50)
		.description("Traditional")
		.eggFree(false)
		.glutenFree(true)
		.vegan(false)
		.build();
	     underTest.saveDish(d);
		
		//when
		underTest.getDishByDishId((long) 1);
		//then
		verify(dishRepository).findById((long) 1);
	
		
			}
		

	
	
	@Test
	void testSaveDishWithUserId() {
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
				.build();
				
				//when
				underTest.saveDish(d);
				
				//then
				ArgumentCaptor<Dish> dishArgumentCaptor = 
				ArgumentCaptor.forClass(Dish.class);
				//capture actual dish that was passed inside save method
				verify(dishRepository).save(dishArgumentCaptor.capture());
				Dish captoredDish = dishArgumentCaptor.getValue();
				Assert.assertEquals(captoredDish, d);
		
		
	}


	@Test
	void testDeleteDishById() {
				
		Dish d = Dish.builder()	
		.dishId(1L)
		.dname("Bacon and Cabbage")
		.price(10.50)
		.description("Traditional")
		.eggFree(false)
		.glutenFree(true)
		.vegan(false)
		.build();
	    	underTest.saveDish(d);
		
		//when
		underTest.deleteDishById(1L);
		//then
		verify(dishRepository).deleteById(1L);
	
	}
	

}
