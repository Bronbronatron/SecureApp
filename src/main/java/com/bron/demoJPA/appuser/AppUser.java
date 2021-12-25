package com.bron.demoJPA.appuser;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bron.demoJPA.registration.token.ConfirmationToken;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@Builder
@ToString(exclude = "opening")
@Table(name = "Rest_info")

public class AppUser implements UserDetails {
	@Id
	// Auto generate primary key
	@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	@Column(name = "Rest_ID")
	private long id;

	@Column(name = "Rest_Name")
	private String restaurantName;

	@Embedded
	private Address address;

	@Column(name = "Rest_Phone_Number")
	private String phoneNumber;

	@Column(name = "Rest_Password")
	private String password;

	@Column(name = "Rest_Email_Address")
	private String email;

	@Enumerated(EnumType.STRING)
	private AppUserRole appUserRole;
	private Boolean locked = false;
	// don't enable user until email verification
	private Boolean enabled = false;

	public AppUser(String restname, String email, String pass, AppUserRole app) {
		this.restaurantName = restname;
		this.email = email;
		this.password = pass;
		this.appUserRole = app;
	}

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
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	// need reference to restaurant info but one to one relationship
	// already defined by openingHour object in opening hour table

	@OneToOne(
			 cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, optional = true,
			mappedBy = "appUser")

	private OpeningHour opening;
}
