package com.moviefindercontrollers.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MovieFinderUserImp implements Dao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int saveUser(MovieFinderUser finderUser) {
		String query = "INSERT INTO moviefinderuser (name, email, passoword , favouriteMovie , favouriteGenre) VALUES (?, ?, ? , ?, ?)";
		int updatedLine = jdbcTemplate.update(query,finderUser.getName() , finderUser.getEmail(), finderUser.getPassword() , finderUser.getFavouriteMovie() , finderUser.getFavouriteGenre());
		System.out.println("It Passed THe Repo layer");
		return updatedLine;
	}


	@Override
	public MovieFinderUser findByEmail(String email) {
		String query = "SELECT * FROM moviefinderuser where email = ?";
		MovieFinderUser finderUser = jdbcTemplate.queryForObject(query, new RowMapperObj() ,email );
		return finderUser;
	}

}
