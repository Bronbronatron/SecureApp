
package com.bron.demoJPA;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bron.demoJPA.appuser.AppUser;
import com.bron.demoJPA.registration.RegistrationRequest;

import lombok.NoArgsConstructor;

@Controller
@NoArgsConstructor
public class MainController {

	// public Map<String, AppUser> user = new HashMap<>();

	@GetMapping("/")
	public String showRestaurantHomePage() {
		return "restaurantHome";

	}
	

	


	@GetMapping(path="/api/v1/registration/new")
	 public String showRegistrationForm(Model model){
		//make model to bind form data
		//Thymeleaf template will access to bind form data
	//	AppUser appUser = new AppUser();
		RegistrationRequest  request = new RegistrationRequest();
		model.addAttribute("registrationRequest",  request);
		 return "registration";
	 }
	
	/*
	 * 
	 */
	

}
