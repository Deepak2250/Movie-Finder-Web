package com.moviefindercontrollers.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviefindercontrollers.model.MovieFinderUser;
import com.moviefindercontrollers.model.MovieFinderUserImp;

@Service
public class MovieFinderService {

	@Autowired
	private MovieFinderUserImp finderUserImp;

	@Transactional
	public int addUser(MovieFinderUser finderUser) {
		System.out.println("it passed the service layer");
		return finderUserImp.saveUser(finderUser);
	}

	@Transactional
	public int modifyUser(MovieFinderUser finderUser) {
		return finderUserImp.updateUser(finderUser);
	}

	public Long getUserId(String email) {
		return finderUserImp.userID(email);
	}

	public int delete(String email) {
		return finderUserImp.deleteUser(email);
	}

}
