package com.bron.demoJPA.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bron.demoJPA.appuser.Dish;
import com.bron.demoJPA.appuser.OpeningHour;
import com.bron.demoJPA.repository.OpeningHourRepository;
import com.bron.demoJPA.service.OpeningHourService;


@Controller
public class OpeningHourController {
	
	@Autowired
	private OpeningHourService openingHourService;
	
	
	@GetMapping("/openinghour")
	public String showOpeningHourForm (Model model) {
		OpeningHour openinghour = new OpeningHour();
		model.addAttribute("openinghour", openinghour);
		return "opening_hours";
	}
	
	
	
	@PostMapping("/saveOpeningHour")
	public String saveOpeningHour(@ModelAttribute("openinghour")OpeningHour openinghour) {
			openingHourService.saveOpeningHourWithUserId(openinghour);	
			return "redirect:/dish";
			}
		

}
