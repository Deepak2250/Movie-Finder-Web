package com.moviefindercontrollers.service;



public class MovieDetails {

	private String name;
	private int year;
	private String rated;
	private String released;
	private String[] genere;
	private String director;
	private String writer;
	private String[] actors;
	private String plot;
	private String awards;
	private String img;
	private String imdb;

	public MovieDetails(String name, int year, String rated, String released, String[] genere, String director,
			String writer, String[] actors, String plot, String awards, String img, String imdb) {
		
		this.name = name;
		this.year = year;
		this.rated = rated;
		this.released = released;
		this.genere = genere;
		this.director = director;
		this.writer = writer;
		this.actors = actors;
		this.plot = plot;
		this.awards = awards;
		this.img = img;
		this.imdb = imdb;
	}

	public MovieDetails() {
		super();
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String[] getGenere() {
		return genere;
	}

	public void setGenere(String[] genere) {
		this.genere = genere;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String[] getActors() {
		return actors;
	}

	public void setActors(String[] actors) {
		this.actors = actors;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

}
