package com.bron.demoJPA.registration;

import com.bron.demoJPA.appuser.AppUserRole;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@NoArgsConstructor


public class RegistrationRequest {
	private  String restaurantName;
	private  String email;
	private  String password;
	private  AppUserRole role;

	public RegistrationRequest(String restaurantName, String email, String password, AppUserRole role) {
		super();
		this.restaurantName = restaurantName;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	
}
