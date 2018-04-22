package com.gaimanhub.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.gaimanhub.service.json.openlibrary.OpenLibraryResponse;

@Component
public class OpenLibraryClient {
	private String url = "http://openlibrary.org/search.json?author=Gaiman";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public OpenLibraryResponse getAllGaiman(){
		return restTemplate.getForObject(url, OpenLibraryResponse.class);
	}
	
	public OpenLibraryResponse searchGaiman(String bookName){

		return restTemplate.getForObject(url+"&title={bookName}", OpenLibraryResponse.class,bookName);
	}
	

}
