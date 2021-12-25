package com.bron.demoJPA.appuser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface UserRespository extends JpaRepository<AppUser, Long> {
	
	Optional<AppUser> findByEmail(String email);
	    @Transactional
	    @Modifying
		@Query(
				value = "update rest_info set enabled = 1 where rest_Email_Address= ?1",
				nativeQuery = true
				)
		  int enableAppUser(String email);
		AppUser findByRestaurantName(String string);
	}

