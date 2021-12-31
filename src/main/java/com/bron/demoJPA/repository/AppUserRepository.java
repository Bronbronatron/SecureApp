package com.bron.demoJPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bron.demoJPA.appuser.AppUser;



@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>{
	
	  @Transactional
	  @Modifying
	  @Query(
				value = "select * from rest_info r where rest_id= ?1", nativeQuery = true
				)
	List<AppUser> getAppUserById(Long id);

	  
	  
}





