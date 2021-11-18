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
				value = "update app_user set enabled = 1 where email = ?1",
				nativeQuery = true
				)
		  int enableAppUser(String email);
	}

