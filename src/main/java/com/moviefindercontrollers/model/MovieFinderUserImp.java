package com.moviefindercontrollers.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MovieFinderUserImp implements Dao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private MovieFinderUser finderUser;
	
	public MovieFinderUserImp() {
		this.finderUser = new MovieFinderUser();
	}
	
	
	
	@Override
	public int saveUser(MovieFinderUser finderUser) {
		String query = "INSERT INTO moviefinderuser (name, email, passoword , favouriteMovie , favouriteGenre , image) VALUES (?, ?, ? , ?, ? , ?)";
		int updatedLine = jdbcTemplate.update(query,finderUser.getName() , finderUser.getEmail(), finderUser.getPassword() , finderUser.getFavouriteMovie() , finderUser.getFavouriteGenre() , finderUser.getImage());
		System.out.println("It Passed THe Repo layer");
		return updatedLine;
	}


	@Override
    public MovieFinderUser findByEmail(String email) {
        String query = "SELECT * FROM moviefinderuser WHERE email = ?";
        try {
            return jdbcTemplate.queryForObject(query, new RowMapperObj(), email);
        } catch (EmptyResultDataAccessException e) {
            return null; // Return null if no user is found
        }
    }

	@Override
	public int updateUser(MovieFinderUser finderUser) {
		String query = "Update moviefinderuser Set name = ? , favouriteMovie = ? , favouriteGenre = ? WHERE id = ?";
		Object [] data = {finderUser.getName() , finderUser.getFavouriteMovie() , finderUser.getFavouriteGenre() , finderUser.getId()};
		int updatedLine = jdbcTemplate.update(query, data);
		return updatedLine;
	}


	@Override
	public int deleteUser(String email) {
		String query = "Delete from moviefinderuser where email = ?";
		return jdbcTemplate.update(query , email);
		
	}



	@Override
	public Long userID(String email) {
		String query = "Select id from moviefinderuser where email = ?";
		Long finderUser = jdbcTemplate.queryForObject(query, new IdRowMapper() , email);
		return finderUser;
	}




}
