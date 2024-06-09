package com.moviefindercontrollers.model;

public class MovieFinderUser {

	private String name;

	private String email;

	private String password;

	private String favouriteMovie; // Changed from favoriteMovie

	private String favouriteGenre; // Changed from favoriteGenre

	public MovieFinderUser() {
	}

	public MovieFinderUser(String name, String email, String password, String favouriteMovie, String favouriteGenre) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.favouriteMovie = favouriteMovie;
		this.favouriteGenre = favouriteGenre;
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
	
	@Override
	public String toString() {
		return "MovieFinderUserPojo [name=" + name + ", email=" + email + ", password=" + password + ", favouriteMovie="
				+ favouriteMovie + ", favouriteGenre=" + favouriteGenre + "]";
	}

}
