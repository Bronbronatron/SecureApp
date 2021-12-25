package com.bron.demoJPA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bron.demoJPA.appuser.AppUser;


public interface AppUserService {
	
	List<AppUser> getAllAppUser();

	AppUser getAppUserById(long id);

	void saveAppUserById(AppUser user);
	
	public void deleteAppUserById(long id);

}
