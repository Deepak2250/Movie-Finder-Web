package com.moviefindercontrollers.database;

public interface Dao {

	int saveUser(MovieFinderUser finderUser);
	MovieFinderUser findByEmail(String email);
}
