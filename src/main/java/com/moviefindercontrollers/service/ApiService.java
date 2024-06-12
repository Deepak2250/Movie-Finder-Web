package com.moviefindercontrollers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.github.cdimascio.dotenv.Dotenv;

@Service
public class ApiService {

	private String apiKey;

	private static final String BASE_URL = "http://www.omdbapi.com/";
	
	private final RestTemplate restTemplate;
	private final MovieDetails movieDetails;
	private  Dotenv config;
	@Autowired
    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
		this.movieDetails = new MovieDetails();
		this.config = Dotenv.configure().load();
        this.apiKey = config.get("apikey");
    }
	
	public MovieDetails fetchDataFromApi(String parameter) {
		
        String url = BASE_URL + "?apikey=" + apiKey + "&t=" + parameter + "&plot=full";
        
        Gson gson = new Gson();
        String jsonResponse = restTemplate.getForObject(url, String.class);
        System.out.println(jsonResponse);
        JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);
    
        
       
        
        if (jsonObject.has("Title")) {
            movieDetails.setName(jsonObject.get("Title").getAsString());
        }
        if (jsonObject.has("Year")) {
            movieDetails.setYear(jsonObject.get("Year").getAsString());
        }
        if (jsonObject.has("Rated")) {
            movieDetails.setRated(jsonObject.get("Rated").getAsString());
        }
        if (jsonObject.has("Released")) {
            movieDetails.setReleased(jsonObject.get("Released").getAsString());
        }
        if (jsonObject.has("Genre")) {
            movieDetails.setGenere(jsonObject.get("Genre").getAsString().split(", "));
        }
        if (jsonObject.has("Director")) {
            movieDetails.setDirector(jsonObject.get("Director").getAsString());
        }
        if (jsonObject.has("Writer")) {
            movieDetails.setWriter(jsonObject.get("Writer").getAsString());
        }
        if (jsonObject.has("Actors")) {
            movieDetails.setActors(jsonObject.get("Actors").getAsString().split(", "));
        }
        if (jsonObject.has("Plot")) {
            movieDetails.setPlot(jsonObject.get("Plot").getAsString());
        }
        if (jsonObject.has("Awards")) {
            movieDetails.setAwards(jsonObject.get("Awards").getAsString());
        }
        if (jsonObject.has("Poster")) {
            movieDetails.setImg(jsonObject.get("Poster").getAsString());
        }
        if (jsonObject.has("imdbRating")) {
            movieDetails.setImdb(jsonObject.get("imdbRating").getAsString());
        }
        
       

        return movieDetails;
    }
}
