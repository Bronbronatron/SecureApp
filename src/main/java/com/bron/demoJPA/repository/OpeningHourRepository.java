package com.bron.demoJPA.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bron.demoJPA.appuser.Dish;
import com.bron.demoJPA.appuser.OpeningHour;


@Repository
public interface OpeningHourRepository extends JpaRepository<OpeningHour, Long> {


	   @Transactional
	   @Modifying
	   @Query(
				value = "select * from opening_hour_info o where rest_id= ?1", nativeQuery = true
				)
	  List<OpeningHour> getOpeningHourByRestaurantID(Long id);


}