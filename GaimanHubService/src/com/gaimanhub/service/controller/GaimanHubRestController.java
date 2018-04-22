package com.gaimanhub.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaimanhub.service.client.OpenLibraryClient;
import com.gaimanhub.service.json.Book;
import com.gaimanhub.service.json.GaimanHubServiceResponse;
import com.gaimanhub.service.json.openlibrary.OpenLibraryBook;
import com.gaimanhub.service.json.openlibrary.OpenLibraryResponse;

@RestController
@RequestMapping("/books")
public class GaimanHubRestController {

	// Logger instance
	private static final Logger logger = LogManager.getLogger(GaimanHubRestController.class);
	
	@Autowired
	private OpenLibraryClient serviceClient;

	@RequestMapping(value = "/search", method = RequestMethod.GET,
					headers = {"Accept=application/json"})
	public @ResponseBody GaimanHubServiceResponse getList(@RequestParam("name") String name) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("Start getList");
			logger.debug("name: '" + name + "'");
		}
		
		
		OpenLibraryResponse olResponse = serviceClient.searchGaiman(name);
		GaimanHubServiceResponse response = mapServiceResponse(olResponse);
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("result: '" + response + "'");
			logger.debug("End getList");
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET,
					headers = {"Accept=application/json"})
		public @ResponseBody GaimanHubServiceResponse getAll() {
		
		if (logger.isDebugEnabled()) {
			logger.debug("Start getList");
		}
		
		
		OpenLibraryResponse olResponse = serviceClient.getAllGaiman();
		GaimanHubServiceResponse response = mapServiceResponse(olResponse);
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("result: '" + response + "'");
			logger.debug("End getList");
		}
		return response;
	}
	
	private GaimanHubServiceResponse mapServiceResponse(OpenLibraryResponse olResponse){
		GaimanHubServiceResponse ghResponse = new GaimanHubServiceResponse();
		Book book;
		List<Book> books = new ArrayList<Book>();
		for(OpenLibraryBook result:olResponse.getDocs()){
			book = new Book();
			book.setAuthors("");
			for(String name:result.getAuthor_name()){
				book.setAuthors(book.getAuthors() + name + " & ");
			}
			book.setAuthors(
					book.getAuthors().substring(0, book.getAuthors().length() -3)
			);
			if(result.getIsbn() != null)
				book.setIsbn(result.getIsbn().get(0));
			else book.setIsbn("");
			if(result.getSeed() != null)
				book.setOpenLibraryLink("http://openlibrary.org" + result.getSeed().get(0));
			else book.setOpenLibraryLink("http://openlibrary.org");
			book.setOriginalPublishDate(result.getFirst_publish_year());
			if(result.getPublisher() != null)
				book.setPublisher(result.getPublisher().get(0));
			else book.setPublisher("");
			book.setTitle(result.getTitle());
			if(result.getSubtitle() != null)
				book.setTitle(book.getTitle() + ": " + result.getSubtitle());
			books.add(book);
		}
		ghResponse.setBooks(books);
		return ghResponse;
	}

	
}
