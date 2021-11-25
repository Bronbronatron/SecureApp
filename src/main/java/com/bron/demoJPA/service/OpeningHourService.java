package com.bron.demoJPA.service;

import com.bron.demoJPA.appuser.Dish;
import com.bron.demoJPA.appuser.OpeningHour;

public interface OpeningHourService {

	 void saveOpeningHourWithUserId(OpeningHour open);
	 
	 void saveDish(OpeningHour open);
}
