package com.bron.demoJPA.conroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bron.demoJPA.appuser.AppUser;
import com.bron.demoJPA.appuser.Dish;
import com.bron.demoJPA.repository.DishRepository;
import com.bron.demoJPA.service.DishService;

@Controller
public class DishController {
//display list of employees
	
	@Autowired
	private DishService dishService;
	
	@Autowired
	private DishRepository dishRepo;

	/*
	@GetMapping("/dish")
	public String viewHomePage(Model model) {
		model.addAttribute("listDish", dishService.getAllDish());
		return "index";
	}
*/
	
	@GetMapping("/dish")
	public String viewNewHomePage(Model model) {
		AppUser user = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Long id = user.getId();
		model.addAttribute("listDish", dishRepo.getDishByRestaurantID(id));
		return "index";
	}
	
	
	@GetMapping("/showNewDishForm")
	public String showNewDishForm(Model model) {
		// Create model attribute to bind form data
		Dish dish = new Dish();
		model.addAttribute("dish", dish);
		return "new_dish";
	}

	@PostMapping("/saveDish")
	public String saveUser(@ModelAttribute("dish")Dish dish) {
			dishService.saveDishWithUserId(dish);	
			return "redirect:/dish";
			}
		
	
	
/*
	@PostMapping("/saveDish")
	public String saveDishById(@ModelAttribute("dish") Dish dish) {
		// save dish to database
		dishService.saveDish(dish);
		return "redirect:/dish";
	}
*/
	
	@GetMapping("/showFormForUpdate/{dishId}")
	public String showFormForUpdate(@PathVariable(value = "dishId") long dishId, Model model) {
		// get dish from service
		Dish dish = dishService.getDishByDishId(dishId);
		// set dish as model to pre-populate the form data
		model.addAttribute("dish", dish);
		return "update_dish";

	}
	
	
	@GetMapping("/deleteDish/{dishId}")
	public String deleteDish(@PathVariable(value = "dishId") long dishId, Model model) {
		this.dishService.deleteDishById(dishId);
		return "redirect:/dish";
		
	}

}
