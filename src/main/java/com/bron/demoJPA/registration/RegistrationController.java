package com.bron.demoJPA.registration;


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

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/registration")

@AllArgsConstructor

public class RegistrationController {

	private final RegistrationService registrationService;


    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
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
	

	*/

}
