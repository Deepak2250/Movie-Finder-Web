package com.moviefindercontrollers.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperObj implements RowMapper<MovieFinderUser> {

	@Override
	public MovieFinderUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		MovieFinderUser finderUser = new MovieFinderUser();
		
		finderUser.setId(rs.getLong("id"));
		finderUser.setName(rs.getString("name"));
		finderUser.setEmail(rs.getString("email"));
		finderUser.setPassword(rs.getString("passoword"));
		finderUser.setFavouriteMovie(rs.getString("favouriteMovie"));
		finderUser.setFavouriteGenre(rs.getString("favouriteGenre"));
		finderUser.setImage(rs.getBytes("image"));
		return finderUser;
	}

}
