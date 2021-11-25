package com.bron.demoJPA.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bron.demoJPA.appuser.OpeningHour;


@Repository
public interface OpeningHourRepository extends JpaRepository<OpeningHour, Long> {

	
	

}