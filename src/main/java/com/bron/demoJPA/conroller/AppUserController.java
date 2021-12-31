package com.bron.demoJPA.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bron.demoJPA.appuser.AppUser;
import com.bron.demoJPA.appuser.Dish;
import com.bron.demoJPA.registration.RegistrationRequest;
import com.bron.demoJPA.registration.token.ConfirmationTokenRepository;
import com.bron.demoJPA.repository.AppUserRepository;
import com.bron.demoJPA.repository.DishRepository;
import com.bron.demoJPA.service.AppUserService;

@Controller
public class AppUserController {
	
	@Autowired
	private AppUserService userService;
	@Autowired
	private AppUserRepository userRepo;
	@Autowired
	private ConfirmationTokenRepository tokenRepo;
	@Autowired
	private DishRepository dishRepo;

	@GetMapping("/admin/appuser/view")
	public String viewNewHomePage(Model model) {
		model.addAttribute("listAppUser", userRepo.findAll());
		return "Admin_User_Index";
	}
	
	@GetMapping("/showAppUserForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		// get dish from service
	   AppUser appUser =  userService.getAppUserById(id);
		// set dish as model to pre-populate the form data
		model.addAttribute("appUser", appUser);
		return "Admin_User_Update";
	}
	
	@GetMapping("/deleteAppUser/{id}")
	public String deleteDish(@PathVariable(value = "id") long id, Model model) {
		dishRepo.deleteDishByRestaurantID(id);
		tokenRepo.deleteTokenByRestaurantID(id);
		userService.deleteAppUserById(id);
		return "redirect:/admin/appuser/view";
		
	}
	
	
	
	@GetMapping("/homepage/showAppUser/{id}")
	public String showForm(@PathVariable(value = "id") long id, Model model) {
		// get dish from service
	   AppUser appUser =  userService.getAppUserById(id);
		// set dish as model to pre-populate the form data
		model.addAttribute("appUser", appUser);
		return "Main_Rest_Details";
	}

	@PostMapping("/admin/saveDetails")
	public String adminSaveDish(@ModelAttribute("appUser")AppUser appUser) {
			userRepo.save(appUser);
			return "redirect:/admin/appuser/view";
			}
	
	
}
	


