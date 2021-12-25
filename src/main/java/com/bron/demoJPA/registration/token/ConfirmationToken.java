package com.bron.demoJPA.registration.token;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Cascade;

import com.bron.demoJPA.appuser.AppUser;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity

public class ConfirmationToken {
		public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, AppUser appUser) {
		this.token = token;
		this.createdAt = createdAt;
		this.expiresAt = expiresAt;
		this.appUser = appUser;
	}
		
		//Define primary key 
		@Id
		//Auto generate primary key
		@SequenceGenerator(name = "token_sequence", sequenceName = "token_sequence", allocationSize = 1)
		@GeneratedValue(
				strategy = GenerationType.SEQUENCE,
				generator = "token_sequence"
					)
		private Long id;
		
		@Column(nullable = false)
		private String token;
		
		//allows us to see if more than 15 mins has passed
		@Column(nullable = false)
		private LocalDateTime createdAt;
		@Column(nullable = false)
		private  LocalDateTime expiresAt;
	
		
		private LocalDateTime comfirmedAt; 
		
		//Tie to User
		//An application user can have many confirmation tokens

		@ManyToOne(cascade = CascadeType.REMOVE)
		@JoinColumn(
		nullable = true,
		name = "rest_id"
		)
		private AppUser appUser;
		
}
