package com.moviefindercontrollers.model;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotEmpty;


public class MovieFinderUserPojo {
	
	
	
	private Long id;
	
	@NotEmpty(message = "Name is Required")
	private String name;
	
	@NotEmpty(message = "Email is Required")
	@Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$" , message = "Please Give The Valid Email Id")
	
	private String email;
	
	@NotEmpty(message = "Password is Required")
	private String password;
	
	@NotEmpty(message = "favoriteMovie is Required")
	private String favouriteMovie;

	@NotEmpty(message = "favoriteGenre is Required")
	private String favouriteGenre;

	
	private byte[] image;
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}



}
