
package com.bron.demoJPA.conroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bron.demoJPA.appuser.AppUser;
import com.bron.demoJPA.appuser.Dish;
import com.bron.demoJPA.repository.DishRepository;
import com.bron.demoJPA.specification.DishSearch;
import com.bron.demoJPA.specification.DishSpecification;



@Controller
public class SearchController {
	
	@Autowired
	DishRepository drep;
	
	
	@GetMapping("/homepage/showsearchform")
	public String showNewDishForm(Model model) {
		// Create model attribute to bind form data
		DishSearch dishsearch = new DishSearch();
		model.addAttribute("dishsearch", dishsearch);
		return "Search_search_Dish";
	}
	
	@PostMapping("/homepage/showresult")
	public String saveUser(@ModelAttribute("dishsearch") DishSearch dishsearch, Model model) {
	    Specification<Dish> spec = new DishSpecification(dishsearch);
	    model.addAttribute("listdishsearch", drep.findAll(spec));
	    return "Search_show_dish_List";
	}




}
