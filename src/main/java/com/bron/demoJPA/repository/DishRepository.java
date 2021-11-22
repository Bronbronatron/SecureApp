package com.bron.demoJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bron.demoJPA.appuser.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long>{
	
	

}
