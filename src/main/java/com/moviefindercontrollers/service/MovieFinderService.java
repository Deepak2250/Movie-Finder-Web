package com.moviefindercontrollers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviefindercontrollers.model.MovieFinderUser;
import com.moviefindercontrollers.model.MovieFinderUserImp;


@Service
public class MovieFinderService {

	@Autowired
	private MovieFinderUserImp finderUserImp;
	

	public int addUser(MovieFinderUser finderUser) {
		System.out.println("it passed the service layer");
		return finderUserImp.saveUser(finderUser);
	}
}
