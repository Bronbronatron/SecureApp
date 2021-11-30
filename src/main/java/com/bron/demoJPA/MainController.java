
package com.bron.demoJPA;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



import lombok.NoArgsConstructor;

@Controller
@NoArgsConstructor
public class MainController {

	// public Map<String, AppUser> user = new HashMap<>();

	@GetMapping("/home")
	public String showRestaurantHomePage() {
		return "restaurantHome";

	}
	
	@GetMapping("/userDetails")
	public String showUserDetailsHome() {
		return "user_details";

	}
	
	@GetMapping("/admin")
	public String admin() {	
			return("Welcom Admin");
		
	}
	


}