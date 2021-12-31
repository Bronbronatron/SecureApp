package com.bron.demoJPA.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.bron.demoJPA.appuser.AppUser;
import com.bron.demoJPA.appuser.Dish;
import com.bron.demoJPA.appuser.OpeningHour;
import com.bron.demoJPA.repository.DishRepository;

@Service
public class DishServiceImpl implements DishService {

	@Autowired
	private DishRepository dishRepository;

	public DishServiceImpl(DishRepository dishRepository2) {
		this.dishRepository =  dishRepository2;
	}

	@Override
	public List<Dish> getAllDish() {
		return dishRepository.findAll();
	}

	@Override
	public Dish getDishByDishId(long dishId) {
		Optional<Dish> optional = dishRepository.findById(dishId);
		Dish dish = null;
		if (optional.isPresent()) {
			dish = optional.get();
		} else {
			throw new RuntimeException("Dish not found for: " + dishId);
		}
		return dish;
	}


	@Override
	public void saveDishWithUserId(Dish dish) {
	 	Object principal = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		AppUser app = dish.getApp();
		app = (AppUser) principal;
		dish.setApp(app);
		this.dishRepository.save(dish);
	}

	@Override
	public void deleteDishById(long Id) {
		this.dishRepository.deleteById(Id);
	}

	
	@Override
	public void saveDish(Dish dish) {
		this.dishRepository.save(dish);
	}

//	@Override
//	public void saveDishById(Dish dish) {
//		this.dishRepository.save(dish);
		
	//}

}
