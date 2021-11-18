package com.bron.demoJPA.appuser;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity

public class AppUser implements UserDetails { 
	
	
	//Define primary key
	@Id
	//Auto generate primary key
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_sequence"
				)
	
	private long id;
	private String restaurantName;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private AppUserRole appUserRole;
	private  Boolean locked = false;
	//don't enable user until email verification
	private Boolean enabled = false;

	/*
	private String addressOne;
	private String addressTwo;
	private String Town;
	private String City;
	private String Postcode;
	private String PhoneNumber;
	*/

	
	
	
	public AppUser(
			
			String restname,
			String email, 
			String pass,
			AppUserRole app) {

	//	String ad1, String ad2, String town, String city, 
	//	String postcode, String num, AppUserRole appUserRole
		
		this.restaurantName = restname;
		this.email = email;
		this.password = pass;
		this.appUserRole = app;
		/*
		this.addressOne = ad1;
		this.addressTwo = ad2;
		this.Town = town;
		this.City = city;
		this.Postcode = postcode;
		this.PhoneNumber = num;
		*/
	}
	


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
		return Collections.singletonList(authority);
	}

	@Override
	public String getUsername() {
		return email;
	}
	
	@Override
	public String getPassword() { 
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
