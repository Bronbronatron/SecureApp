
package com.bron.demoJPA;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bron.demoJPA.appuser.AppUser;

import lombok.NoArgsConstructor;

@Controller
@NoArgsConstructor
public class MainController {

	@GetMapping("/homepage")
	public String showRestaurantHomePage() {
		return "Main_home";

	}
	
	@GetMapping("/homepage/logoutsuccess")
	public String ShowLogout() {
		return "Main_Logout_successful";
	}
	
	@GetMapping("/user/home")
	public String showMainHomePage(Model model) {
		AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("appUser", appUser);
		return "user_home_page";

	}
	
	
	@GetMapping("/userDetails")
	public String showUserDetailsHome() {
		return "user_details";

	}
	
	@GetMapping("/admin/home")
	public String admin(Model model) {
		AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("appUser", appUser);
			return "Admin_home";
		
	}
	

	
}