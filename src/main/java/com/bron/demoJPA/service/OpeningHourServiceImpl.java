package com.bron.demoJPA.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.bron.demoJPA.appuser.AppUser;
import com.bron.demoJPA.appuser.OpeningHour;
import com.bron.demoJPA.repository.OpeningHourRepository;

@Service
public class OpeningHourServiceImpl implements OpeningHourService {
	
	@Autowired
	private OpeningHourRepository openingHourRepository;

	@Override
	public void saveOpeningHourWithUserId(OpeningHour openinghour) {
			Object principal = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			AppUser app = openinghour.getAppUser();
			app = (AppUser) principal;
			openinghour.setAppUser(app);
			openingHourRepository.save(openinghour);
			
		}

	@Override
	public void saveDish(OpeningHour open) {
		 openingHourRepository.save(open);
		
	}
	
	}
	
	

