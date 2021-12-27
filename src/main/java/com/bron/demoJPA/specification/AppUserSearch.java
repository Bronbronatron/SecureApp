package com.bron.demoJPA.specification;

import java.util.Collection;
import java.util.Collections;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.bron.demoJPA.appuser.AppUserRole;
import com.bron.demoJPA.appuser.OpeningHour;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppUserSearch {
	
	
	private long id;
	
	private String restaurantName;

	private String phoneNumber;

	private String password;

	private String email;
	
	private String addressOne;
	
	private String addressTwo;
	
	private String city;
	
	private String postcode;


	private AppUserRole appUserRole;
	private Boolean locked = false;

	private Boolean enabled = false;


	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
		return Collections.singletonList(authority);
	}

	private OpeningHour opening;
}

