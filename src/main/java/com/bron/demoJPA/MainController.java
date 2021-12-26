
package com.bron.demoJPA;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



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
	public String showMainHomePage() {
		return "user_home_page";

	}
	
	
	@GetMapping("/userDetails")
	public String showUserDetailsHome() {
		return "user_details";

	}
	
	@GetMapping("/admin/home")
	public String admin() {
			return "Admin_home";
		
	}
	

	
}