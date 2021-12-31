package com.bron.demoJPA.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.bron.demoJPA.appuser.AppUser;
import com.bron.demoJPA.appuser.Dish;
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
	public void saveOpeningHour(OpeningHour open) {
		 openingHourRepository.save(open);
	}
	
	
	@Override
	public OpeningHour getOpeningHourByOpeningHourID(long openingHourID) {
		Optional<OpeningHour> optional = openingHourRepository.findById(openingHourID);
		OpeningHour openingHour = null;
		if (optional.isPresent()) {
			openingHour= optional.get();
		} else {
			throw new RuntimeException("Opening Hour not found for: " + openingHourID);
		}
		return openingHour;
			}

	@Override
	public List<OpeningHour> getAllOpeningHour() {
		return  openingHourRepository.findAll();
	}

}