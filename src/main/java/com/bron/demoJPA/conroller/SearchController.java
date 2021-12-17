/*
package com.bron.demoJPA.conroller;

import java.util.List;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bron.demoJPA.appuser.Dish;
import com.bron.demoJPA.repository.DishRepository;
import com.bron.demoJPA.specification.DishSearch;
import com.bron.demoJPA.specification.DishSpecification;



@Controller
public class SearchController {
	
	DishRepository drep;
	
	@RequestMapping("/search")  
	public String search(@ModelAttribute DishSearch search, Model model) {  
	Specification<Dish> spec = new DishSpecification(search);
	    List<Dish> dishes  = drep.findAll(spec);
	    model.addAttribute(dishes);
	    return "searchList";
	}
}
*/