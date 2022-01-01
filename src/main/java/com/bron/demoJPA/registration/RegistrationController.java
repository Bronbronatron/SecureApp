package com.bron.demoJPA.registration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor

public class RegistrationController {

	private final RegistrationService registrationService;

	@GetMapping("/api/v1/registration/new")
	public String ShowRegisterationForm(Model model) {
		RegistrationRequest request = new RegistrationRequest();
		model.addAttribute("request", request);
		return "Registration_registration";
	}

	@PostMapping("/api/v1/registration")
	public String registration(@ModelAttribute("request") RegistrationRequest request) {
		registrationService.register(request);
		return "redirect:/homepage";
	}

	@GetMapping(path = "/api/v1/registration/confirm")
	public String confirm(@RequestParam("token") String token) {
		return registrationService.confirmToken(token);

	}

}
