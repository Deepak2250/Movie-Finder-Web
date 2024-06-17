package com.moviefindercontrollers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

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
    
        
       
        try {
        movieDetails.setName(jsonObject.has("Title") ? jsonObject.get("Title").getAsString() : "Null");
        movieDetails.setYear(jsonObject.has("Year") ? jsonObject.get("Year").getAsString() : "Null");
        movieDetails.setRated(jsonObject.has("Rated") ? jsonObject.get("Rated").getAsString() : "Null");
        movieDetails.setReleased(jsonObject.has("Released") ? jsonObject.get("Released").getAsString() : "Null");
        movieDetails.setGenere(jsonObject.has("Genre") ? jsonObject.get("Genre").getAsString().split(", ") : new String[]{"Null"});
        movieDetails.setDirector(jsonObject.has("Director") ? jsonObject.get("Director").getAsString() : "Null");
        movieDetails.setWriter(jsonObject.has("Writer") ? jsonObject.get("Writer").getAsString() : "Null");
        movieDetails.setActors(jsonObject.has("Actors") ? jsonObject.get("Actors").getAsString().split(", ") : new String[]{"Null"});
        movieDetails.setPlot(jsonObject.has("Plot") ? jsonObject.get("Plot").getAsString() : "Null");
        movieDetails.setAwards(jsonObject.has("Awards") ? jsonObject.get("Awards").getAsString() : "Null");
        movieDetails.setImg(jsonObject.has("Poster") ? jsonObject.get("Poster").getAsString() : "Null");
        movieDetails.setImdb(jsonObject.has("imdbRating") ? jsonObject.get("imdbRating").getAsString() : "Null");

    } catch (HttpClientErrorException e) {
    	
        throw new ApiException("HTTP error occurred: " + e.getStatusCode(), e);
        
    } catch (RestClientException e) {
    	
        throw new ApiException("Error occurred while calling the API: " + e.getMessage(), e);
        
    } catch (JsonSyntaxException e) {
    	
        throw new ApiException("Error parsing JSON response: " + e.getMessage(), e);
        
    } 

        
       

        return movieDetails;
    }
}
