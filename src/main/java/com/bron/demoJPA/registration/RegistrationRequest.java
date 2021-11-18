package com.bron.demoJPA.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter

public class RegistrationRequest {
	private final String restaurantName;
	private final String email;
	private final String password;

	
	/*
	private final String addressOne;
	private final String addressTwo;
	private final String Town;
	private final String City;
	private final String Postcode;
	private final String PhoneNumber;
	*/
}
