package com.bron.demoJPA.service;

import java.util.List;

import com.bron.demoJPA.appuser.Dish;

public interface DishService {
	
	List<Dish> getAllDish();
	void saveDish(Dish dish);
	
	Dish getDishByDishId(long dishId);
	
	}
	

