
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

	//Main home page
	@GetMapping("/homepage")
	public String showRestaurantHomePage() {
		return "Main_home";
	}
	//Logout Success
	@GetMapping("/homepage/logoutsuccess")
	public String ShowLogout() {
		return "Main_Logout_successful";
	}
	//User home page
	@GetMapping("/user/home")
	public String showMainHomePage(Model model) {
		AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("appUser", appUser);
		return "user_home_page";

	}
	//Admin home page
	@GetMapping("/admin/home")
	public String admin(Model model) {
		AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("appUser", appUser);
		return "Admin_home";

	}

}