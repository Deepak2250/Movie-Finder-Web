package com.moviefindercontrollers.model;

public interface Dao {

	int saveUser(MovieFinderUser finderUser);
	
	MovieFinderUser findByEmail(String email);
	
	int updateUser(MovieFinderUser finderUser);
	
	int deleteUser(String email);
		
	Long userID(String email);
}
