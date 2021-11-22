package com.bron.demoJPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bron.demoJPA.appuser.Dish;
import com.bron.demoJPA.repository.DishRepository;


@Service
public class DishServiceImpl implements DishService {
	
	@Autowired
	private DishRepository dishRepository;
	
	@Override
	public List<Dish> getAllDish() {
	return dishRepository.findAll();	
	}

	@Override
	public void saveDish(Dish dish) {
		this.dishRepository.save(dish);
	}

	@Override
	public Dish getDishByDishId(long dishId) {
		Optional<Dish> optional = dishRepository.findById(dishId); 
		Dish dish = null;
		if(optional.isPresent()) {
			dish = optional.get();
		}else {
			throw new RuntimeException("Dish not found for: " + dishId); 
		}
		return dish;
		}
	}
	



