package com.bron.demoJPA.registration;


import java.util.Optional;

import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bron.demoJPA.appuser.AppUser;
import com.bron.demoJPA.appuser.OpeningHour;
import com.bron.demoJPA.registration.token.ConfirmationToken;
import com.bron.demoJPA.registration.token.ConfirmationTokenService;

import lombok.AllArgsConstructor;


//@RequestMapping(path = "/api/v1/registration")
//@RestController

@Controller
@AllArgsConstructor

public class 
RegistrationController {

	private final RegistrationService registrationService;
	//private final ConfirmationTokenService confirmationTokenService;

  
    @GetMapping("/api/v1/registration/new")
	public String ShowRegisterationForm (Model model) {
		RegistrationRequest request = new RegistrationRequest();
		model.addAttribute("request", request);
		return "registration";
	}
	
	
	@PostMapping("/api/v1/registration")
	public String registration(@ModelAttribute("request")RegistrationRequest request) {
			registrationService.register(request);	
			return "redirect:/dish";
			}

  //@RequestMapping(path = "/api/v1/registration")
  @GetMapping(path="/api/v1/registration/confirm")
  public String confirm(@RequestParam("token") String token) {
  return registrationService.confirmToken(token);
  
 }
 
	
	
  
    	
	//HTTP Body Data is the data bytes transmitted in an HTTP transaction 
	//Most HTTP requests with bodies use POST or PUT request method.
	
//	@ModelAttribute ("appUser")  	
//	public RegistrationRequest registrationRequest(AppUser appUser){
//	return new RegistrationRequest(appUser.setRestaurantName(), appUser.setEmail(), appUser.setPassword()); 
//	}
		
/*
	@PostMapping
	public String register(RegistrationRequest request) {
	 registrationService.register(request);
		return "redirect:/restaurantHome";
	}

	
	@ModelAttribute ("appUser")  	
	public RegistrationRequest registrationRequest(){
	return new RegistrationRequest(); 
	}
	
	@PostMapping
	public String register(@ModelAttribute("appUser") RegistrationRequest request) {
	registrationService.register(request);
	return "redirect:/restaurantHome";
	}
	 
	
	@GetMapping(path ="confirm")
	public String confirm(@RequestParam("token") String token) {
		return registrationService.confirmToken(token);
	}
	
s
	*/

}
