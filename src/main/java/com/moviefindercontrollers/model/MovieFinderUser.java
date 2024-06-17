package com.moviefindercontrollers.model;

import java.util.Arrays;

public class MovieFinderUser {

	private Long id;

	private String name;

	private String email;

	private String password;

	private String favouriteMovie; // Changed from favoriteMovie

	private String favouriteGenre; // Changed from favoriteGenre

	private byte[] image;

	public MovieFinderUser() {
	}

	public MovieFinderUser(String name, String email, String password, String favouriteMovie, String favouriteGenre,
			byte[] image) {

		this.name = name;
		this.email = email;
		this.password = password;
		this.favouriteMovie = favouriteMovie;
		this.favouriteGenre = favouriteGenre;
		this.image = image;
	}

	public MovieFinderUser(String name, String favouriteMovie, String favouriteGenre , Long id , byte[] image) {

		this.name = name;
		this.favouriteMovie = favouriteMovie;
		this.favouriteGenre = favouriteGenre;
		this.id = id;
		this.image = image;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFavouriteMovie() { // Changed from getFavoriteMovie
		return favouriteMovie;
	}

	public void setFavouriteMovie(String favouriteMovie) { // Changed from setFavoriteMovie
		this.favouriteMovie = favouriteMovie;
	}

	public String getFavouriteGenre() { // Changed from getFavoriteGenre
		return favouriteGenre;
	}

	public void setFavouriteGenre(String favouriteGenre) { // Changed from setFavoriteGenre
		this.favouriteGenre = favouriteGenre;
	}

}
