package com.bron.demoJPA.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bron.demoJPA.appuser.AppUser;
import com.bron.demoJPA.appuser.Dish;

public interface DishService {

	List<Dish> getAllDish();

	
	
	//@Query(value = "SELECT * from dish r where r.rest_id= ?1", nativeQuery = true)
	
	
	//List<Dish> getDishBy
	void saveDish(Dish dish);

	Dish getDishByDishId(long dishId);

	void saveDishById(Dish dish);
	
	public void saveDishWithUserId(Dish dish);

	public void deleteDishById(long Id);
	

	
	
}
