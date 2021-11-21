package com.bron.demoJPA.registration;

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


	public RegistrationRequest(String restaurantName, String email, String password) {
		super();
		this.restaurantName = restaurantName;
		this.email = email;
		this.password = password;
	}
	
	
}
