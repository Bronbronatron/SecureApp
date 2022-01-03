package com.bron.demoJPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bron.demoJPA.appuser.AppUser;
import com.bron.demoJPA.repository.AppUserRepository;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	AppUserRepository userRepository;

	@Override
	public List<AppUser> getAllAppUser() {

		return userRepository.findAll();
	}

	@Override
	public AppUser getAppUserById(long id) {

		Optional<AppUser> optional = userRepository.findById(id);
		AppUser user = null;
		if (optional.isPresent()) {
			user = optional.get();
		} else {
			throw new RuntimeException("AppUser not found for: " + id);
		}
		return user;
	}

	@Override
	public void saveAppUserById(AppUser user) {
		this.userRepository.save(user);

	}

	@Override
	public void deleteAppUserById(long id) {
		this.userRepository.deleteById(id);
	}

}
