package com.moviefindercontrollers.model;

public interface Dao {

	int saveUser(MovieFinderUser finderUser);
	
	MovieFinderUser findByEmail(String email);
	
	MovieFinderUser FindImage(String email);
	
}
