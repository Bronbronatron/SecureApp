package com.bron.demoJPA.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bron.demoJPA.appuser.AppUser;
import com.bron.demoJPA.appuser.Dish;
import com.bron.demoJPA.specification.DishSearch;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long>, JpaSpecificationExecutor<Dish>{
	  @Transactional
	    @Modifying
		@Query(
				value = "select * from dish d where rest_id= ?1", nativeQuery = true
				)
	List<Dish> getDishByRestaurantID(Long id);

	List<Dish> findAll(Specification<Dish> spec);

  
}


