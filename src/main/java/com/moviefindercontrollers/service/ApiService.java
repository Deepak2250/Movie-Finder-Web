package com.moviefindercontrollers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

	
	private static final String API_KEY = "769442da";
    private static final String BASE_URL = "http://www.omdbapi.com/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String fetchDataFromApi(String parameter) {
        String url = BASE_URL + "?apikey=" + API_KEY + "&t=" + parameter + "&plot=full";
        
        return restTemplate.getForObject(url, String.class);
    }
}
