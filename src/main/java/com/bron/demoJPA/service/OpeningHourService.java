package com.bron.demoJPA.service;


import java.util.List;

import com.bron.demoJPA.appuser.AppUser;
import com.bron.demoJPA.appuser.OpeningHour;

public interface OpeningHourService {

    void saveOpeningHourWithUserId(OpeningHour open);
	 
	void saveOpeningHour(OpeningHour open);
	 
	OpeningHour getOpeningHourByOpeningHourID(long openingHourID);

	
	  
	List<OpeningHour> getAllOpeningHour();
	  
}
