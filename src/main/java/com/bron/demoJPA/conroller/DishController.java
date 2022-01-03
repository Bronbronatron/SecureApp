package com.bron.demoJPA.conroller;

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
import com.bron.demoJPA.specification.DishSearch;

@Controller
public class DishController {


	@Autowired
	private DishService dishService;

	@Autowired
	private DishRepository dishRepo;

	@PostMapping("/user/saveDish")
	public String saveUser(@ModelAttribute("dish") Dish dish) {
		dishService.saveDishWithUserId(dish);
		return "redirect:/user/dish/view";
	}

	@GetMapping("/user/dish/add")
	public String showNewDishForm(Model model) {
		// Create model attribute to bind form data
		Dish dish = new Dish();
		model.addAttribute("dish", dish);
		return "user_dish_save";
	}

	@PostMapping("/admin/saveDish")
	public String adminSaveDish(@ModelAttribute("dish") Dish dish) {
		dishService.saveDishWithUserId(dish);
		return "redirect:/admin/dish/view";
	}

	@GetMapping("/user/dish/view")
	public String viewHomePage(Model model) {
		AppUser user = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Long id = user.getId();
		model.addAttribute("listDish", dishRepo.getDishByRestaurantID(id));
		return "user_dish_index";
	}

	@GetMapping("/admin/dish/view")
	public String viewAllDish(Model model) {
		model.addAttribute("listDish", dishRepo.findAll());
		return "Admin_Dish_Index";
	}

	@GetMapping("/showFormForUpdate/{dishId}")
	public String showFormForUpdate(@PathVariable(value = "dishId") long dishId, Model model) {
		// get dish from service
		Dish dish = dishService.getDishByDishId(dishId);
		// set dish as model to pre-populate the form data
		model.addAttribute("dish", dish);
		return "user_dish_save";
	}

	@GetMapping("/adminShowFormForUpdate/{dishId}")
	public String adminShowFormForUpdate(@PathVariable(value = "dishId") long dishId, Model model) {
		// get dish from service
		Dish dish = dishService.getDishByDishId(dishId);
		// set dish as model to pre-populate the form data
		model.addAttribute("dish", dish);
		return "Admin_dish_save";
	}

	@GetMapping("/deleteDish/{dishId}")
	public String deleteDish(@PathVariable(value = "dishId") long dishId, Model model) {
		this.dishService.deleteDishById(dishId);
		return "redirect:/user/dish/view";

	}

	@GetMapping("/admin/deleteDish/{dishId}")
	public String adminDeleteDish(@PathVariable(value = "dishId") long dishId, Model model) {
		this.dishService.deleteDishById(dishId);
		return "redirect:/admin/dish/view";

	}

}
