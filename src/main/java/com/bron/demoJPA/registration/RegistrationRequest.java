package com.bron.demoJPA.registration;

import javax.persistence.Column;


import com.bron.demoJPA.appuser.AppUserRole;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@NoArgsConstructor
@Setter

public class RegistrationRequest {
	private  String restaurantName;
	private  String email;
	private  String password;
	private  AppUserRole role;
	private  String phoneNumber;
	private String addressOne;
	private String addressTwo;
	private String city;
	private String postcode;

	public RegistrationRequest(String restaurantName, String email, String password, AppUserRole role, String phonenumber, 
			String addressOne, String addressTwo, String city, String postcode) {
		super();
		this.restaurantName = restaurantName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.phoneNumber = phonenumber;
		this.addressOne = addressOne;
		this.addressTwo = addressTwo;
		this.city = city;
		this.postcode = postcode;

	}
	
	
}
