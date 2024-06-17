package com.moviefindercontrollers.model;

import javax.validation.constraints.NotEmpty;

public class UpdateUserPojo {

private Long id;
	
	@NotEmpty(message = "Name is Required")
	private String name;
	
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
